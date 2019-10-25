package com.example.domain.greenapp.check_net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.domain.greenapp.Activity.LoginActivity;
import com.example.domain.greenapp.Activity.MainActivity;
import com.example.domain.greenapp.Activity.SettingActivity;
import com.example.domain.greenapp.Fragment.ShouyeFragment;
import com.example.domain.greenapp.R;
import com.example.domain.greenapp.Theenvironment.Duanwang;

/**
 * Created by Carson_Ho on 16/10/31.
 */
public class NetWorkStateReceiver extends BroadcastReceiver {
    int Ths=0;
    public void Theinternet(){
//       MainActivity mainActivity=new MainActivity();
//       mainActivity.goshebeiFragment();
//       MainActivity.mactivity
//        shouyeFragment.doPost();
        ShouyeFragment.shouyeFragment. hj.clear();
        ShouyeFragment.shouyeFragment.doPost();
    }
    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("网络状态发生变化");
        //检测API是不是小于23，因为到了API23之后getNetworkInfo(int networkType)方法被弃用
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP) {

            //获得ConnectivityManager对象
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            //获取ConnectivityManager对象对应的NetworkInfo对象
            //获取WIFI连接的信息
            NetworkInfo wifiNetworkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            //获取移动数据连接的信息
            NetworkInfo dataNetworkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (wifiNetworkInfo.isConnected() && dataNetworkInfo.isConnected()) {
                Toast.makeText(context, "WIFI已连接,移动数据已连接", Toast.LENGTH_SHORT).show();
//                Theinternet();
            } else if (wifiNetworkInfo.isConnected() && !dataNetworkInfo.isConnected()) {
                Toast.makeText(context, "WIFI已连接,移动数据已断开", Toast.LENGTH_SHORT).show();
//                Theinternet();
            } else if (!wifiNetworkInfo.isConnected() && dataNetworkInfo.isConnected()) {
                Toast.makeText(context, "WIFI已断开,移动数据已连接", Toast.LENGTH_SHORT).show();
//                Theinternet();
            } else {
                Toast.makeText(context, "WIFI已断开,移动数据已断开", Toast.LENGTH_SHORT).show();
//                while (true){
//
//                }
            }
//API大于23时使用下面的方式进行网络监听
        }else {

            System.out.println("API level 大于23");
            //获得ConnectivityManager对象
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            //获取所有网络连接的信息
            Network[] networks = connMgr.getAllNetworks();
            //用于存放网络连接信息
            StringBuilder sb = new StringBuilder();
            //通过循环将网络信息逐个取出来
            for (int i=0; i < networks.length; i++){
                //获取ConnectivityManager对象对应的NetworkInfo对象
                NetworkInfo networkInfo = connMgr.getNetworkInfo(networks[i]);
                sb.append(networkInfo.getTypeName() + " connect is " + networkInfo.isConnected());
            }

                if ( sb.toString()==""){
                    Toast.makeText(context, "网络连接已断开", Toast.LENGTH_SHORT).show();
//                    intent=new Intent(context,Duanwang.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
                    Ths=1;
                }
            if (Ths==1&&!sb.toString().equals("")) {//
//                Intent intent = new Intent(g, LoginActivity.class);
                        Theinternet();
                Log.e("网络测试",sb.toString());
//                intent=new Intent(context,MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
                Toast.makeText(context, "网络已连接", Toast.LENGTH_SHORT).show();
                Ths=0;
            }

        }
    }
}