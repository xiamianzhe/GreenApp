package com.example.domain.greenapp.Theenvironment;

import android.util.Log;

import com.example.domain.greenapp.Dao.Djzt;
import com.example.domain.greenapp.network.DmData;
import com.example.domain.greenapp.network.URL;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class djztmodify {
    public static boolean jieguo;
    public static String cj;
    private String URL;
    public static String ONF;
    public void doPost(){
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        Djzt djzt=new Djzt();
        djzt=initdata(djzt);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(djzt);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        DmData dmData=retrofit.create(DmData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<Djzt> call = dmData.sbflyData(body);
        call.enqueue(new Callback<Djzt>() {
            @Override
            public void onResponse(Call<Djzt> call, Response<Djzt> response) {
                Log.e("ceshi",""+response.body().isJieguo());
            }

            @Override
            public void onFailure(Call<Djzt> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
    private Djzt initdata(Djzt djzt) {//向服务端发送的值
        // TODO Auto-generated method stub
        djzt.setShohin_kaiguang(ONF);
        djzt.setCj(cj);
        Log.e("1111",""+ONF);
        List<Djzt.ShjBean> pointsBeans=new ArrayList<Djzt.ShjBean>();
        Djzt.ShjBean pointsBean=new Djzt.ShjBean();
        pointsBean.setShohin_kaiguang(ONF);
        pointsBean.setCj(cj);
        return djzt;
    }
}
