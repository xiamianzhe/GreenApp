package com.example.domain.greenapp.Service;

import android.annotation.TargetApi;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;

import com.example.domain.greenapp.Activity.MainActivity;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.check_net.MyReceiver;

public class JiantingService extends Service {
    public static JiantingService jiantingService;
    public JiantingService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        super.onCreate ();
        jiantingService=this;
        if(Build.VERSION.SDK_INT>=26){
            setForeground();
        }else{

        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy ();
        stopForeground(true);
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        return super.onStartCommand (intent,flags,startId);
    }

    @TargetApi(26)
    private void setForeground(){
        //Uri uri= Settings.System.DEFAULT_NOTIFICATION_URI;
        Intent intent=new Intent(this, MyReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
        NotificationManager manager=(NotificationManager)getSystemService (NOTIFICATION_SERVICE);
        NotificationChannel channel=new NotificationChannel ("channel_1","报警通知",NotificationManager.IMPORTANCE_DEFAULT);
        //channel.setSound(uri,Notification.AUDIO_ATTRIBUTES_DEFAULT);
        channel.enableVibration(true);
        channel.setVibrationPattern(new long[]{1000,3000,2000,4000});
        manager.createNotificationChannel (channel);
        Notification notification=new Notification.Builder (this,"channel_1")
                .setContentTitle ("检测到车间环境存在风险")
                .setContentText ("请尽快处理")
                .setSmallIcon (R.mipmap.green)
                .setLargeIcon (BitmapFactory.decodeResource (getResources (),R.mipmap.green))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setChannelId("channel_1")
                .build ();

       startForeground(1,notification);
    }
}
