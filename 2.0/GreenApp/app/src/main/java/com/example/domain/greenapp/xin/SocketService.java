package com.example.domain.greenapp.xin;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TabHost;
import android.widget.Toast;

//import com.yzq.socketdemo.common.Constants;
//import com.yzq.socketdemo.common.EventMsg;
//
//import org.greenrobot.eventbus.EventBus;

import com.example.domain.greenapp.Activity.MainActivity;
import com.example.domain.greenapp.Fragment.ShouyeFragment;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.check_net.MyReceiver;
import com.example.domain.greenapp.network.URL;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by yzq on 2017/9/26.
 * <p>
 * socket连接服务
 */
public class SocketService extends Service {

    /*socket*/
    private Socket socket;
    /*连接线程*/
    private Thread connectThread;
    private Timer timer = new Timer();
    private OutputStream outputStream;

    private SocketBinder sockerBinder = new SocketBinder();
    private String ip;
    private String port;
    private TimerTask task;
    private int a=0;
    public static SocketService socketService;

    /*默认重连*/
    private boolean isReConnect = true;
    private Handler handler = new Handler(Looper.getMainLooper());


    @Override
    public IBinder onBind(Intent intent) {
        return sockerBinder;
    }


    public class SocketBinder extends Binder {

        /*返回SocketService 在需要的地方可以通过ServiceConnection获取到SocketService  */
        public SocketService getService() {
            return SocketService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        socketService=this;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        setForeground();
//        URL url=new URL();
        /*拿到传递过来的ip和端口号*/
        ip = intent.getStringExtra("192.168.137.103");
        port = intent.getStringExtra("54321");

        /*初始化socket*/
        initSocket();

        return super.onStartCommand(intent, flags, startId);
    }
    @TargetApi(26)
    private void setForeground(){
        //Uri uri= Settings.System.DEFAULT_NOTIFICATION_URI;
        NotificationManager manager=(NotificationManager)getSystemService (NOTIFICATION_SERVICE);
        NotificationChannel channel=new NotificationChannel ("channel_2","报警通知1",NotificationManager.IMPORTANCE_DEFAULT);
        //channel.setSound(uri,Notification.AUDIO_ATTRIBUTES_DEFAULT);
        //channel.enableVibration(true);
        //channel.setVibrationPattern(new long[]{1000,3000,2000,4000});
        manager.createNotificationChannel (channel);
        Notification notification=new Notification.Builder (this,"channel_2")
                //.setSmallIcon (R.mipmap.green)
                //.setLargeIcon (BitmapFactory.decodeResource (getResources (),R.mipmap.green))
                .setAutoCancel(true)
                .setChannelId("channel_2")
                .build ();

        startForeground(1,notification);
    }

    /*初始化socket*/
    public void initSocket() {
        com.example.domain.greenapp.network.URL url=new URL();
        ip=url.SocketURL;
        port="54321";
        if (socket == null && connectThread == null) {
            connectThread = new Thread(new Runnable() {
                @Override
                public void run() {

                    socket = new Socket();
                    try {
                        /*超时时间为2秒*/
                        socket.connect(new InetSocketAddress(ip, Integer.valueOf(port)), 2000);
                        /*连接成功的话  发送心跳包*/
                        if (socket.isConnected()) {


                            /*因为Toast是要运行在主线程的  这里是子线程  所以需要到主线程哪里去显示toast*/
                            toastMsg("socket已连接");
                            Message msg = new Message();
                            //给message对象赋值
                            msg.what = 1;
                            //发送message值给Handler接收
                            mHandler.sendMessage(msg);
                            /*发送连接成功的消息*/
//                            Toast.makeText(MainActivity.mactivity, "socket已连接", Toast.LENGTH_SHORT).show();
//                            EventMsg msg = new EventMsg();
//                            msg.setTag(Constants.CONNET_SUCCESS);
//                            EventBus.getDefault().post(msg);
                            /*发送心跳数据*/
                            sendBeatData();
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                        if (e instanceof SocketTimeoutException) {
                            toastMsg("连接超时，正在重连");

                            releaseSocket();

                        } else if (e instanceof NoRouteToHostException) {
                            toastMsg("该地址不存在，请检查");
                            //stopSelf();

                        } else if (e instanceof ConnectException) {
                            toastMsg("连接异常或被拒绝，请检查");
                            //stopSelf();

                        }


                    }

                }
            });

            /*启动连接线程*/
            connectThread.start();

        }


    }
    Handler mHandler = new Handler() {
        //pmui线程
        public void handleMessage(Message msg) {
            // 更新UI
            switch (msg.what) {

                case 1:
                    ShouyeFragment.shouyeFragment.hj=new ArrayList<String>();
                    ShouyeFragment.shouyeFragment.doPost();
                    break;
            }

        };
    };
    /*因为Toast是要运行在主线程的   所以需要到主线程哪里去显示toast*/
    private void toastMsg(final String msg) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }


    /*发送数据*/
    public void sendOrder(final String order) {
        if (socket != null && socket.isConnected()) {
            /*发送指令*/
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        outputStream = socket.getOutputStream();
                        if (outputStream != null) {
                            outputStream.write((order).getBytes("gbk"));
                            outputStream.flush();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();

        } else {
            toastMsg("socket连接错误,请重试");
        }
    }

    /*定时发送数据*/
    private void sendBeatData() {
        if (timer == null) {
            timer = new Timer();
        }

        if (task == null) {
            task = new TimerTask() {
                @Override
                public void run() {
                    try {
                        outputStream = socket.getOutputStream();

                        /*这里的编码方式根据你的需求去改*/
                        outputStream.write(("test").getBytes("gbk"));
                        outputStream.flush();
                    } catch (Exception e) {
                        /*发送失败说明socket断开了或者出现了其他错误*/
                        toastMsg("连接断开，正在重连");
                        /*重连*/
                        releaseSocket();
                        e.printStackTrace();


                    }
                }
            };
        }

        timer.schedule(task, 0, 2000);
    }


    /*释放资源*/
    private void releaseSocket() {

        if (task != null) {
            task.cancel();
            task = null;
        }
        if (timer != null) {
            timer.purge();
            timer.cancel();
            timer = null;
        }

        if (outputStream != null) {
            try {
                outputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            outputStream = null;
        }

        if (socket != null) {
            try {
                socket.close();

            } catch (IOException e) {
            }
            socket = null;
        }

        if (connectThread != null) {
            connectThread = null;
        }

        /*重新初始化socket*/
        if (isReConnect) {
            initSocket();
        }

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("SocketService", "onDestroy");
        isReConnect = false;
        releaseSocket();
        //stopForeground(true);
    }
}
