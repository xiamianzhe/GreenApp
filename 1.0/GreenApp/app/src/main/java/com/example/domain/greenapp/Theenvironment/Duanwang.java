package com.example.domain.greenapp.Theenvironment;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.domain.greenapp.Activity.LoginActivity;
import com.example.domain.greenapp.Activity.MainActivity;
import com.example.domain.greenapp.Activity.SettingActivity;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.check_net.NetWorkStateReceiver;
import com.example.domain.greenapp.check_net.twonetwork;

public class Duanwang extends AppCompatActivity {

    private com.example.domain.greenapp.check_net.twonetwork twonetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duanwang);
    }
    //在onResume()方法注册
    //断网后自动连接
    @Override
    protected void onResume() {
        if (twonetwork == null) {
            twonetwork = new twonetwork();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(twonetwork, filter);
        System.out.println("注册");
        super.onResume();
    }

    //onPause()方法注销
    @Override
    protected void onPause() {
        unregisterReceiver(twonetwork);
        System.out.println("注销");
        super.onPause();
    }
}
