package com.example.domain.greenapp.Fragment;


import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.example.domain.greenapp.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class WendutableFragment extends Fragment {
    private SmartTable wendutable;
    private int mwidth;
    private Column<String>time=new Column<String>("日期","time");
    private Column<String>maxwendu=new Column<String>("当日最高温度","maxwendu");
    private Column<String>minwendu=new Column<String>("当日最低温度","minwendu");
    private List<wendu>list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_wendutable, container, false);

        wendutable=view.findViewById(R.id.wendu_table);
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        int width = dm.widthPixels;
        mwidth=width-60;
        wendutable.getConfig().setMinTableWidth(mwidth);
        wendutable.getConfig().setContentStyle(new FontStyle(60, Color.WHITE));
        wendutable.getConfig().setFixedYSequence(true);
        wendutable.getConfig().setFixedXSequence(true);
        wendutable.getConfig().setFixedCountRow(true);
        wendutable.getConfig().setFixedTitle(true);
        wendutable.getConfig().setColumnTitleHorizontalPadding(60);;
        wendutable.getConfig().setTableTitleStyle(new FontStyle(70,Color.WHITE));
        wendutable.getConfig().setColumnTitleStyle(new FontStyle(40,Color.WHITE));
        //设置背景
        /*wendutable.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if(cellInfo.row%2 ==1) {
                    return ContextCompat.getColor(getActivity(), R.color.white);
                }else{
                    return TableConfig.INVALID_COLOR;
                }
            }
        });*/
        initdata();
        return view;
    }
    public void initdata(){
        WenduchartFragment wd=new  WenduchartFragment();
        list.add(new wendu(wd.newStr_7,wd.m7+"℃",wd.x7+"℃"));
        list.add(new wendu(wd.newStr_6,wd.m6+"℃",wd.x6+"℃"));
        list.add(new wendu(wd.newStr_5,wd.m5+"℃",wd.x5+"℃"));
        list.add(new wendu(wd.newStr_4,wd.m4+"℃",wd.x4+"℃"));
        list.add(new wendu(wd.newStr_3,wd.m3+"℃",wd.x3+"℃"));
        list.add(new wendu(wd.newStr_2,wd.m2+"℃",wd.x2+"℃"));
        list.add(new wendu(wd.newStr_1,wd.m1+"℃",wd.x1+"℃"));
        TableData<wendu> tableData = new TableData<>("温度表格", list, time,maxwendu,minwendu);
        wendutable.setTableData(tableData);
    }
    public class wendu{
        public wendu(String time,String maxwendu,String minwendu){
            this.maxwendu=maxwendu;
            this.minwendu=minwendu;
            this.time=time;
        }
        private String time;
        private String maxwendu;
        private String minwendu;
    }
}
