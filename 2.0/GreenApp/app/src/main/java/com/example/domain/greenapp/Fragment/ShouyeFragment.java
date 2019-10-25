package com.example.domain.greenapp.Fragment;


import android.os.Build;
import android.os.Message;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.domain.greenapp.Activity.CjchooseActivity;
import com.example.domain.greenapp.Activity.LoginActivity;
import com.example.domain.greenapp.Activity.MainActivity;
import com.example.domain.greenapp.Activity.NullActivity;
import com.example.domain.greenapp.Activity.UsezhinanActivity;
import com.example.domain.greenapp.Dao.limitBean;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.Service.JiantingService;
import com.example.domain.greenapp.hkmonitor_3813.HKActivity;
import com.example.domain.greenapp.network.URL;
import com.example.domain.greenapp.network.limitData;
import com.example.domain.greenapp.xin.SocketService;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.google.gson.Gson;
import com.hb.dialog.dialog.LoadingDialog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ShouyeFragment extends Fragment implements ObservableScrollViewCallbacks {
    private FloatingActionButton fabtn;
    private RelativeLayout shouye_relative02;
    private RelativeLayout to_usehelp;
    public static TextView shouye_wd,shouye_sd,shouye_pm,shouye_hj,cjbaianh;
    private  String max_wd,min_wd,max_sd,min_sd,max_pm;//limit
    private String wd,sd,pm;//dopost
    private ImageView imgwen,imgsd,imgpm;
    private String URL;
    public static List<String> hj=new ArrayList<String>();
    public Button btn_go;
    private Button hk;
    private  String ruan1,ruan2,ruan3,dq;//pm,温度,湿度
    public static  String cj;//title车间号
    public static ArrayList<String> s = new ArrayList<String>();
    int min;
    public static ShouyeFragment shouyeFragment;
    private boolean stopThread1=false;
    private boolean stopThread2=false;
    private boolean stopThread3=false;
    int nud=1;
    int xint=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_shouye, container, false);

        String zw=this.getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).getString("zhiwu","");
        shouye_wd=view.findViewById(R.id.shouye_tv_wendu);
        shouye_sd=view.findViewById(R.id.shouye_tv_shidu);
        shouye_pm=view.findViewById(R.id.shouye_tv_pm);
        shouye_hj=view.findViewById(R.id. hjfenxi);
        to_usehelp=view.findViewById(R.id.shouye_par);
        imgwen=view.findViewById(R.id.shouye_iv_wendu1);
        imgsd=view.findViewById(R.id.shouye_iv_shidu1);
        imgpm=view.findViewById(R.id.shouye_iv_pm1);
        btn_go=view.findViewById(R.id.shouye_btn_go);
        cjbaianh=(TextView)view.findViewById(R.id.cjbaianh);
        cjbaianh.setText(cj);
        shouyeFragment=this;
        doPost();//查询最近数据
        Log.e("执行顺序1",""+111);
        setHasOptionsMenu(true);
        fabtn=view.findViewById(R.id.fabtn);
        shouye_relative02=view.findViewById(R.id.shouye_relative02);
        fabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), HKActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_left,R.anim.anim_toleft);

            }
        });
        shouye_relative02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),NullActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_left,R.anim.anim_toleft);
            }
        });
        to_usehelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), UsezhinanActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_left,R.anim.anim_toleft);
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_shouye_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.choose:
                Intent intent=new Intent();
                intent.setClass(getActivity(),CjchooseActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_left,R.anim.anim_toleft);
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }

    public void doPost(){
        com.example.domain.greenapp.network.URL url=new URL();
        final String sURL=url.SocketURL;
//        if (xint==0){
//            SocketService.socketService.initSocket();
//        }
            new Thread() {
                //pm//socket
                @Override

                public void run() {
                    super.run();
                    stopThread1=false;
                    try {
                        //1.创建监听指定服务器地址以及指定服务器监听的端口号
                        Socket socket;//111.111.11.11为我这个本机的IP地址，端口号为12306.
                        socket = new Socket(sURL, 12306);
                        Log.e("cbjsmhdgcsjDchbki","21111111111"+socket);
                        //2.拿到客户端的socket对象的输出流发送给服务器数据
                        OutputStream os = socket.getOutputStream();
                        //写入要发送给服务器的数据
                        os.write(cj.getBytes());
                        dq=cj;
                        os.flush();
                        //通过循环将服务器传回的值取出
                        while(true) {
                            //读取服务器发回的数据，使用socket套接字对象中的字节输入流
                            InputStream in = socket.getInputStream();

                            byte[] data = new byte[1024];
                            int len = in.read(data);
                            pm=new String(data,0,len);
                            ruan1=new String(data, 0, len);
                            Log.i("i----------------i", "" +new String(data, 0, len));
                            if (ruan1.equals("exit")) {
                                socket.close();
                                break;
                                //为exit时结束现场并跳出循环
                                //exit表示服务端无此数据结束连接跳出循环
                            }
                            // 构建Runnable对象，在runnable中更新界面
                            Message msg = new Message();
                            //给message对象赋值
                            msg.what = 1;
                            //发送message值给Handler接收
                            mHandler.sendMessage(msg);
                            if (stopThread1==true){
                                stopThread1=false;
                                socket.close();
                                min+=1;
                                break;
                            }
                            if (nud==2){
                                hj=new ArrayList<String>();
                                contrast();
                            }
                        }


                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            //
        new Thread() {
            //温度//socket
            @Override

            public void run() {
                super.run();
                stopThread2=false;
                try {
                    //1.创建监听指定服务器地址以及指定服务器监听的端口号
                    Socket socket;//111.111.11.11为我这个本机的IP地址，端口号为12306.
                    socket = new Socket(sURL, 12307);
                    //2.拿到客户端的socket对象的输出流发送给服务器数据
                    OutputStream os = socket.getOutputStream();
                    //写入要发送给服务器的数据
                    os.write(cj.getBytes());
                    dq=cj;
                    os.flush();
                    //通过循环将服务器传回的值取出
                    while(true) {
                        //读取服务器发回的数据，使用socket套接字对象中的字节输入流
                        InputStream in = socket.getInputStream();

                        byte[] data = new byte[1024];
                        int len = in.read(data);
                        wd=new String(data,0,len);
                        ruan2=new String(data, 0, len);
                        Log.i("i----------------i", "" +new String(data, 0, len));
                        if (ruan2.equals("exit")) {
//                            socket.close();
                            break;
                            //为exit时结束现场并跳出循环
                            //exit表示服务端无此数据结束连接跳出循环
                        }
                        if (stopThread2==true){
                            stopThread2=false;
                            socket.close();
                            min+=1;
                            break;
                        }
                        // 构建Runnable对象，在runnable中更新界面
                        Message msg2 = new Message();
                        //给message对象赋值
                        msg2.what = 1;
                        //发送message值给Handler接收
                        mHandler2.sendMessage(msg2);

                    }

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


        new Thread() {
            //温度//socket
            @Override

            public void run() {
                super.run();
                stopThread3=false;
                try {
                    //1.创建监听指定服务器地址以及指定服务器监听的端口号
                    Socket socket;//111.111.11.11为我这个本机的IP地址，端口号为12306.
                    socket = new Socket(sURL, 12308);
                    //2.拿到客户端的socket对象的输出流发送给服务器数据
                    OutputStream os = socket.getOutputStream();
                    //写入要发送给服务器的数据
                    os.write(cj.getBytes());
                    dq=cj;
                    os.flush();
                    //通过循环将服务器传回的值取出
                    while(true) {
                        //读取服务器发回的数据，使用socket套接字对象中的字节输入流
                        InputStream in = socket.getInputStream();

                        byte[] data = new byte[1024];
                        int len = in.read(data);
                        sd=new String(data,0,len);
                        ruan3=new String(data, 0, len);
                        Log.i("i----------------i", "" +new String(data, 0, len));
                        if (ruan3.equals("exit")) {
//                            socket.close();
                            break;
                            //为exit时结束现场并跳出循环
                            //exit表示服务端无此数据结束连接跳出循环
                        }

                        if (stopThread3==true){
                            stopThread3=false;
                            socket.close();
                            min+=1;
                            break;
                        }
                        // 构建Runnable对象，在runnable中更新界面
                        Message msg3 = new Message();
                        //给message对象赋值
                        msg3.what = 1;
                        //发送message值给Handler接收
                        mHandler3.sendMessage(msg3);

                    }

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
            limit();
        }
    public void qiehuan(){
        Intent intent=new Intent(CjchooseActivity.cjchooseActivity,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    Handler mHandler = new Handler() {
        //pmui线程
        public void handleMessage(Message msg) {
            // 更新UI
            switch (msg.what) {

                case 1:
                    if (ruan1 != null) {
                        if (dq==cj) {
//                        shouye_pm.setText(null);
                            shouye_pm.setText(ruan1);
                        }
                    } else {
//                        shouye_pm.setText("数据错误！");
                    }
                    break;
                case 2:
                    shouye_hj.setText("检测到" + hj + "超限");
                    break;
                case 3:
                    shouye_hj.setText("未检测到环境超限");
                    break;
            }

        };
    };

    Handler mHandler2 = new Handler() {
        //温度ui线程
        public void handleMessage(Message msg) {
            // 更新UI
            switch (msg.what) {

                case 1:
                    if (ruan1 != null) {
                        if (dq==cj) {
                            shouye_wd.setText(ruan2);
                        }
                    } else {
//                        shouye_wd.setText("数据错误！");
                    }
                    break;
            }

        };
    };

    Handler mHandler3 = new Handler() {
        //湿度ui线程
        public void handleMessage(Message msg) {
            // 更新UI
            switch (msg.what) {

                case 1:
                    if (ruan1 != null) {
                        if (dq==cj) {
                            shouye_sd.setText(ruan3);
                        }
                    } else {
//                        shouye_sd.setText("数据错误！");
                    }
                    break;
                case 5:
                    Intent intent = new Intent(getActivity(), JiantingService.class);
                    if (Build.VERSION.SDK_INT >= 26) {
                        getActivity().startForegroundService(intent);

                    } else {

                    }
                    break;
            }

        };
    };



    public void limit(){
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        limitBean limitBean=new limitBean();
        limitBean=initdata(limitBean);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(limitBean);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        limitData sxData=retrofit.create(limitData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<com.example.domain.greenapp.Dao.limitBean> call = sxData.sxFlyRoute(body);
        call.enqueue(new Callback<com.example.domain.greenapp.Dao.limitBean>() {
            @Override
            public void onResponse(Call<com.example.domain.greenapp.Dao.limitBean> call, Response<com.example.domain.greenapp.Dao.limitBean> response) {
                  if (response.body().isJieguo().equals(true)){
                    Log.e("上下限查询",""+response.body().isJieguo());
                    max_wd=response.body().getSx_shohin_wendu();
                    min_wd=response.body().getXx_shohin_wendu();
                    max_sd=response.body().getSx_shohin_shidu();
                    min_sd=response.body().getXx_shohin_shidu();
                    max_pm=response.body().getSx_pm();
                    Log.e("错误打印",""+min_wd);
                    contrast();
                }
            }

            @Override
            public void onFailure(Call<com.example.domain.greenapp.Dao.limitBean> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
    private limitBean initdata(limitBean sxBean) {//向服务端发送的值
        // TODO Auto-generated method stub
        LoginActivity login=new LoginActivity();
        String cj=login.cj;
        sxBean.setSx_pm("true");
        List<limitBean.ShjBean> pointsBeans=new ArrayList<limitBean.ShjBean>();
        limitBean.ShjBean pointsBean=new limitBean.ShjBean();
        pointsBean.setSx_pm("true");
        return sxBean;
    }
    public void contrast() {
//        hj=new ArrayList<String >();
        nud = 2;
        Log.e("执行顺序3", "" + 333);
        if (dq==cj) {
            if (wd != null && wd != "") {
                if (wd.length() > 0) {
                    if (!wd.equals("exit")) {
                        try {
                            Double w1 = Double.parseDouble(wd);
                            Double m_w1 = Double.parseDouble(max_wd);
                            Double x_w1 = Double.parseDouble(min_wd);
                            if (w1 > m_w1) {
                                hj.add("温度");
                                imgwen.setImageResource(R.mipmap.guzhangy);
                            } else if (w1 < x_w1) {
                                hj.add("温度");
                                imgwen.setImageResource(R.mipmap.guzhangy);
                            } else {
                                imgwen.setImageResource(R.mipmap.safe);
                            }
                        }catch (Exception e){
                            Log.e("乱码温度","-----"+e);
                        }

                    } else {
                        hj.add("温度");
                    }
                }
            }
        }
        if (dq==cj) {
            if (sd != null && sd != "") {
                if (sd.length() > 0) {
                    if (!sd.equals("exit")) {
                        try {
                            Double s1 = Double.parseDouble(sd);
                            Double m_s1 = Double.parseDouble(max_sd);
                            Double x_s1 = Double.parseDouble(min_sd);
                            if (s1 > m_s1) {
                                hj.add("湿度");
                                imgsd.setImageResource(R.mipmap.guzhangy);
                            } else if (s1 < x_s1) {
                                hj.add("湿度");
                                imgsd.setImageResource(R.mipmap.guzhangy);
                            } else {
                                imgsd.setImageResource(R.mipmap.safe);
                            }
                        }catch (Exception e){
                            Log.e("乱码湿度","-------"+e);
                        }

                    } else {
                        hj.add("湿度");
                    }
                }
            }
        }
        //pm是否超限判断
        if (dq==cj) {
            if (pm != null && pm != "") {
                if (pm.length() > 0) {
                    if (!pm.equals("exit")) {
                        try {
                            Double p1 = Double.parseDouble(pm);
                            Double m_p1 = Double.parseDouble(max_pm);
                            if (p1 > m_p1) {
                                hj.add("pm2.5");
                                imgpm.setImageResource(R.mipmap.guzhangy);
                            } else {
                                imgpm.setImageResource(R.mipmap.safe);
                            }
                        }catch (Exception e){
                            Log.e("乱码pm","------"+e);
                        }

                    } else {
                        hj.add("pm2.5");
                    }
                }
            }
        }
        if (dq==cj){
        if (pm != null && !pm.equals("exit") && pm != "") {
            if (wd != null && !wd.equals("exit") && wd != "") {
                if (sd != null && !sd.equals("exit") && sd != "") {
                    Log.i("hj--------exit", pm);

                    if (hj.size() > 0) {
                        Message msg3 = new Message();
                        //给message对象赋值
                        msg3.what = 5;
                        //发送message值给Handler接收
                        mHandler3.sendMessage(msg3);
//                        Intent intent = new Intent(getActivity(), JiantingService.class);
//                        if (Build.VERSION.SDK_INT >= 26) {
//                            getActivity().startForegroundService(intent);
//
//                        } else {
//
//                        }

                        Message msg = new Message();
                        //给message对象赋值
                        msg.what = 2;
                        //发送message值给Handler接收
                        mHandler.sendMessage(msg);
                        btn_go.setBackgroundResource(R.drawable.bg_button_selector);
                        btn_go.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                final LoadingDialog loadingDialog = new LoadingDialog(getActivity());
                                loadingDialog.setMessage("loading");
                                loadingDialog.show();
                                dl();
                                Integer time = 1700;    //设置等待时间，单位为毫秒
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        loadingDialog.dismiss();
                                    }
                                }, time);
                            }
                        });
                    } else {
                        Message msg = new Message();
                        //给message对象赋值
                        msg.what = 3;
                        //发送message值给Handler接收
                        mHandler.sendMessage(msg);
                        btn_go.setBackgroundResource(R.drawable.bg_button_grey);
                    }
                } else {
                    //湿度
//                    shouye_hj.setText("缺少" + hj + "数据");
                }
            } else {
                //温度
//                shouye_hj.setText("缺少" + hj + "数据");
            }
        } else {
            //pm
//            shouye_hj.setText("缺少" + hj + "数据");
        }
    }
    }
    public void dl(){
        Integer time = 1500;    //设置等待时间，单位为毫秒
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity main=(MainActivity)getActivity();
                main.goshebeiFragment();
            }
        }, time);
    }
    public void duan(){
        //停止线程
        stopThread1=true;
        stopThread2=true;
        stopThread3=true;
    }
}
