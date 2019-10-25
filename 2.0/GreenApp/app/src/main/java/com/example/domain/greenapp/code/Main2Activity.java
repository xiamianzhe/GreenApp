package com.example.domain.greenapp.code;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.domain.greenapp.Activity.LoginActivity;
import com.example.domain.greenapp.Activity.MainActivity;
import com.example.domain.greenapp.Activity.PhoneActivity;
import com.example.domain.greenapp.Activity.SettingActivity;
import com.example.domain.greenapp.Dao.ReturnContant;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.Theenvironment.Duanwang;
import com.example.domain.greenapp.Theenvironment.WiFiMAC;
import com.example.domain.greenapp.network.CodeData;
import com.example.domain.greenapp.network.URL;
import com.google.gson.Gson;
import com.hb.dialog.dialog.ConfirmDialog;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {
    private int code;
    private String URL;
    private Context context;
    private String msg,macmsg;


    public void doCode(){
        final PhoneActivity phoneActivity=new PhoneActivity();
        code=phoneActivity.code;
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        ReturnContant returnContantn=new ReturnContant();
        returnContantn=codedata(returnContantn);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(returnContantn);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        CodeData postRoute=retrofit.create(CodeData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<ReturnContant> call=postRoute.codeFlyRoute(body);
        call.enqueue(new Callback<ReturnContant>() {
            @Override
            public void onResponse(Call<ReturnContant> call, Response<ReturnContant> response) {
                Log.e("code*************", response.body().getYanzjg());
                if (response.body().getYanzjg().equals("YZCG")) {
//                    msg="绑定成功";
                    Toast.makeText(MainActivity.mactivity, "绑定成功", Toast.LENGTH_SHORT).show();
                    SharedPreferences pref = MainActivity.mactivity.getSharedPreferences("data", MODE_PRIVATE);
                    String mac = pref.getString("MAC", "");
                    if (mac.length()<=0){
//                        Judge();
                    }else {
                        PhoneActivity.phoneActivity.exit();//退出手机号注册界面
                    }
                }else {
//                    msg="绑定失败";
                    Toast.makeText(MainActivity.mactivity, "绑定失败", Toast.LENGTH_SHORT).show();
                    PhoneActivity.phoneActivity.exit();//退出手机号注册界面
                }
            }
            @Override
            public void onFailure(Call<ReturnContant> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
    private ReturnContant codedata(ReturnContant returnContant) {//向服务端发送的值
        // TODO Auto-generated method stub

        Log.e("测试验证码***********",""+code);
        returnContant.setCode(code);
        List<ReturnContant.SMSBean> pointsBeans=new ArrayList<ReturnContant.SMSBean>();
        ReturnContant.SMSBean pointsBean=new ReturnContant.SMSBean();
        pointsBean.setCode(code);
        return returnContant;
    }


    public void Judge(){
        ConfirmDialog confirmDialog = new ConfirmDialog(PhoneActivity.phoneActivity);
        confirmDialog.setLogoImg(R.mipmap.dialog_notice).setMsg("您的MAC地址尚未绑定，是否绑定MAC地址");
        confirmDialog.setClickListener(new ConfirmDialog.OnBtnClickListener() {
            @Override
            public void ok() {
                WiFiMAC wiFiMAC=new WiFiMAC();
                wiFiMAC.getNewMac();
                wiFiMAC.doMac();
            }

            @Override
            public void cancel() {
                PhoneActivity.phoneActivity.exit();
            }
        });
        confirmDialog.show();
    }


}
