package com.example.domain.greenapp.network;

import com.example.domain.greenapp.Dao.ReturnContant;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SmsData {
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("greenappSpringMvc/code")
    Call<ReturnContant> smsFlyRoute(@Body RequestBody route);//传入的参数为RequestBody
}
