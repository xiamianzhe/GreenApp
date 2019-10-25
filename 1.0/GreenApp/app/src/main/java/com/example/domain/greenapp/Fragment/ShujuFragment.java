package com.example.domain.greenapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.domain.greenapp.Activity.DianjiActivity;
import com.example.domain.greenapp.Activity.PmActivity;
import com.example.domain.greenapp.Activity.ShiduActivity;
import com.example.domain.greenapp.Activity.WenduActivity;
import com.example.domain.greenapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShujuFragment extends Fragment{
    private ImageButton ib_wendu;
    private ImageButton ib_shidu;
    private ImageButton ib_huichen;
    private ImageButton ib_dianji;
    public static boolean error;//判断缺少那天数据
    public static boolean dr;//判断当天温度数据是否缺失
    public static boolean dr_2;//判断当天湿度数据是否缺失
    public static List<String> cw = new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_shuju, container, false);
        ib_wendu=view.findViewById(R.id.ib_wendu);
        ib_shidu=view.findViewById(R.id.ib_shidu);
        ib_huichen=view.findViewById(R.id.huichen);
        ib_dianji=view.findViewById(R.id.dianji);
        ib_wendu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),WenduActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_left,R.anim.anim_toleft);
            }
        });
        ib_shidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),ShiduActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_left,R.anim.anim_toleft);
            }
        });
        ib_huichen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),PmActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_left,R.anim.anim_toleft);
            }
        });
        ib_dianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),DianjiActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_left,R.anim.anim_toleft);
            }
        });
        return view;
    }

}
