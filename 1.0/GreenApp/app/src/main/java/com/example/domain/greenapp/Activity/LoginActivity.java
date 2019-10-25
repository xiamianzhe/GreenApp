package com.example.domain.greenapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.domain.greenapp.Dao.EzBean;
import com.example.domain.greenapp.Dao.FlyRouteBean;
import com.example.domain.greenapp.Dao.HjzzBean;
import com.example.domain.greenapp.Fragment.ShouyeFragment;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.Theenvironment.WiFiMAC;
import com.example.domain.greenapp.network.PostRoute;
import com.example.domain.greenapp.network.URL;
import com.example.domain.greenapp.network.e2Data;
import com.google.gson.Gson;
import com.hb.dialog.dialog.LoadingDialog;
import com.hb.dialog.myDialog.MyAlertDialog;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private EditText txt_user,txt_pwd;
    private ImageView iv_eye;
    private Button btn_login;
    private boolean isHide=true;
    private SharedPreferences pf;
    private SharedPreferences.Editor ed;
    private String URL;
    private String msg;
    public static  String cj,K_mac;
    private CheckBox rememberPass;
    private String account,password,shohin_gonghao,mima;
    private ArrayList<String> s=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        pf= PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass=(CheckBox)findViewById(R.id.cb_pwd);
        boolean isRemember=pf.getBoolean("remember",false);
        //设置状态栏文字颜色及图标为深色
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        txt_user=(EditText)findViewById(R.id.txt_user);
        txt_pwd=(EditText)findViewById(R.id.txt_pwd);
        btn_login=(Button)findViewById(R.id.btn_login);
        iv_eye=(ImageView)findViewById(R.id.iv_eye);
        iv_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.iv_eye:
                        if(isHide==true){
                            iv_eye.setImageResource(R.mipmap.icon_eye_open);
                            HideReturnsTransformationMethod method=HideReturnsTransformationMethod.getInstance();
                            txt_pwd.setTransformationMethod(method);
                            isHide=false;
                        }else{
                            iv_eye.setImageResource(R.mipmap.icon_eye_close);
                            TransformationMethod method=PasswordTransformationMethod.getInstance();
                            txt_pwd.setTransformationMethod(method);
                            isHide=true;
                        }
                    int index=txt_pwd.getText().toString().length();
                    txt_pwd.setSelection(index);
                        break;
                }
            }
        });
        if (isRemember){
            account=pf.getString("account","");
            password=pf.getString("password","");
            txt_user.setText(account);
            txt_pwd.setText(password);
            rememberPass.setChecked(true);
        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doPost();
            }
        });
    }
    public void doPost(){
        FlyRouteBean flyRouteBean=new FlyRouteBean();
        flyRouteBean=initdata(flyRouteBean);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(flyRouteBean);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        PostRoute postRoute=retrofit.create(PostRoute.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<FlyRouteBean> call=postRoute.postFlyRoute(body);
        call.enqueue(new Callback<FlyRouteBean>() {
            @Override
            public void onResponse(Call<FlyRouteBean> call, Response<FlyRouteBean> response) {
                Log.e("sssss","-----------------------"+response.body());//这里是用于测试，服务器返回的数据就是提交的数据。
                Log.e("sssss","-----------------------"+response.body().getName());
                Log.e("职位：","-------------------"+response.body().getZhiwu());
                Log.e("sssss","-----------------------"+response.body().getShohin_gonghao());
                Log.e("sssss","-----------------------"+response.body().getMima());
                Log.e("sssss","-----------------------"+response.body().getRuzhishijian());
                Log.e("sssss","-----------------------"+response.body().getZhanghu());
                Log.e("sssss","-----------------------"+response.body().getShohin_shoujihao());
                Log.e("--------------------------------",""+response.body().isJieguo());
                if(response.body().getShohin_gonghao().equals("false")){
                    Log.e("******","工号错误");
                    msg="工号为空或工号错误";
                    tanchu();
                }else{
                    if (response.body().isJieguo().equals(true)){
                        K_mac=response.body().getMac();
                        if (K_mac.length()<=0) {
                        SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                        editor.putString("Zhanghu",response.body().getZhanghu());
                        editor.putString("Name",response.body().getName());
                        editor.putString("Shohin_gonghao",response.body().getShohin_gonghao());
                        editor.putString("Ruzhishijian",response.body().getRuzhishijian());
                        editor.putString("zhiwu",response.body().getZhiwu());
                        editor.putString("Shohin_shoujihao",response.body().getShohin_shoujihao());
                        editor.putString("MAC",response.body().getMac());
//                        editor.putString("mac",response.body().getMac());

                            Log.e("mac-0-0-0-0-0-", "" + response.body().getMac());
                            if (response.body().getZhiwu().equals("生产员")) {
                                editor.putString("cj", response.body().getCj());
                                cj = response.body().getCj();
                                ShouyeFragment sy = new ShouyeFragment();
                                sy.cj = cj;//将车间号传递至首页查询
                                dl();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            if (response.body().getZhiwu().equals("管理员")) {
                                doPost2();
                            }

                        editor.putBoolean("state",true);
                        editor.apply();
                        }else {
                            WiFiMAC wiFiMAC=new WiFiMAC();
                            wiFiMAC.getNewMac();
                            if (K_mac.equals(wiFiMAC.wlanMac)){
                                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                                editor.putString("Zhanghu",response.body().getZhanghu());
                                editor.putString("Name",response.body().getName());
                                editor.putString("Shohin_gonghao",response.body().getShohin_gonghao());
                                editor.putString("Ruzhishijian",response.body().getRuzhishijian());
                                editor.putString("zhiwu",response.body().getZhiwu());
                                editor.putString("Shohin_shoujihao",response.body().getShohin_shoujihao());
                                editor.putString("MAC",response.body().getMac());
//                        editor.putString("mac",response.body().getMac());

                                Log.e("mac-0-0-0-0-0-", "" + response.body().getMac());
                                if (response.body().getZhiwu().equals("生产员")) {
                                    editor.putString("cj", response.body().getCj());
                                    cj = response.body().getCj();
                                    ShouyeFragment sy = new ShouyeFragment();
                                    sy.cj = cj;//将车间号传递至首页查询
                                    dl();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                if (response.body().getZhiwu().equals("管理员")) {
                                    doPost2();
                                }

                                editor.putBoolean("state",true);
                                editor.apply();
                            }else {
                                msg="此账户已绑定MAC地址，请使用正确设备登录";
                                tanchu();
                            }
                        }
                        Log.e("返回的车间号",""+cj);
                        ed=pf.edit();
                        if (rememberPass.isChecked()){
                            ed.putBoolean("remember",true);
                            ed.putString("account",shohin_gonghao);
                            ed.putString("password",mima);
                        }else {
                            ed.clear();
                        }
                        ed.apply();
                    }else{
                        msg="密码为空或密码错误";
                        tanchu();
                    }
                }
            }

            @Override
            public void onFailure(Call<FlyRouteBean> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
    private FlyRouteBean initdata(FlyRouteBean flyRouteBean) {//向服务端发送的值
        // TODO Auto-generated method stub
        shohin_gonghao =txt_user.getText().toString();
        mima=txt_pwd.getText().toString();
        flyRouteBean.setShohin_gonghao(shohin_gonghao);
        flyRouteBean.setMima(mima);
        List<FlyRouteBean.SerialBean> pointsBeans=new ArrayList<FlyRouteBean.SerialBean>();
        FlyRouteBean.SerialBean pointsBean=new FlyRouteBean.SerialBean();
        pointsBean.setShohin_gonghao(shohin_gonghao);
        pointsBean.setMima(mima);
        return flyRouteBean;
    }
    public void tanchu(){
        MyAlertDialog myAlertDialog = new MyAlertDialog(this).builder()
                .setTitle("错误提示！！！")
                .setMsg(msg)
                .setPositiveButton("确认", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //showMsg("确认");
                    }
                });
        myAlertDialog.show();
    }
    public void dl(){
        LoadingDialog loadingDialog = new LoadingDialog(this);
        loadingDialog.setMessage("loading");
        loadingDialog.show();
    }
    public void doPost2(){
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        EzBean ezBeann=new EzBean();
        ezBeann=initdata2(ezBeann);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(ezBeann);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        e2Data hjData=retrofit.create(e2Data.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<EzBean> call = hjData.sbflyData(body);
        call.enqueue(new Callback<EzBean>() {
            @Override
            public void onResponse(Call<EzBean> call, Response<EzBean> response) {
                Log.e("全部车间号",""+response.body().getCjh());
                s=response.body().getCjh();
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                for(int i=0;i<s.size();i++) {
                    editor.putString("cjh"+i,s.get(i));
                }
                ShouyeFragment sy=new ShouyeFragment();
                sy.cj=s.get(0);
                Log.e("2ewdew",""+sy.cj);
                editor.apply();
                dl();
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<EzBean> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
    private EzBean initdata2(EzBean ezBean) {//向服务端发送的值
        // TODO Auto-generated method stub
        ezBean.setCjh(null);
        List<HjzzBean.ShjBean> pointsBeans=new ArrayList<HjzzBean.ShjBean>();
        EzBean.ShjBean pointsBean=new EzBean.ShjBean();
        pointsBean.setCjh(null);
        return ezBean;
    }
//    public void doMac(){
//        MyAlertDialog myAlertDialog = new MyAlertDialog(this).builder()
//                .setTitle("是否绑定Mac地址")
//                .setMsg("绑定后将只有本台设备可以，若想更换设备需联系管理员（为保证账户安全建议您绑定Mac地址）")
//                .setPositiveButton("确认", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //showMsg("确认");
////                        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
////                        String gh=pref.getString("Shohin_gonghao","");
////                        MacPost macPost=new MacPost();
////                        macPost.doPost();
////                        macPost.gh=gh;
//                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//                        startActivity(intent);
//                    }
//                }).setNegativeButton("取消", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//                        startActivity(intent);
//                        LoginActivity.this.finish();
//                    }
//                });
//        myAlertDialog.show();
//    }
//    public void Main() {
//        if (K_mac==null|K_mac.equals(Mac.mac)|K_mac==""){
//            dl();
//            Log.e("Mac.mac1","-----------------------"+K_mac+"-----------------------");
//            if (K_mac==null|K_mac==""){
//                doMac();
//            }else
//
//            if (K_mac.equals(Mac.mac)){
//                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(intent);
//            }
//
//        }else {
//            msg="您的账号已经绑定设备，请更换正确设备登录";
//            tanchu();
//            Log.e("Mac.mac2",""+K_mac);
//        }
//        Log.e("Tea",""+Mac.mac);
//    }
//    }
}
