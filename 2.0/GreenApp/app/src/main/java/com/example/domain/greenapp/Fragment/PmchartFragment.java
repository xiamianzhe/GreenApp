package com.example.domain.greenapp.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.domain.greenapp.Dao.DataBean;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.network.PostData;
import com.example.domain.greenapp.network.URL;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PmchartFragment extends Fragment {
    public static LineChartView chartView;
    private String URL;
    private List<AxisValue> mAxisXValues = new ArrayList<AxisValue>();
    private List<AxisValue> mAxisYValues = new ArrayList<AxisValue>();
    private List<PointValue> mPointValues = new ArrayList<PointValue>();
    private List<PointValue> mPointValues1 = new ArrayList<PointValue>();
    private LineChartData data = new LineChartData();
    private Axis axisX = new Axis();
    private List<Line> lines = new ArrayList<Line>();

    public static Double[] maxPm=new Double[7]; //{33.4,26.3,30.7,33.8,29.1,37.4,22.9};
    /* public static int[] minwendu= {13,16,20,21,14,21,16};*/
    public Map<String, String> map= new HashMap<String, String>();
    public static String[] date=new String[7];
    public static String newStr_1,newStr_2,newStr_3,newStr_4,newStr_5,newStr_6,newStr_7;
    public static Double m1,m2,m3,m4,m5,m6,m7;
    public static String sdate;
    public static String cj;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_pmchart, container, false);
        chartView=view.findViewById(R.id.pm_chart);
        doPost();
        //getAxisPoints1();
        return view;
    }
    private void getAxisXLables() {
            for (int i = 0; i < date.length; i++) {
                if (date[i]!=null) {
                    mAxisXValues.add(new AxisValue(i).setLabel(date[i]));

                }
            }
            for(int i=0;i<=100;i+=10){
                mAxisYValues.add(new AxisValue(i).setLabel(i+""));
            }
        }

        private void getAxisPoints(){
            for(int i=0;i<maxPm.length;i++){
                if (maxPm[i]!=null) {
                    mPointValues.add(new PointValue(i, Math.round(maxPm[i])).setLabel(maxPm[i] + "μg/m³"));
                }
            }
        }
    /*private void getAxisPoints1(){
        for(int i=0;i<minwendu.length;i++){
            mPointValues1.add(new PointValue(i,minwendu[i]).setLabel(minwendu[i]+"℃"));
        }
    }*/
        private void initLineChart() {
            Line line = new Line(mPointValues).setColor(Color.parseColor("#FFCD41"));
            //Line line1=new Line(mPointValues1).setColor(Color.parseColor("#00acff"));
            line.setShape(ValueShape.CIRCLE);
            line.setCubic(false);
            line.setFilled(false);
        line.setHasLabels(true);
        line.setHasLines(true);
        line.setHasPoints(true);
        /*line1.setShape(ValueShape.CIRCLE);
        line1.setCubic(false);
        line1.setFilled(false);
        line1.setHasLabels(true);
        line1.setHasLines(true);
        line1.setHasPoints(true);*/
        lines.add(line);
        //lines.add(line1);
        data.setLines(lines);

        //坐标轴
        //X轴
        axisX.setHasTiltedLabels(false);  //X坐标轴字体是斜的显示还是直的，true是斜的显示
        axisX.setTextColor(Color.WHITE);  //设置字体颜色
        axisX.setName("日期");  //表格名称
        axisX.setTextSize(14);//设置字体大小
        //axisX.setMaxLabelChars(7); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisXValues.length
        axisX.setValues(mAxisXValues);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
        //data.setAxisXTop(axisX);  //x 轴在顶部
        axisX.setHasLines(true); //x 轴分割线

        Axis axisY = new Axis();
        axisY.setTextColor(Color.WHITE);
        axisY.setTextSize(16);//设置字体大小
        axisY.setValues(mAxisYValues);
        axisY.setName("Pm2.5浓度");
        data.setAxisYLeft(axisY);
        axisY.setHasLines(true);

        //设置行为属性，支持缩放、滑动以及平移
        chartView.setInteractive(true);
        chartView.setZoomType(ZoomType.HORIZONTAL);
        chartView.setMaxZoom((float) 2);//最大方法比例
        chartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        chartView.setLineChartData(data);
        chartView.setVisibility(View.VISIBLE);
        /**注：下面的7，10只是代表一个数字去类比而已
         * 当时是为了解决X轴固定数据个数。见（http://forum.xda-developers.com/tools/programming/library-hellocharts-charting-library-t2904456/page2）;
         */
        Viewport v = new Viewport(chartView.getMaximumViewport());
        v.left = 0;
        v.right = 6;
        v.top=100f;
        v.bottom=0f;
        chartView.setMaximumViewport(v);
        chartView.setCurrentViewport(v);
    }
    public void doPost() {
        URL url=new URL();
        URL=url.URL;
        DataBean dataBean=new DataBean();
        dataBean=initdata(dataBean);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(dataBean);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        PostData postData=retrofit.create(PostData.class);

        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<DataBean> call=postData.postflyData(body);
        Log.e("SHUJU--------------------------------Call",""+call);
        call.enqueue(new Callback<DataBean>() {
            @Override
            public void onResponse(Call<DataBean> call, Response<DataBean> response) {

                 Log.e("SHUJU--------------------------------",""+response.body());
                Log.e("isJieguo()",""+response.body().isJieguo());
                if (response.body().isJieguo().equals(true)){
                    ShujuFragment sj=new ShujuFragment();
                    sj.dr_2=response.body().isDr();
                    map=response.body().getMap();
                    if (map.get("p_max_1")!=null){
                        m1=Double.parseDouble(map.get("p_max_1"));
                    }
                    if (map.get("p_max_2")!=null){
                        m2=Double.parseDouble(map.get("p_max_2"));
                    }
                    if (map.get("p_max_3")!=null){
                        m3=Double.parseDouble(map.get("p_max_3"));
                    }
                    if (map.get("p_max_4")!=null){
                        m4=Double.parseDouble(map.get("p_max_4"));
                    }
                    if (map.get("p_max_5")!=null){
                        m5=Double.parseDouble(map.get("p_max_5"));
                    }
                    if (map.get("p_max_6")!=null){
                        m6=Double.parseDouble(map.get("p_max_6"));
                    }
                    if (map.get("p_max_7")!=null){
                        m7=Double.parseDouble(map.get("p_max_7"));
                    }
                    maxPm[0]=m7;
                    maxPm[1]=m6;
                    maxPm[2]=m5;
                    maxPm[3]=m4;
                    maxPm[4]=m3;
                    maxPm[5]=m2;
                    maxPm[6]=m1;
                    PmtableFragment pmt=new PmtableFragment();
//                    pmt.maxPm=maxPm;
                    //按相反顺序填入
                    Log.e("m1-7",""+m1+m2+m3+m4+m5+m6+m7);

                    if (map.get("shohin_shijian_1")!=null){
                        String s1=map.get("shohin_shijian_1");
                        newStr_1=s1.substring(s1.length()-5);//取后5位
                        Log.e("newStr_1",""+newStr_1);
                    }
                    if (map.get("shohin_shijian_2")!=null){
                        String s2=map.get("shohin_shijian_2");
                        newStr_2=s2.substring(s2.length()-5);
                        Log.e("newStr_2",""+newStr_2);
                    }
                    if (map.get("shohin_shijian_3")!=null){
                        String s3=map.get("shohin_shijian_3");
                        newStr_3=s3.substring(s3.length()-5);
                        Log.e("newStr_3",""+newStr_3);
                    }
                    if (map.get("shohin_shijian_4")!=null){
                        String s4=map.get("shohin_shijian_4");
                        newStr_4=s4.substring(s4.length()-5);
                        Log.e("newStr_4",""+newStr_4);
                    }
                    if (map.get("shohin_shijian_5")!=null){
                        String s5=map.get("shohin_shijian_5");
                        newStr_5=s5.substring(s5.length()-5);
                        Log.e("newStr_5",""+newStr_5);
                    }
                    if (map.get("shohin_shijian_6")!=null){
                        String s6=map.get("shohin_shijian_6");
                        newStr_6=s6.substring(s6.length()-5);
                        Log.e("newStr_6",""+newStr_6);
                    }
                    if (map.get("shohin_shijian_7")!=null){
                        String s7=map.get("shohin_shijian_7");
                        newStr_7=s7.substring(s7.length()-5);
                        Log.e("newStr_7",""+newStr_7);
                    }

                    date[0]=newStr_7;
                    date[1]=newStr_6;
                    date[2]=newStr_5;
                    date[3]=newStr_4;
                    date[4]=newStr_3;
                    date[5]=newStr_2;
                    date[6]=newStr_1;
                    /*PmtableFragment pmtableFragment=new PmtableFragment();
                    pmtableFragment.initdatapm();*/
                    getAxisXLables();
                    getAxisPoints();
                    initLineChart();
                }else{
                    maxPm=null;
                    maxPm=new Double[7];
                    date=null;
                    date=new String[7];
                    getAxisXLables();
                    getAxisPoints();
                    initLineChart();
                }

            }

            @Override
            public void onFailure(Call<DataBean> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
    private DataBean initdata(DataBean dataBean) {//向服务端发送的值
        // TODO Auto-generated method stub
        dataBean.setShohin_shijian(sdate);
        dataBean.setCj(cj);
        List<DataBean.ShjBean> pointsBeans=new ArrayList<DataBean.ShjBean>();
        DataBean.ShjBean pointsBean=new DataBean.ShjBean();
        pointsBean.setShohin_shijian(sdate);
        pointsBean.setCj(cj);
        return dataBean;
    }
}
