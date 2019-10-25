//package com.example.domain.greenapp.Theenvironment;
//
//import android.util.Log;
//
//import com.example.domain.greenapp.Dao.NpBean;
//import com.example.domain.greenapp.network.NpData;
//import com.example.domain.greenapp.network.URL;
//import com.google.gson.Gson;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import okhttp3.RequestBody;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class np {
//    public static boolean jieguo;
//    private String URL;
//    public void doPost(){
//        com.example.domain.greenapp.network.URL url=new URL();
//        URL=url.URL;
//        NpBean npBean=new NpBean();
//        npBean=initdata(npBean);//根据Bean类初始化一个需要提交的数据类
//        Gson gson=new Gson();
//        String route= gson.toJson(npBean);//通过Gson将Bean转化为Json字符串形式
//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl(URL)
//                .addConverterFactory( GsonConverterFactory.create())
//                .build();
//        NpData npData=retrofit.create(NpData.class);
//        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
//        Call<NpBean> call = npData.sxFlyRoute(body);
//        call.enqueue(new Callback<NpBean>() {
//            @Override
//            public void onResponse(Call<NpBean> call, Response<NpBean> response) {
//                Log.e("ceshi",""+response.body().isJieguo());
//                if (response.body().isJieguo().equals(true)){
//                    Log.e("map:nh,pc",""+response.body().getMap());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<NpBean> call, Throwable t) {
//                Log.e("sssss",t.getMessage());
//            }
//        });
//    }
//    private NpBean initdata(NpBean npBean) {//向服务端发送的值
//        // TODO Auto-generated method stub
//        Date date=new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        npBean.setCj("001");
//        npBean.setShohin_shijian(sdf.format(date));
//        List<NpBean.ShjBean> pointsBeans=new ArrayList<NpBean.ShjBean>();
//        NpBean.ShjBean pointsBean=new NpBean.ShjBean();
//        pointsBean.setCj("001");
//        return npBean;
//    }
//}
