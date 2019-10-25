package com.example.domain.greenapp.Fragment;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.example.domain.greenapp.R;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShidutableFragment extends Fragment {
    private SmartTable shidutable;
    private int mwidth;
    private Column<String> time=new Column<String>("日期","time");
    private Column<String>maxshidu=new Column<String>("当日最高湿度","maxshidu");
    private Column<String>minshidu=new Column<String>("当日最低湿度","minshidu");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_shidutable, container, false);
        List<shidu>list=new ArrayList<>();
        shidutable=view.findViewById(R.id.shidu_table);
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        int width = dm.widthPixels;
        mwidth=width-60;
        ShiduchartFragment sd=new ShiduchartFragment();
        list.add(new shidu(sd.newStr_7,sd.m7+"%RH",sd.x7+"%RH"));
        list.add(new shidu(sd.newStr_6,sd.m6+"%RH",sd.x6+"%RH"));
        list.add(new shidu(sd.newStr_5,sd.m5+"%RH",sd.x5+"%RH"));
        list.add(new shidu(sd.newStr_4,sd.m4+"%RH",sd.x4+"%RH"));
        list.add(new shidu(sd.newStr_3,sd.m3+"%RH",sd.x3+"%RH"));
        list.add(new shidu(sd.newStr_2,sd.m2+"%RH",sd.x2+"%RH"));
        list.add(new shidu(sd.newStr_1,sd.m1+"%RH",sd.x1+"%RH"));
        TableData<shidu>tableData=new TableData<shidu>("湿度表格",list,time,maxshidu,minshidu);
        shidutable.setTableData(tableData);
        shidutable.getConfig().setMinTableWidth(mwidth);
        shidutable.getConfig().setContentStyle(new FontStyle(60, Color.WHITE));
        shidutable.getConfig().setFixedYSequence(true);
        shidutable.getConfig().setFixedXSequence(true);
        shidutable.getConfig().setFixedCountRow(true);
        shidutable.getConfig().setFixedTitle(true);
        shidutable.getConfig().setColumnTitleHorizontalPadding(60);;
        shidutable.getConfig().setTableTitleStyle(new FontStyle(70,Color.WHITE));
        shidutable.getConfig().setColumnTitleStyle(new FontStyle(40,Color.WHITE));
        return view;
    }
    public class shidu{
        public shidu(String time,String maxshidu,String minshidu){
            this.maxshidu=maxshidu;
            this.minshidu=minshidu;
            this.time=time;
        }
        private String time;
        private String maxshidu;
        private String minshidu;
    }
}
