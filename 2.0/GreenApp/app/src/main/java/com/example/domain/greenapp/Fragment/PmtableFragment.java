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

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class PmtableFragment extends Fragment {
    private SmartTable pmtable;
    private int mwidth;
    private Column<String> time=new Column<String>("日期","time");
    private Column<String>pm=new Column<String>("当日pm2.5浓度","pm");
    private List<PmtableFragment.pm> list=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment\
        View view=inflater.inflate(R.layout.fragment_pmtable, container, false);

        pmtable=view.findViewById(R.id.pm_table);
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        int width = dm.widthPixels;
        mwidth=width-60;
        initdatapm();
        pmtable.getConfig().setMinTableWidth(mwidth);
        pmtable.getConfig().setContentStyle(new FontStyle(60, Color.WHITE));
        pmtable.getConfig().setFixedYSequence(true);
        pmtable.getConfig().setFixedXSequence(true);
        pmtable.getConfig().setFixedCountRow(true);
        pmtable.getConfig().setFixedTitle(true);
        pmtable.getConfig().setColumnTitleHorizontalPadding(60);;
        pmtable.getConfig().setTableTitleStyle(new FontStyle(70,Color.WHITE));
        pmtable.getConfig().setColumnTitleStyle(new FontStyle(40,Color.WHITE));
        return view;
    }
    public void initdatapm(){
        PmchartFragment sd=new PmchartFragment();
        list.add(new PmtableFragment.pm(sd.newStr_7,sd.m7+"%RH"));
        list.add(new PmtableFragment.pm(sd.newStr_6,sd.m6+"%RH"));
        list.add(new PmtableFragment.pm(sd.newStr_5,sd.m5+"%RH"));
        list.add(new PmtableFragment.pm(sd.newStr_4,sd.m4+"%RH"));
        list.add(new PmtableFragment.pm(sd.newStr_3,sd.m3+"%RH"));
        list.add(new PmtableFragment.pm(sd.newStr_2,sd.m2+"%RH"));
        list.add(new PmtableFragment.pm(sd.newStr_2,sd.m1+"%RH"));
        TableData<PmtableFragment.pm> tableData=new TableData<PmtableFragment.pm>("Pm2.5表格",list,time,pm);
        pmtable.setTableData(tableData);
    }
    public class pm{
        public pm(String time,String pm){
            this.pm=pm;
            this.time=time;
        }
        private String time;
        private String pm;
    }
}
