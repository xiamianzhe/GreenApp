package com.example.domain.greenapp.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.domain.greenapp.Activity.MainActivity;
import com.example.domain.greenapp.Dao.Djzt;
import com.example.domain.greenapp.Dao.HjzzBean;
import com.example.domain.greenapp.Dao.SbxxBean;
import com.example.domain.greenapp.R;
//import com.example.domain.greenapp.Theenvironment.hjzz;
import com.example.domain.greenapp.Theenvironment.djztmodify;
import com.example.domain.greenapp.Theenvironment.hjztmodify;
import com.example.domain.greenapp.network.DjxxData;
import com.example.domain.greenapp.network.DjztData;
import com.example.domain.greenapp.network.HjData;
import com.example.domain.greenapp.network.SbxxData;
import com.example.domain.greenapp.network.URL;
import com.google.gson.Gson;
import com.ramotion.foldingcell.FoldingCell;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TabchejianoneFragment extends Fragment  {
    public static String fuzer1,jqbh1,jqxh1,cgsj1,ccsj1,fuzer2,jqbh2,jqxh2,cgsj2,ccsj2,moshi,fengsu,wendu,kaig,guz,nhao,kg,zsu;
    //负责人，机器编号，机器型号，采购时间，出场时间，模式，风速，温度，空调开关，故障，能耗，电机开关，转速
    public static boolean jieguo;
    public static String cj;
    private String URL;
    private FoldingCell fc1,fc2;
    private RelativeLayout fc1_open,fc2_open;
    private Button fc1_close,fc2_close;
    private Button acname,motorname;//空调名称 Title空调名称
    private ImageView openclose,openclose2;//开关按钮
    private ImageView iv_mode,guzg;
    private TextView tv_sheshidu,tv_fengsu,tv_mode,titleacname,titlemotorname,neghao,zhuansu,guzhang;//风速 模式
    private Button xixx;//详细信息

    private TextView yihao;
    private TextView jiner;
    private double nh;
    private double nenghao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        TextView tit;
        View view=inflater.inflate(R.layout.fragment_tabchejianone, container, false);
        iv_mode=view.findViewById(R.id.tancjone_iv_mode);
        fc1=view.findViewById(R.id.tabcjone_folding_cell1);
        fc2=view.findViewById(R.id.tabcjone_folding_cell2);
        fc1_open=view.findViewById(R.id.tabhj_ac_open);
        fc1_close=view.findViewById(R.id.tabcjone_ac_colse);
        fc2_open=view.findViewById(R.id.tabhj_motor_open);
        fc2_close=view.findViewById(R.id.tabcjone_motor_colse);
        acname=view.findViewById(R.id.tabcjone_acname);
        titleacname=view.findViewById(R.id.tabcjone_titleacname);
        motorname=view.findViewById(R.id.tabcjone_motorname);
        titlemotorname=view.findViewById(R.id.tabcjone_titlemotorname);
        tv_fengsu=view.findViewById(R.id.tabcjone_tv_fengsu);
        tv_sheshidu=view.findViewById(R.id.tabone_sheshidu);
        tv_mode=view.findViewById(R.id.tabcjone_tv_mode);
        xixx=view.findViewById(R.id.tabcjone_fc_xinxi);
        neghao=view.findViewById(R.id.tabcjone_tv_fengsu2);
        zhuansu=view.findViewById(R.id.tabcjone_tv_mode2);
        guzg=view.findViewById(R.id.guzg);
        guzhang=view.findViewById(R.id.guzhang);
        openclose=view.findViewById(R.id.tabcjone_openclose);
        openclose2=view.findViewById(R.id.tabcjone_openclose2);
        fc1.initialize(1000,Color.WHITE,2);
        fc2.initialize(1000,Color.WHITE,2);

        //能耗 nh是当月能耗
        DecimalFormat df = new DecimalFormat( "0.00 ");
        nh=22.5;
        yihao=view.findViewById(R.id.yihao);
        jiner=view.findViewById(R.id.jiner);
        nenghao=nh*0.58;
        yihao.setText(""+nh);
        jiner.setText(""+df.format(nenghao));
        fc1_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_sheshidu.setText(wendu);
                tv_fengsu.setText(fengsu);
                tv_mode.setText(moshi);
                if (moshi!=null) {
                    if (moshi.equals("制冷")) {
                        iv_mode.setImageResource(R.mipmap.cold);
                    } else if (moshi.equals("制热")) {
                        iv_mode.setImageResource(R.mipmap.heat);
                    }
                }
                Log.e("模式",""+moshi);
                if (kaig!=null) {
                    if (kaig.equals("OFF")) {
                        Log.e("kaig",""+kaig);
                        openclose.setImageResource(R.mipmap.open_4);
                        tv_sheshidu.setText(null);
                        tv_fengsu.setText(null);
                        tv_mode.setText(null);
                    }else if (kaig.equals("ON")){
                        openclose.setImageResource(R.mipmap.open);
                    }
                }
                acname.setText(jqbh1);

                fc1.toggle(false);
            }
        });
        fc1_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fc1.toggle(false);
            }
        });
        fc2_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motorname.setText(jqbh2);
                neghao.setText(nhao);
                //生产设备
                zhuansu.setText(zsu+"/min");
                guzhang.setText(guz);
                if(guz!=null) {
                    if (guz.equals("故障")) {
                        guzg.setImageResource(R.mipmap.guzhangy);
                    }
                }
                if (kg!=null) {
                    if (kg.equals("OFF")) {
                        Log.e("kg",""+kg);
                        openclose2.setImageResource(R.mipmap.open_4);
                    }else if (kg.equals("ON")){
                        openclose2.setImageResource(R.mipmap.open);
                    }
                }
                fc2.toggle(false);
            }
        });
        fc2_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc2.toggle(false);
            }
        });
        openclose.setOnClickListener(new View.OnClickListener() {
            @Override
            //环境设备的开关控制
            public void onClick(View view) {
                if(kaig!=null){
                    if (kaig.equals("ON")){
                        kaig="OFF";
                        tv_sheshidu.setText(null);
                        tv_fengsu.setText(null);
                        tv_mode.setText(null);
                        //对UI界面进行更新
                        openclose.setImageResource(R.mipmap.open_4);
                        hjztmodify df=new hjztmodify();
                        df.ONF=null;
                        df.ONF="OFF";
                        df.cj=null;
                        df.cj=cj;
                        df.doPost();
                    }else  if(kaig.equals("OFF")){
                        kaig="ON";
                        openclose.setImageResource(R.mipmap.open);
                        hjztmodify df=new hjztmodify();
                        tv_sheshidu.setText(wendu);
                        tv_fengsu.setText(fengsu);
                        tv_mode.setText(moshi);
                        df.ONF=null;
                        df.ONF="ON";
                        df.cj=null;
                        df.cj=cj;
                        df.doPost();
                    }
                }
            }
        });
        openclose2.setOnClickListener(new View.OnClickListener() {
            //生产设备的开关控制
            @Override
            public void onClick(View view) {
                if (guz!=null) {
                    if (guz.equals("故障")) {
                        Toast.makeText(MainActivity.mactivity, "请在设备维修后再进行操作", Toast.LENGTH_SHORT).show();
                    } else {
                        if (kg != null) {
                            if (kg.equals("ON")) {
                                kg = "OFF";
                                openclose2.setImageResource(R.mipmap.open_4);
                                djztmodify df = new djztmodify();
                                df.ONF = null;
                                df.ONF = "OFF";
                                df.cj = null;
                                df.cj = cj;
                                df.doPost();
                            } else if (kg.equals("OFF")) {
                                kg = "ON";
                                openclose2.setImageResource(R.mipmap.open);
                                djztmodify df = new djztmodify();
                                df.ONF = null;
                                df.ONF = "ON";
                                df.cj = null;
                                df.cj = cj;
                                df.doPost();
                            }
                        }
                    }
                }
            }
        });
        xixx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
            }
        });
        return view;
    }
    /*访问环境设备信息*/
    public void doPost1(){
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        SbxxBean sbxxBean=new SbxxBean();
        sbxxBean=initdata1(sbxxBean);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(sbxxBean);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        SbxxData sbxxData=retrofit.create(SbxxData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<SbxxBean> call = sbxxData.sbflyData(body);
        call.enqueue(new Callback<SbxxBean>() {
            @Override
            public void onResponse(Call<SbxxBean> call, Response<SbxxBean> response) {
                Log.e("ceshi",""+"aaaaaaaaa");
                if (response.body().isJieguo().equals(true)){
                    cgsj1=response.body().getChaigoushijian();
                    ccsj1=response.body().getChuchangshijian();
                    fuzer1=response.body().getFuzheren();
                    jqbh1=response.body().getJiqibianhao();
                    jqxh1=response.body().getJiqixinghao();
                    jieguo=response.body().isJieguo();
                    Log.e("ceshi",""+jqbh1);

                }
//
            }

            @Override
            public void onFailure(Call<SbxxBean> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });

    }
    private SbxxBean initdata1(SbxxBean sbxxBean) {//向服务端发送的值
        // TODO Auto-generated method stub
        Log.e("输出测试",""+cj);
        sbxxBean.setCj(cj);
        List<SbxxBean.ShjBean> pointsBeans=new ArrayList<SbxxBean.ShjBean>();
        SbxxBean.ShjBean pointsBean=new SbxxBean.ShjBean();
        pointsBean.setCj(cj);
        return sbxxBean;
    }
    /*访问环境设备状态信息*/
    public void doPost2(){
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        HjzzBean hjzzBean=new HjzzBean();
        hjzzBean=initdata2(hjzzBean);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(hjzzBean);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        HjData hjData=retrofit.create(HjData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<HjzzBean> call = hjData.sbflyData(body);
        call.enqueue(new Callback<HjzzBean>() {
            @Override
            public void onResponse(Call<HjzzBean> call, Response<HjzzBean> response) {
                Log.e("ceshi",""+response.body().isJieguo());
                if (response.body().isJieguo().equals(true)){
                    moshi=response.body().getShohin_ms();
                    fengsu=response.body().getShohin_sd();
                    wendu=response.body().getShohin_wd();
                    kaig=response.body().getShohin_kgzt();

                }
            }

            @Override
            public void onFailure(Call<HjzzBean> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
    private HjzzBean initdata2(HjzzBean hjzzBean) {//向服务端发送的值
        // TODO Auto-generated method stub
        hjzzBean.setCj(cj);
        List<HjzzBean.ShjBean> pointsBeans=new ArrayList<HjzzBean.ShjBean>();
        HjzzBean.ShjBean pointsBean=new HjzzBean.ShjBean();
        pointsBean.setCj(cj);
        return hjzzBean;
    }


    /*访问生产设备信息*/
    public void doPost3(){
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        SbxxBean sbxxBean2=new SbxxBean();
        sbxxBean2=initdata3(sbxxBean2);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(sbxxBean2);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        DjxxData djxxData=retrofit.create(DjxxData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<SbxxBean> call =djxxData.sbflyData(body);
        call.enqueue(new Callback<SbxxBean>() {
            @Override
            public void onResponse(Call<SbxxBean> call, Response<SbxxBean> response) {
                Log.e("ceshi",""+"aaaaaaaaa");
                if (response.body().isJieguo().equals(true)){
                    cgsj2=response.body().getChaigoushijian();
                    ccsj2=response.body().getChuchangshijian();
                    fuzer2=response.body().getFuzheren();
                    jqbh2=response.body().getJiqibianhao();
                    jqxh2=response.body().getJiqixinghao();
                    Log.e("ceshi",""+jqbh2);

                }
//
            }

            @Override
            public void onFailure(Call<SbxxBean> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });

    }
    private SbxxBean initdata3(SbxxBean sbxxBean) {//向服务端发送的值
        // TODO Auto-generated method stub
        Log.e("输出测试",""+cj);
        sbxxBean.setCj(cj);
        List<SbxxBean.ShjBean> pointsBeans=new ArrayList<SbxxBean.ShjBean>();
        SbxxBean.ShjBean pointsBean=new SbxxBean.ShjBean();
        pointsBean.setCj(cj);
        return sbxxBean;
    }

    /*访问生产设备状态信息*/
    public void doPost4(){
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        Djzt djzt=new Djzt();
        djzt=initdata4(djzt);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(djzt);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        DjztData djztData=retrofit.create(DjztData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<Djzt> call = djztData.sbflyData(body);
        call.enqueue(new Callback<Djzt>() {
            @Override
            public void onResponse(Call<Djzt> call, Response<Djzt> response) {
                Log.e("ceshi",""+response.body().isJieguo());
                if (response.body().isJieguo().equals(true)){
                    guz=response.body().getShohin_guzhang();
                    if (guz.equals("故障")){
                        Toast.makeText(MainActivity.mactivity, "生产设备已故障请联系维修人员进行处理", Toast.LENGTH_SHORT).show();
                    }
                    kg=response.body().getShohin_kaiguang();
                    nhao=response.body().getShohin_nenhao();
                    zsu=response.body().getShohin_zhuanshu();
                }
            }

            @Override
            public void onFailure(Call<Djzt> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
    private Djzt initdata4(Djzt djzt) {//向服务端发送的值
        // TODO Auto-generated method stub
        djzt.setCj(cj);
        List<Djzt.ShjBean> pointsBeans=new ArrayList<Djzt.ShjBean>();
        Djzt.ShjBean pointsBean=new Djzt.ShjBean();
        pointsBean.setCj(cj);
        return djzt;
    }
}
