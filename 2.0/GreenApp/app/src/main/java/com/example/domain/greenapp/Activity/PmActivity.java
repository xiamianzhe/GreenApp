package com.example.domain.greenapp.Activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.domain.greenapp.Fragment.PmchartFragment;
import com.example.domain.greenapp.Fragment.PmtableFragment;
import com.example.domain.greenapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PmActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar pm_title;
    private ImageView pm_back;
    private RadioGroup pm_rg_group;
    private RadioButton pm_rb_chart;
    private RadioButton pm_rb_table;
    private RelativeLayout pm_chart_content;
    private PmchartFragment chartf;
    private PmtableFragment tablef;
    private Fragment currentFragment=new Fragment();
    private FragmentManager manager;
    private Spinner spinner ;
    private ArrayAdapter adapter ;
    private TextView timechoose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm);
        pm_title=(Toolbar)findViewById(R.id.pm_title);
        pm_back=(ImageView)findViewById(R.id.pm_back);
        pm_rg_group=(RadioGroup)findViewById(R.id.pm_rg_group);
        pm_rb_chart=(RadioButton)findViewById(R.id.pm_rb_chart);
        pm_rb_table=(RadioButton)findViewById(R.id.pm_rb_table);
        timechoose=(TextView)findViewById(R.id.pm_timechoose);
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        timechoose.setText(sdf.format(date));
        PmchartFragment pm=new PmchartFragment();
        pm.sdate=sdf.format(date);
        //图标表格切换页面点击按钮
        pm_rb_chart.setOnClickListener(this);
        pm_rb_table.setOnClickListener(this);
        timechoose.setOnClickListener(this);

        //绘制"图标"，"表格"图标
        Drawable drawablechart = getResources().getDrawable(R.drawable.radiobutton_chart);
        drawablechart.setBounds(0, 0, 50, 50);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        pm_rb_chart.setCompoundDrawables(drawablechart, null, null, null);//只放上面
        Drawable drawabletable = getResources().getDrawable(R.drawable.radiobutton_table);
        drawabletable.setBounds(0, 0, 50, 50);
        pm_rb_table.setCompoundDrawables(drawabletable, null, null, null);
        pm_rg_group.check(R.id.pm_rb_chart);

        //取消自带标题栏
        pm_title.setTitle("");
        setSupportActionBar(pm_title);
        pm_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
                empty();
            }
        });
        pm_chart_content=(RelativeLayout)findViewById(R.id.pm_chart_content);
        //图表表格fragnment
        this.spinner = (Spinner) this.findViewById(R.id.spinner1);
        //两种方式给下拉列表注册适配器
        //1 :new 适配器对象(content对象，样式ID，数据集合)
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, getDataSource());
        spinner.setAdapter(adapter);
//        Log.e("spinner",""+spinner.getSelectedItem().toString());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                empty();
                Log.e("spinner",""+spinner.getSelectedItem().toString());//打印选中的车间号
                PmchartFragment pm=new PmchartFragment();
                pm.cj=spinner.getSelectedItem().toString();
                pm.doPost();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        initFragment();
        showFragment(chartf);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pm_rb_chart:
                showFragment(chartf);
                break;
            case R.id.pm_rb_table:
                showFragment(tablef);
                break;
            case R.id.pm_timechoose:
                showDatePicker();
                break;
            default:
                break;
        }
    }
    private void initFragment() {
        manager = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putInt("tag", 1);
        chartf = new PmchartFragment();
        chartf.setArguments(bundle);
        bundle = new Bundle();
        bundle.putInt("tag", 2);
        tablef = new PmtableFragment();
        tablef.setArguments(bundle);
    }
    private void showFragment(Fragment fragment) {
        if (currentFragment!=fragment) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.hide(currentFragment);
            currentFragment = fragment;
            if (!fragment.isAdded()) {
                transaction.add(R.id.pm_chart_content, fragment).show(fragment).commit();
            } else {
                transaction.show(fragment).commit();
            }
        }
    }
    private void showDatePicker() {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        int month=cal.get(Calendar.MONTH);//获取月份
        int day=cal.get(Calendar.DATE);//获取日
        startDate.set(year-5, month, month);
        endDate.set(year, month, day);//最大选择时间  月份是0-11；
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                timechoose.setText(sdf.format(date));
                Log.d("输出选择的时间",  sdf.format(date));
                timechoose.setTextColor(Color.WHITE);
                PmchartFragment pm=new PmchartFragment();
                pm.chartView.setInteractive(false);
                pm.sdate=sdf.format(date);
                empty();
                pm.doPost();
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确认")//确认按钮文字
                .setTitleSize(20)//标题文字大小
                .setTitleText("")//标题文字
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setTitleBgColor(Color.WHITE)//标题背景颜色 Night mode
                .setBgColor(Color.WHITE)//滚轮背景颜色 Night mode
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("年", "月", "日","时","分","秒")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(true)//是否显示为对话框样式
                .build();
        pvTime.show();
    }
    public void empty(){
        PmchartFragment sd=new PmchartFragment();
        sd.map=null;
        sd.newStr_1=null;
        sd.newStr_2=null;
        sd.newStr_3=null;
        sd.newStr_4=null;
        sd.newStr_5=null;
        sd.newStr_6=null;
        sd.newStr_7=null;
        sd.m1=null;
        sd.m2=null;
        sd.m3=null;
        sd.m4=null;
        sd.m5=null;
        sd.m6=null;
        sd.m7=null;
//        PmtableFragment pmd=new PmtableFragment();
    }
    public List<String> getDataSource() {
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        List<String> list = new ArrayList<String>();
        String zw=pref.getString("zhiwu","");
        int i = 0;
        if (zw.equals("生产员")){
            String  cj=pref.getString("cj","");
            list.add(cj);
        }else {
            while (i == 0 || i > 0) {
                String str = pref.getString("cjh" + i, "");
                i++;
                if (str == null || str == "")
                    break;
                list.add(str);
                Log.e("bbbbbbbbbb", str);
            }
        }
        return list;
    }

}
