package com.example.domain.greenapp.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.domain.greenapp.Dao.NpBean;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.network.NpData;
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

import static com.example.domain.greenapp.Activity.WenduActivity.date;
import static com.example.domain.greenapp.Activity.WenduActivity.maxwendu;
import static com.example.domain.greenapp.Activity.WenduActivity.minwendu;

//import static com.example.domain.greenapp.Fragment.WenduchartFragment.date;

/**
 * A simple {@link Fragment} subclass.
 */
public class DianjichartFragment extends Fragment {
    public static LineChartView chartView;
    private List<AxisValue> mAxisXValues = new ArrayList<AxisValue>();
    private List<AxisValue> mAxisYValues = new ArrayList<AxisValue>();
    private List<PointValue> mPointValues = new ArrayList<PointValue>();
    private List<PointValue> mPointValues1 = new ArrayList<PointValue>();
    private LineChartData data = new LineChartData();
    private Axis axisX = new Axis();
    private List<Line> lines = new ArrayList<Line>();
    public Map<String, String> map= new HashMap<String, String>();
    public static String newStr_1,newStr_2,newStr_3,newStr_4,newStr_5,newStr_6,newStr_7;
    public static int n1,n2,n3,n4,n5,n6,n7;
    public static int p1,p2,p3,p4,p5,p6,p7;
    public static String sdate;
    public static String cj;
    public static int[] pinci= new int[7];
    public static int[] nenghao= new int[7];
    public static boolean jieguo;
    private String URL;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_dianjichart, container, false);
        chartView=view.findViewById(R.id.dianji_chart);
