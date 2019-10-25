package com.example.domain.greenapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.domain.greenapp.Adapter.ListViewAdapter;
import com.example.domain.greenapp.Dao.LinkMain;
import com.example.domain.greenapp.Fragment.ShouyeFragment;
import com.example.domain.greenapp.R;
import com.hb.dialog.dialog.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

public class CjchooseActivity extends AppCompatActivity {
    private List<LinkMain> linkMains = new ArrayList<>();
    private ListView listView;
    private ImageView back;
    LinkMain lm;
    public static CjchooseActivity cjchooseActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cjchoose);
        cjchooseActivity=this;
        //this.init();
        final ListViewAdapter myAdapter = new ListViewAdapter(this,R.layout.listview_item,linkMains);
        listView = (ListView)this.findViewById(R.id.cjchoose_lv);
        back=(ImageView)this.findViewById(R.id.cjchoose_back);
        listView.setAdapter(myAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
               overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShouyeFragment.shouyeFragment.duan();
//                dl();
                lm=linkMains.get(position);
                ShouyeFragment.shouyeFragment.cj=lm.getCj();
                ShouyeFragment.shouyeFragment.hj=new ArrayList<String>();
//                try {
//                    //跳转时间等待
//                    //初始化界面
//                    //重新加载数据
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
                ShouyeFragment.shouyeFragment.qiehuan();
            }
        });
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        String zw=pref.getString("zhiwu","");
        if (zw.equals("生产员")){
        String s=pref.getString("cj","");
        linkMains.add(new LinkMain(s));
    }else if (zw.equals("管理员")){
        int i =0;
        while (i == 0 || i > 0) {
            String str = pref.getString("cjh" + i, "");
            i++;
            if (str == null || str == "")
                break;
            linkMains.add(new LinkMain(str));
        }
    }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            finish();  //finish当前activity
            overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();

        //do something
    }
    public void dl(){
        LoadingDialog loadingDialog = new LoadingDialog(this);
        loadingDialog.setMessage("loading");
        loadingDialog.show();
    }
}
