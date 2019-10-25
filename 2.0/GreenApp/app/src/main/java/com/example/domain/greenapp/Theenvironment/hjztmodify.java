package com.example.domain.greenapp.Theenvironment;

import android.util.Log;

import com.example.domain.greenapp.Dao.HjzzBean;
import com.example.domain.greenapp.network.URL;
import com.example.domain.greenapp.network.hjztmodifyData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class hjztmodify {
    public static boolean jieguo;
    public static String cj;
    private String URL;
    public static String ONF;
    public void doPost(){
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        HjzzBean hjzzBean=new HjzzBean();
        hjzzBean=initdata(hjzzBean);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(hjzzBean);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        hjztmodifyData hjm=retrofit.create(hjztmodifyData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<HjzzBean> call = hjm.sbflyData(body);
        call.enqueue(new Callback<HjzzBean>() {
            @Override
            public void onResponse(Call<HjzzBean> call, Response<HjzzBean> response) {
                Log.e("ceshi",""+response.body().isJieguo());
                if (response.body().isJieguo().equals(true)){

                }
            }

            @Override
            public void onFailure(Call<HjzzBean> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
    private HjzzBean initdata(HjzzBean hjzzBean) {//向服务端发送的值
        // TODO Auto-generated method stub
        hjzzBean.setCj(cj);
        hjzzBean.setShohin_kgzt(ONF);
        List<HjzzBean.ShjBean> pointsBeans=new ArrayList<HjzzBean.ShjBean>();
        HjzzBean.ShjBean pointsBean=new HjzzBean.ShjBean();
        pointsBean.setCj(cj);
        pointsBean.setShohin_kgzt(ONF);
        return hjzzBean;
    }
}
