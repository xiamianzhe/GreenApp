package com.example.domain.greenapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.domain.greenapp.Fragment.ShouyeFragment;
import com.example.domain.greenapp.R;


public class stateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        boolean state=pref.getBoolean("state",false);
        String zw=pref.getString("zhiwu","");
        String gh=pref.getString("Shohin_gonghao","");
        Log.e("是否登录过",""+state);
        Log.e("职务",""+zw);




        if (state==true){
            String cj;
            if (zw.equals("生产员")) {
                cj=pref.getString("cj","");
                LoginActivity login=new LoginActivity();
                login.cj=cj;
                Integer time = 1500;    //设置等待时间，单位为毫秒
                Handler handler = new Handler();
                //当计时结束时，跳转至主界面
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(stateActivity.this, MainActivity.class));
                        stateActivity.this.finish();
                    }
                }, time);
            }else {
               int i=0;
                Integer time = 1500;    //设置等待时间，单位为毫秒
                Handler handler = new Handler();
                //当计时结束时，跳转至主界面
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(stateActivity.this, MainActivity.class));
                        stateActivity.this.finish();
                    }
                }, time);
                 cj=pref.getString("cjh"+i,"");
            }
            ShouyeFragment sy=new ShouyeFragment();
            sy.cj=cj;
        }else{
            Integer time = 1500;    //设置等待时间，单位为毫秒
            Handler handler = new Handler();
            //当计时结束时，跳转至主界面
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(stateActivity.this, LoginActivity.class));
                    stateActivity.this.finish();
                }
            }, time);
        }

    }

}
