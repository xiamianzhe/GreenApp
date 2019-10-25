package com.example.domain.greenapp.Fragment;


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
public class DianjitableFragment extends Fragment {
    private SmartTable dianjitable;
    private int mwidth;
    private Column<String> time=new Column<String>("日期","time");
    private Column<String>pinci=new Column<String>("当日使用频次","pinci");
    private Column<String>nenghao=new Column<String>("当日能耗","nenghao");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_dianjitable, container, false);
        List<dianji>list=new ArrayList<>();
        dianjitable=view.findViewById(R.id.dianji_table);
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        int width = dm.widthPixels;
        mwidth=width-60;
        DianjichartFragment dj=new DianjichartFragment();
        list.add(new dianji(dj.newStr_7,dj.p7+"次",dj.n7+"度"));
        list.add(new dianji(dj.newStr_6,dj.p6+"次",dj.n6+"度"));
        list.add(new dianji(dj.newStr_5,dj.p5+"次",dj.n5+"度"));
        list.add(new dianji(dj.newStr_4,dj.p4+"次",dj.n4+"度"));
        list.add(new dianji(dj.newStr_3,dj.p3+"次",dj.n3+"度"));
        list.add(new dianji(dj.newStr_2,dj.p2+"次",dj.n2+"度"));
        list.add(new dianji(dj.newStr_1,dj.p1+"次",dj.n1+"度"));
        TableData<dianji>tableData=new TableData<dianji>("电机状态",list,time,pinci,nenghao);
        dianjitable.setTableData(tableData);
        dianjitable.getConfig().setMinTableWidth(mwidth);
        dianjitable.getConfig().setFixedYSequence(true);
        dianjitable.getConfig().setFixedXSequence(true);
        dianjitable.getConfig().setFixedCountRow(true);
        dianjitable.getConfig().setFixedTitle(true);
        dianjitable.getConfig().setShowXSequence(false);
        dianjitable.getConfig().setColumnTitleHorizontalPadding(40);;
        dianjitable.getConfig().setTableTitleStyle(new FontStyle(70,Color.WHITE));
        dianjitable.getConfig().setColumnTitleStyle(new FontStyle(54,Color.WHITE));
        dianjitable.getConfig().setContentStyle(new FontStyle(50,Color.WHITE));
        return view;
    }
    public class dianji{
        public dianji(String time,String pinci,String nenghao){
            this.pinci=pinci;
            this.nenghao=nenghao;
            this.time=time;
        }
        private String time;
        private String pinci;
        private String nenghao;
    }
}
