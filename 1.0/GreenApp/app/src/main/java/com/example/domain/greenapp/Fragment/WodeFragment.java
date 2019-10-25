package com.example.domain.greenapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.domain.greenapp.Activity.MainActivity;
import com.example.domain.greenapp.Activity.MymsgActivity;
import com.example.domain.greenapp.Activity.NullActivity;
import com.example.domain.greenapp.Activity.PhoneActivity;
import com.example.domain.greenapp.Activity.SettingActivity;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.Theenvironment.WiFiMAC;
import com.hb.dialog.dialog.ConfirmDialog;
import com.hb.dialog.myDialog.MyAlertDialog;

import static android.content.Context.MODE_PRIVATE;

public class WodeFragment extends Fragment {
    private LinearLayout mymessage_layout;
    private RelativeLayout phone_layout;
    private RelativeLayout setting_layout;
    private RelativeLayout help_layout;
    TextView zh;
    TextView mb_phone;
    public static WodeFragment wodeFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_wode, container, false);
        wodeFragment=this;
        mymessage_layout=view.findViewById(R.id.mymessage_layout);
        phone_layout=view.findViewById(R.id.phone_layout);
        setting_layout=view.findViewById(R.id.setting_layout);
        help_layout=view.findViewById(R.id.help_layout);
        zh=(TextView) view.findViewById(R.id.yzh);
        mb_phone=(TextView) view.findViewById(R.id.mymessage_tv_phone);
        mymessage_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), MymsgActivity.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.anim_left, R.anim.anim_toleft);

            }
        });
        phone_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            SharedPreferences pref = MainActivity.mactivity.getSharedPreferences("data", MODE_PRIVATE);
            String sjh = pref.getString("Shohin_shoujihao", "");
            if (sjh.length()<=0) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),PhoneActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_left,R.anim.anim_toleft);
            }else {
                String mac = pref.getString("MAC", "");
                if (mac!=null&&mac!="") {
                    ConfirmDialog confirmDialog = new ConfirmDialog(MainActivity.mactivity);

                    confirmDialog.setLogoImg(R.mipmap.dialog_notice).setMsg("已绑定手机号，请勿重复操作");
                    confirmDialog.setClickListener(new ConfirmDialog.OnBtnClickListener() {
                        @Override
                        public void ok() {
                        }

                        @Override
                        public void cancel() {
                        }
                    });
                    confirmDialog.show();
                }else {
                    ConfirmDialog confirmDialog = new ConfirmDialog(MainActivity.mactivity);
                    confirmDialog.setLogoImg(R.mipmap.dialog_notice).setMsg("您的MAC地址尚未绑定，是否绑定MAC地址");
                    confirmDialog.setClickListener(new ConfirmDialog.OnBtnClickListener() {
                        @Override
                        public void ok() {
                            WiFiMAC wiFiMAC=new WiFiMAC();
                            wiFiMAC.getNewMac();
                            wiFiMAC.doMac2();
                        }

                        @Override
                        public void cancel() {
                        }
                    });
                    confirmDialog.show();
                }
            }
            }
        });
        setting_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),SettingActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_left,R.anim.anim_toleft);
            }
        });
        help_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),NullActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_left,R.anim.anim_toleft);
            }
        });
        String yzh=this.getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).getString("Zhanghu","");
        String mb=this.getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).getString("Shohin_shoujihao","");
        Log.e("sp储存输出查看",yzh);
        zh.setText(yzh);
        mb_phone.setText(mb);
        return view;
    }

    Handler mHandler = new Handler() {
        //pmui线程
        public void handleMessage(Message msg) {
            // 更新UI
            switch (msg.what) {
                case 1:
//                    Toast.makeText(PhoneActivity.phoneActivity, "绑定成功", Toast.LENGTH_SHORT).show();
                    String sjh=MainActivity.mactivity.getSharedPreferences("data", Context.MODE_PRIVATE).getString("Shohin_shoujihao","");
                    mb_phone.setText(sjh);
                    break;
            }

        };
    };

    public void han(){
        //对手机UI界面进行更新
        Message msga = new Message();
        //给message对象赋值
        msga.what = 1;
        mHandler.sendMessage(msga);
    }
}
