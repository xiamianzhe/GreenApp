package com.example.domain.greenapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.domain.greenapp.R;

public class NullActivity extends AppCompatActivity {
    private Toolbar null_title;
    private ImageView null_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_null);
        null_title=(Toolbar)findViewById(R.id.null_title);
        null_back=(ImageView)findViewById(R.id.null_back);
        null_title.setTitle("");
        setSupportActionBar(null_title);
        null_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            finish();  //finish当前activity
            overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
        }
        return super.onKeyDown(keyCode, event);
    }
}
