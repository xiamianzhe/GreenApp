package com.example.domain.greenapp.Theenvironment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.domain.greenapp.Activity.LoginActivity;
import com.example.domain.greenapp.Activity.MainActivity;
import com.example.domain.greenapp.Activity.PhoneActivity;
import com.example.domain.greenapp.Dao.FlyRouteBean;
import com.example.domain.greenapp.Fragment.ShouyeFragment;
import com.example.domain.greenapp.Fragment.WodeFragment;
import com.example.domain.greenapp.network.MacData;
import com.example.domain.greenapp.network.PostRoute;
import com.example.domain.greenapp.network.URL;
import com.google.gson.Gson;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class WiFiMAC {
    public static String wlanMac;
    private String URL;
    /**
     * 通过网络接口取
     * @return
     */
    public static String getNewMac() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return null;
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:", b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
//                Toast.makeText(MainActivity.mactivity, res1.toString(), Toast.LENGTH_SHORT).show();
                if (res1.toString()!="02:00:00:00:00:00"){
                    wlanMac=res1.toString();
                }else {
                    Toast.makeText(MainActivity.mactivity, "MAC地址获取错误", Toast.LENGTH_SHORT).show();
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void doMac(){
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        FlyRouteBean flyRouteBean=new FlyRouteBean();
        flyRouteBean=initdata(flyRouteBean);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(flyRouteBean);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        MacData macData=retrofit.create(MacData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<FlyRouteBean> call=macData.postFlyRoute(body);
        call.enqueue(new Callback<FlyRouteBean>() {
            @Override
            public void onResponse(Call<FlyRouteBean> call, Response<FlyRouteBean> response) {
                if (response.body().isJieguo().equals(true)) {
                    SharedPreferences.Editor editor = MainActivity.mactivity.getSharedPreferences("data", MODE_PRIVATE).edit();
                    editor.putString("MAC", response.body().getMac());
                    editor.apply();
//                    WodeFragment.wodeFragment.han();
                    PhoneActivity.phoneActivity.exit();
                    Toast.makeText(PhoneActivity.phoneActivity, "绑定成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(PhoneActivity.phoneActivity, "绑定失败", Toast.LENGTH_SHORT).show();
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
        SharedPreferences pref = MainActivity.mactivity.getSharedPreferences("data", MODE_PRIVATE);
        String gh = pref.getString("Shohin_gonghao", "");
        flyRouteBean.setShohin_gonghao(gh);
        flyRouteBean.setMac(wlanMac);
        List<FlyRouteBean.SerialBean> pointsBeans=new ArrayList<FlyRouteBean.SerialBean>();
        FlyRouteBean.SerialBean pointsBean=new FlyRouteBean.SerialBean();
        pointsBean.setShohin_gonghao(gh);
        pointsBean.setMac(wlanMac);
        return flyRouteBean;
    }


    public void doMac2(){
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        FlyRouteBean flyRouteBean=new FlyRouteBean();
        flyRouteBean=initdata(flyRouteBean);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(flyRouteBean);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        MacData macData=retrofit.create(MacData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<FlyRouteBean> call=macData.postFlyRoute(body);
        call.enqueue(new Callback<FlyRouteBean>() {
            @Override
            public void onResponse(Call<FlyRouteBean> call, Response<FlyRouteBean> response) {
                if (response.body().isJieguo().equals(true)) {
                    SharedPreferences.Editor editor = MainActivity.mactivity.getSharedPreferences("data", MODE_PRIVATE).edit();
                    editor.putString("MAC", response.body().getMac());
                    editor.apply();
//                    PhoneActivity.phoneActivity.exit();
                    Toast.makeText(MainActivity.mactivity, "绑定成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.mactivity, "绑定失败", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<FlyRouteBean> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
}
