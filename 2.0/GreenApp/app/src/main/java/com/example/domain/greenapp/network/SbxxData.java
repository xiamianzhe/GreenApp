package com.example.domain.greenapp.network;


import com.example.domain.greenapp.Dao.SbxxBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SbxxData {
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("greenappSpringMvc/sbxx")
    Call<SbxxBean> sbflyData(@Body RequestBody route);//传入的参数为RequestBody
}
