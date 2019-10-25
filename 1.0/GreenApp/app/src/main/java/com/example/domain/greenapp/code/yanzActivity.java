package com.example.domain.greenapp.code;

import android.util.Log;

import com.example.domain.greenapp.Activity.PhoneActivity;
import com.example.domain.greenapp.Dao.ReturnContant;
import com.example.domain.greenapp.network.SmsData;
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

public class yanzActivity {
    private String shohin_shoujihao;
    private String URL;

    public void doPost() {
        PhoneActivity phoneActivity=new PhoneActivity();
        shohin_shoujihao=phoneActivity.mobile;

        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        Log.e("URL测试",""+URL);
        ReturnContant returnContantn = new ReturnContant();
        returnContantn = initdata(returnContantn);//根据Bean类初始化一个需要提交的数据类
        Gson gson = new Gson();
        String route = gson.toJson(returnContantn);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SmsData postRoute = retrofit.create(SmsData.class);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route);
        Call<ReturnContant> call = postRoute.smsFlyRoute(body);
        call.enqueue(new Callback<ReturnContant>() {
            @Override
            public void onResponse(Call<ReturnContant> call, Response<ReturnContant> response) {
//                Log.e("code*************", "" + response.body().getCode());
            }


            @Override
            public void onFailure(Call<ReturnContant> call, Throwable t) {
                Log.e("sssss", t.getMessage());
            }
        });
    }

    private ReturnContant initdata(ReturnContant returnContant) {//向服务端发送的值
        // TODO Auto-generated method stub
        returnContant.setShohin_shoujihao(shohin_shoujihao);
        Log.e("手机号测试",""+shohin_shoujihao);
        List<ReturnContant.SMSBean> pointsBeans=new ArrayList<ReturnContant.SMSBean>();
        ReturnContant.SMSBean pointsBean=new ReturnContant.SMSBean();
        pointsBean.setShohin_shoujihao(shohin_shoujihao);
        return returnContant;
    }

}
