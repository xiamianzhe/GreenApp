package com.example.domain.greenapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.domain.greenapp.Fragment.ShouyeFragment;
import com.example.domain.greenapp.R;
import com.hb.dialog.dialog.ConfirmDialog;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {
    private Toolbar setting_title;
    private ImageView setting_back;
    private RelativeLayout exit;
    public static String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setting_title=(Toolbar)findViewById(R.id.setting_title);
        setting_back=(ImageView)findViewById(R.id.setting_back);
        exit=(RelativeLayout)findViewById(R.id.exit);
        setting_title.setTitle("");
        setSupportActionBar(setting_title);
        setting_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg="是否退出登录";
                tanchuan();
            }
        });
    }
    public void tanchuan(){
        ConfirmDialog confirmDialog = new ConfirmDialog(this);
        confirmDialog.setLogoImg(R.mipmap.dialog_notice).setMsg(msg);
        confirmDialog.setClickListener(new ConfirmDialog.OnBtnClickListener() {
            @Override
            public void ok() {
                ShouyeFragment.shouyeFragment.duan();
                SharedPreferences sp= getSharedPreferences("data", Context.MODE_PRIVATE);
                sp.edit().clear().commit();
//                Intent intent=new Intent(SettingActivity.this,LoginActivity.class);
//                startActivity(intent);
                ShouyeFragment.shouyeFragment.hj=new ArrayList<String>();
                Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

            @Override
            public void cancel() {

            }
        });
        confirmDialog.show();
    }
}

