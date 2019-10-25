package com.example.domain.greenapp.Activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.domain.greenapp.R;

public class MymsgActivity extends AppCompatActivity {
    private Toolbar mymsg_title;
    private ImageView mymsg_back;
    EditText mymsg_name;
    TextView mymsg_gonghao;
    TextView mymsg_time;
    TextView mymsg_zhiwu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymsg);
        setSupportActionBar(mymsg_title);
        mymsg_title=(Toolbar)findViewById(R.id.mymsg_title);
        mymsg_back=(ImageView)findViewById(R.id.mymsg_back);
        mymsg_title=(Toolbar)findViewById(R.id.mymsg_title);
        mymsg_back=(ImageView)findViewById(R.id.mymsg_back);
        mymsg_name=(EditText)findViewById(R.id.mymessage_tv_username);
        mymsg_gonghao=(TextView)findViewById(R.id.mymessage_tv_gonghao);
        mymsg_time=(TextView)findViewById(R.id.mymessage_tv_time);
        mymsg_zhiwu=(TextView)findViewById(R.id.mymessage_tv_job);
        mymsg_title.setTitle("");
        setSupportActionBar(mymsg_title);
        setSupportActionBar(mymsg_title);
        mymsg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
            }
        });
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        String name=pref.getString("Name","");
        mymsg_name.setText(name);
        String gonghao=pref.getString("Shohin_gonghao","");
        mymsg_gonghao.setText(gonghao);
        String time=pref.getString("Ruzhishijian","");
        mymsg_time.setText(time);
        String zw=pref.getString("zhiwu","");
        mymsg_zhiwu.setText(zw);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            finish();  //finish当前activity
            overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
        }
        return super.onKeyDown(keyCode, event);
    }

}
