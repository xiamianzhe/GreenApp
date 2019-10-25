package com.example.domain.greenapp.Activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.example.domain.greenapp.Fragment.ShebeiFragment;
import com.example.domain.greenapp.Fragment.ShouyeFragment;
import com.example.domain.greenapp.Fragment.ShujuFragment;
import com.example.domain.greenapp.Fragment.WodeFragment;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.Theenvironment.Duanwang;
import com.example.domain.greenapp.check_net.NetWorkStateReceiver;
import com.example.domain.greenapp.xin.SocketService;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.hb.dialog.dialog.LoadingDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioGroup rg_group;
    private RadioButton rb_shouye,rb_shuju,rb_shebei,rb_wode;
    private FragmentManager manager=getSupportFragmentManager();;
    private Toolbar toolbar_title;
    private TextView tv_title;
    private ShouyeFragment shouyef;
    private ShujuFragment shujuf;
    private ShebeiFragment shebeif;
    private WodeFragment wodef;
    private Fragment currentFragment=new Fragment();
    private NetWorkStateReceiver netWorkStateReceiver;
    public static MainActivity mactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, SocketService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            this.startForegroundService(intent);

        } else {

        }
        bindView();
        initFragment();
        showFragment(shouyef);
        mactivity=this;

    }
    private void bindView(){
        rg_group=(RadioGroup)findViewById(R.id.rg_group);
        rb_shouye=(RadioButton)findViewById(R.id.rb_shouye);
        rb_shuju=(RadioButton)findViewById(R.id.rb_shuju);
        rb_shebei=(RadioButton)findViewById(R.id.rb_shebei);
        rb_wode=(RadioButton)findViewById(R.id.rb_wode);
        tv_title=(TextView) findViewById(R.id.tv_title);
        toolbar_title=(Toolbar)findViewById(R.id.toolbar_title);
        toolbar_title.setTitle("");
        setSupportActionBar(toolbar_title);
        rb_shouye.setOnClickListener(this);
        rb_shuju.setOnClickListener(this);
        rb_shebei.setOnClickListener(this);
        rb_wode.setOnClickListener(this);

    }

    private void initFragment() {
         Bundle bundle = new Bundle();
         bundle.putInt("tag", 1);
         shouyef = new ShouyeFragment();
         shouyef.setArguments(bundle);
         bundle = new Bundle();
         bundle.putInt("tag", 2);
         shujuf = new ShujuFragment();
         shujuf.setArguments(bundle);
         bundle = new Bundle();
         bundle.putInt("tag", 3);
         shebeif = new ShebeiFragment();
         shebeif.setArguments(bundle);
         bundle = new Bundle();
         bundle.putInt("tag", 4);
         wodef = new WodeFragment();
         wodef.setArguments(bundle);
    }
    public void showFragment(Fragment fragment) {
         if (currentFragment!=fragment) {
             FragmentTransaction transaction = manager.beginTransaction();
             transaction.hide(currentFragment);
             currentFragment = fragment;
             if (!fragment.isAdded()) {
                 transaction.add(R.id.layout_content, fragment).show(fragment).commit();
             } else {
                 transaction.show(fragment).commit();
             }
         }
    }
      @Override
   public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_shouye:
                showFragment(shouyef);
                tv_title.setText("监控");
                break;
            case R.id.rb_shuju:
                showFragment(shujuf);
                tv_title.setText("分析");
                 break;
            case R.id.rb_shebei:
                showFragment(shebeif);
                tv_title.setText("设备");
                 break;
            case R.id.rb_wode:
                showFragment(wodef);
                tv_title.setText("我的");
                 break;
        }
    }
    public void goshebeiFragment(){
        showFragment(shebeif);
        rb_shouye.setChecked(false);
        rb_shebei.setChecked(true);
        tv_title.setText("设备");
    }

    //在onResume()方法注册
    //断网后自动连接
    @Override
    protected void onResume() {
        if (netWorkStateReceiver == null) {
            netWorkStateReceiver = new NetWorkStateReceiver();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netWorkStateReceiver, filter);
        System.out.println("注册");
        super.onResume();
    }

    //onPause()方法注销
    @Override
    protected void onPause() {
        unregisterReceiver(netWorkStateReceiver);
        System.out.println("注销");
        super.onPause();
    }

}