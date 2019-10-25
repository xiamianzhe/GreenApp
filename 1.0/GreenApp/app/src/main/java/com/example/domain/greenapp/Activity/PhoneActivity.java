package com.example.domain.greenapp.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.domain.greenapp.Fragment.WodeFragment;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.Theenvironment.WiFiMAC;
import com.example.domain.greenapp.code.Main2Activity;
import com.example.domain.greenapp.code.yanzActivity;
import com.example.domain.greenapp.Dao.FlyRouteBean;
import com.example.domain.greenapp.network.JnqData;
import com.example.domain.greenapp.network.URL;
import com.google.gson.Gson;
import com.hb.dialog.dialog.ConfirmDialog;
import com.hb.dialog.myDialog.MyAlertDialog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhoneActivity extends AppCompatActivity {
    private String msg;
    public  static String mobile;
    public boolean kong;//在手机号为空时的判断
    public boolean wy;//判断在发送验证后验证码为空的情况
    private String shohin_gonghao;
    private Boolean quer;
    public static int code;
    private String URL;
    Toolbar phone_title;
    ImageView phone_back;
    EditText phone_mobile;
    EditText yz;
    Button hq;
    Button qr;
    int yanz;
    String  yzs;
    public static PhoneActivity phoneActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        com.example.domain.greenapp.network.URL url=new URL();
        URL=url.URL;
        phone_title=(Toolbar)findViewById(R.id.phone_title);
        phone_back=(ImageView)findViewById(R.id.phone_back);
        phone_mobile=(EditText)findViewById(R.id.phone_txt_mobile);
        yz=(EditText)findViewById(R.id.phone_yzm);
        yz.setInputType(InputType.TYPE_NULL);//验证码不可编辑

        hq=(Button)findViewById(R.id.acquire);
        qr=(Button)findViewById(R.id.phone_queren);
        qr.setEnabled(false);//确认按钮不可点击
        phone_title.setTitle("");
        setSupportActionBar(phone_title);
        phoneActivity=this;
        phone_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
            }
        });
        hq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doMobile();

            }
        });
        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (kong==true){
//                    if (quer==false){
//                        msg="此账户已绑定禁止提交验证码";
//                        tanchu();
//                        Log.e("手机号绑定提示","此账户已绑定禁止提交验证码");
//                    }else{
         /*               if (wy==true){
                            doCode();
                        }else{
                            Log.e("验证码错误提示","验证为空或验证码长度错误");
                        }*/
                        doCode();
//                        mobile=
//                    }
//                }else{
//                    msg="手机号为空或未获取验证码";
//                    tanchu();
//                    Log.e("登录错误提示","手机号为空或未获取验证码");
//                }

            }
        });
    }

    //退出手机号界面
    public void exit(){
        finish();
        overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
    }
    //手机号判断
    public void doMobile(){
        final String phone =phone_mobile.getText().toString();
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if(phone.length() != 11){
            System.out.println("手机号应为11位数");
            msg="手机号应为11位数";
            tanchu();
            kong=false;
        }else{
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if(isMatch){
                System.out.println("您的手机号" + phone + "是正确格式@——@");
                kong=true;
                mobile=phone;
                doGh();
            } else {
                System.out.println("您的手机号" + phone + "是错误格式！！！");
                msg="您的手机号" + phone + "是错误格式！！！";
                tanchu();
            }
        }

    }

    //短信验证码判断
    public void doCode() {
        yzs= yz.getText().toString();//Integer.parseInt();
        if (yzs.length()<4){
            Log.e("验证码", "验证码长度应为4位");
            msg="验证码长度应为4位";
            tanchu();
        }else {
//            yanz=Integer.parseInt(yzs);
//            code = yanz;
//            Main2Activity main2Activity = new Main2Activity();
//            main2Activity.doCode();

            kan();
//            wy = true;

        }
    }
    public void kan(){
        com.example.domain.greenapp.network.URL url=new URL();
        final String sURL=url.SocketURL;
        new Thread() {
            private Context context;

            //pm//socket
            @Override

            public void run() {
                super.run();
                try {
                    //1.创建监听指定服务器地址以及指定服务器监听的端口号
                    int socketyan=Integer.parseInt(yz.getText().toString());
                    if (socketyan==yanz) {
                        Socket socket;
                        socket = new Socket(sURL, yanz);
                        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                        String gh = pref.getString("Shohin_gonghao", "");
                        String fasong = gh + mobile;
                        //2.拿到客户端的socket对象的输出流发送给服务器数据
                        OutputStream os = socket.getOutputStream();
                        os.write(fasong.getBytes());
                        os.flush();
                        InputStream in = socket.getInputStream();
                        byte[] data = new byte[1024];
                        int len = in.read(data);
                        new String(data, 0, len);
                        String mac = pref.getString("MAC", "");
                        if (new String(data,0,len).equals("true")){
                            SharedPreferences.Editor editor = MainActivity.mactivity.getSharedPreferences("data", MODE_PRIVATE).edit();
                            editor.putString("Shohin_shoujihao",mobile);
                            editor.apply();
                            WodeFragment.wodeFragment.han();
                            if (mac!=null&&mac!="") {
                                Message msga = new Message();
                                //给message对象赋值
                                msga.what = 4;
                                mHandler.sendMessage(msga);
                            }else {
                                Message msga = new Message();
                                //给message对象赋值
                                msga.what = 3;
                                mHandler.sendMessage(msga);
                            }
                        }else if (new String(data,0,len).equals("false")){
                            Message msga = new Message();
                            //给message对象赋值
                            msga.what = 5;
                            mHandler.sendMessage(msga);
                        }
                    }else {
                        Message msga = new Message();
                        //给message对象赋值
                        msga.what = 2;
                        mHandler.sendMessage(msga);
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    Handler mHandler = new Handler() {
        //pmui线程
        public void handleMessage(Message msg) {
            // 更新UI
            switch (msg.what) {
                case 1:
//                    Toast.makeText(PhoneActivity.phoneActivity, "绑定成功", Toast.LENGTH_SHORT).show();
                    yz.setInputType(InputType.TYPE_CLASS_TEXT);//验证码可编辑
                    qr.setEnabled(true);//确认按钮可点击
                    break;
                case 2:
                    MyAlertDialog myAlertDialog = new MyAlertDialog(PhoneActivity.phoneActivity).builder()
                            .setTitle("错误提示！！！")
                            .setMsg("验证码错误")
                            .setPositiveButton("确认", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //showMsg("确认");
                                }
                            });
                    myAlertDialog.show();
                    break;
                case 3:
                    ConfirmDialog confirmDialog = new ConfirmDialog(PhoneActivity.phoneActivity);
                    confirmDialog.setLogoImg(R.mipmap.dialog_notice).setMsg("您的MAC地址尚未绑定，是否绑定MAC地址");
                    confirmDialog.setClickListener(new ConfirmDialog.OnBtnClickListener() {
                        @Override
                        public void ok() {
                            WiFiMAC wiFiMAC=new WiFiMAC();
                            wiFiMAC.getNewMac();
                            wiFiMAC.doMac();
                        }

                        @Override
                        public void cancel() {
                            PhoneActivity.phoneActivity.exit();
                        }
                    });
                    confirmDialog.show();
                    break;
                case 4:
                    Toast.makeText(MainActivity.mactivity, "绑定成功", Toast.LENGTH_SHORT).show();
                    exit();
                    break;
                case 5:
                    Toast.makeText(MainActivity.mactivity, "绑定失败", Toast.LENGTH_SHORT).show();
                    exit();
            }

        };
    };

        public void doGh(){
        FlyRouteBean flyRouteBean=new FlyRouteBean();
        flyRouteBean=init(flyRouteBean);//根据Bean类初始化一个需要提交的数据类
        Gson gson=new Gson();
        String route= gson.toJson(flyRouteBean);//通过Gson将Bean转化为Json字符串形式
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        JnqData jnqData=retrofit.create(JnqData.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<FlyRouteBean> call=jnqData.jnqFlyRoute(body);
        call.enqueue(new Callback<FlyRouteBean>() {
            @Override
            public void onResponse(Call<FlyRouteBean> call, Response<FlyRouteBean> response) {
                Log.e("随机数",response.body().getCj());
                yanz = Integer.parseInt(response.body().getCj());
                Message msga = new Message();
                //给message对象赋值
                msga.what = 1;
                mHandler.sendMessage(msga);
//                System.out.print("手机号为空2019-4-24"+response.body().getShohin_shoujihao());
//                if (response.body().getShohin_shoujihao()==null){
//                    System.out.print("手机号为空"+response.body().getShohin_shoujihao());
//                    yanzActivity yanzActivity=new yanzActivity();/*调用yanzActivity类向服务器传递手机号*/
//                    yanzActivity.doPost();
//                    quer=true;
//                }else{
//                    Log.e("手机号绑定提示","您的账户已绑定手机号");
//                    msg="您的账户已绑定手机号";
//                    tanchu();
//                    quer=false;
//                }
            }



            @Override
            public void onFailure(Call<FlyRouteBean> call, Throwable t) {
                Log.e("sssss",t.getMessage());
            }
        });
    }
    private FlyRouteBean init(FlyRouteBean flyRouteBean) {//向服务端发送的值
        // TODO Auto-generated method stub
//
//        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
//        shohin_gonghao=pref.getString("Shohin_gonghao","");
//        Log.e("sp储存的工号测试",shohin_gonghao);
//        flyRouteBean.setShohin_gonghao(shohin_gonghao);
        flyRouteBean.setShohin_shoujihao(phone_mobile.getText().toString());
        List<FlyRouteBean.SerialBean> pointsBeans=new ArrayList<FlyRouteBean.SerialBean>();
        FlyRouteBean.SerialBean pointsBean=new FlyRouteBean.SerialBean();
        pointsBean.setShohin_gonghao(phone_mobile.getText().toString());
        return flyRouteBean;
    }
    public void tanchu(){
        MyAlertDialog myAlertDialog = new MyAlertDialog(this).builder()
                .setTitle("错误提示！！！")
                .setMsg(msg)
                .setPositiveButton("确认", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //showMsg("确认");
                    }
                });
        myAlertDialog.show();
    }
    public void Judge(){
        ConfirmDialog confirmDialog = new ConfirmDialog(PhoneActivity.phoneActivity);
        confirmDialog.setLogoImg(R.mipmap.dialog_notice).setMsg("您的MAC地址尚未绑定，是否绑定MAC地址");
        confirmDialog.setClickListener(new ConfirmDialog.OnBtnClickListener() {
            @Override
            public void ok() {
                WiFiMAC wiFiMAC=new WiFiMAC();
                wiFiMAC.getNewMac();
                wiFiMAC.doMac();
            }

            @Override
            public void cancel() {
                PhoneActivity.phoneActivity.exit();
            }
        });
        confirmDialog.show();
    }
}