//        doPost();
        return view;
    }
    private void getAxisXLables() {
        for (int i = 0; i < date.length; i++) {
            if (date[i]!=null) {
                mAxisXValues.add(new AxisValue(i).setLabel(date[i]));
            }
        }
        for(int i=0;i<=1000;i+=100){
            mAxisYValues.add(new AxisValue(i).setLabel(i+""));
        }
    }
    private void getAxisPoints(){
        for(int i=0;i<pinci.length;i++) {
            if (pinci[i] != 0) {
                mPointValues.add(new PointValue(i, pinci[i]).setLabel(pinci[i] + "次"));
            }
        }
    }
    private void getAxisPoints1(){
        for(int i=0;i<nenghao.length;i++){
            if (nenghao[i]!=0) {
                mPointValues1.add(new PointValue(i, nenghao[i]).setLabel(nenghao[i] + "度"));
            }
        }
    }
    private void initLineChart() {
        Line line = new Line(mPointValues).setColor(Color.parseColor("#FFCD41"));
        Line line1=new Line(mPointValues1).setColor(Color.parseColor("#00acff"));
        line.setShape(ValueShape.CIRCLE);
        line.setCubic(false);
        line.setFilled(false);
        line.setHasLabels(true);
        line.setHasLines(true);
        line.setHasPoints(true);
        line1.setShape(ValueShape.CIRCLE);
        line1.setCubic(false);
        line1.setFilled(false);
        line1.setHasLabels(true);
        line1.setHasLines(true);
        line1.setHasPoints(true);
        lines.add(line);
        lines.add(line1);
        data.setLines(lines);

        //坐标轴
        //X轴
        axisX.setHasTiltedLabels(false);  //X坐标轴字体是斜的显示还是直的，true是斜的显示
        axisX.setTextColor(Color.WHITE);  //设置字体颜色
        axisX.setName("日期");  //表格名称
        axisX.setTextSize(14);//设置字体大小
        //axisX.setMaxLabelChars(7);//最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisXValues.length
        axisX.setValues(mAxisXValues);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
        //data.setAxisXTop(axisX);  //x 轴在顶部
        axisX.setHasLines(true); //x 轴分割线

        Axis axisY = new Axis();
        axisY.setTextColor(Color.WHITE);
        axisY.setTextSize(16);//设置字体大小
        axisY.setValues(mAxisYValues);
        axisY.setName("使用频次&能耗");
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
    public void doPost(){
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        NpBean npBean=new NpBean();
        npBean=initdata(npBean);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(npBean);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        NpData npData=retrofit.create(NpData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<NpBean> call = npData.sxFlyRoute(body);
        call.enqueue(new Callback<NpBean>() {
            @Override
            public void onResponse(Call<NpBean> call, Response<NpBean> response) {
                Log.e("ceshi",""+response.body().isJieguo());
                if (response.body().isJieguo().equals(true)){
                    Log.e("map:nh,pc",""+response.body().getMap());
                    ShujuFragment sj=new ShujuFragment();
                    map=response.body().getMap();

                    if (map.get("nenghao1")!=null){
                        n1=Integer.parseInt(map.get("nenghao1"));
                        Log.e("aaaaaaaaaaaaaaaaaaaaaaa",""+map);
                    }
                    if (map.get("nenghao2")!=null){
                        n2=Integer.parseInt(map.get("nenghao2"));
                    }
                    if (map.get("nenghao3")!=null){
                        n3=Integer.parseInt(map.get("nenghao3"));
                    }
                    if (map.get("nenghao4")!=null){
                        n4=Integer.parseInt(map.get("nenghao4"));
                    }
                    if (map.get("nenghao5")!=null){
                        n5=Integer.parseInt(map.get("nenghao5"));
                    }
                    if (map.get("nenghao6")!=null){
                        n6=Integer.parseInt(map.get("nenghao6"));
                    }
                    if (map.get("nenghao7")!=null){
                        n7=Integer.parseInt(map.get("nenghao7"));
                    }
                    nenghao[0]=n7;
                    nenghao[1]=n6;
                    nenghao[2]=n5;
                    nenghao[3]=n4;
                    nenghao[4]=n3;
                    nenghao[5]=n2;
                    nenghao[6]=n1;

                    //按相反顺序填入
                    if (map.get("pinci1")!=null){
                        p1=Integer.parseInt(map.get("pinci1"));
                    }
                    if (map.get("pinci2")!=null){
                        p2=Integer.parseInt(map.get("pinci2"));
                    }
                    if (map.get("pinci3")!=null){
                        p3=Integer.parseInt(map.get("pinci3"));
                    }
                    if (map.get("pinci4")!=null){
                        p4=Integer.parseInt(map.get("pinci4"));
                    }
                    if (map.get("pinci5")!=null){
                        p5=Integer.parseInt(map.get("pinci5"));
                    }
                    if (map.get("pinci6")!=null){
                        p6=Integer.parseInt(map.get("pinci6"));
                    }
                    if (map.get("pinci7")!=null){
                        p7=Integer.parseInt(map.get("pinci7"));
                    }
                    pinci[0]=p7;
                    pinci[1]=p6;
                    pinci[2]=p5;
                    pinci[3]=p4;
                    pinci[4]=p3;
                    pinci[5]=p2;
                    pinci[6]=p1;
                    //按相反顺序填入
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
                    getAxisXLables();
                    getAxisPoints();
                    initLineChart();
                    getAxisPoints1();
                    //按相反顺序填入
                    Log.e("error",""+response.body().getMap());
                }else{
                    pinci=null;
                    pinci=new int[7];
                    nenghao=null;
                    nenghao=new int[7];
                    date=null;
                    date=new String[7];
                    getAxisXLables();
                    getAxisPoints();
                    initLineChart();
                    getAxisPoints1();
                }
            }

            @Override
            public void onFailure(Call<NpBean> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
    private NpBean initdata(NpBean npBean) {//向服务端发送的值
        // TODO Auto-generated method stub
        npBean.setCj(cj);
        npBean.setShohin_shijian(sdate);
        List<NpBean.ShjBean> pointsBeans=new ArrayList<NpBean.ShjBean>();
        NpBean.ShjBean pointsBean=new NpBean.ShjBean();
        pointsBean.setCj(cj);
        pointsBean.setShohin_shijian(sdate);
        return npBean;
    }
}
