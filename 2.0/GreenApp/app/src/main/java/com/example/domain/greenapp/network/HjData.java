package com.example.domain.greenapp.network;

import com.example.domain.greenapp.Dao.HjzzBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface HjData {
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("greenappSpringMvc/sbzz")
    Call<HjzzBean> sbflyData(@Body RequestBody route);//传入的参数为RequestBody
}
