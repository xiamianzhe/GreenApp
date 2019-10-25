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
import com.example.domain.greenapp.Fragment.ShiduchartFragment;
import com.example.domain.greenapp.Fragment.ShidutableFragment;;
import com.example.domain.greenapp.Fragment.WenduchartFragment;
import com.example.domain.greenapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ShiduActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar shidu_title;
    private ImageView shidu_back;
    private RadioGroup shidu_rg_group;
    private RadioButton shidu_rb_chart;
    private RadioButton shidu_rb_table;
    private RelativeLayout shidu_chart_content;
    private ShiduchartFragment chartf;
    private ShidutableFragment tablef;
    private Fragment currentFragment=new Fragment();
    private FragmentManager manager;
    private Spinner spinner ;
    private ArrayAdapter adapter ;
    private TextView timechoose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shidu);
        shidu_title=(Toolbar)findViewById(R.id.shidu_title);
        shidu_back=(ImageView)findViewById(R.id.shidu_back);
        shidu_rg_group=(RadioGroup)findViewById(R.id.shidu_rg_group);
        shidu_rb_chart=(RadioButton)findViewById(R.id.shidu_rb_chart);
        shidu_rb_table=(RadioButton)findViewById(R.id.shidu_rb_table);
        timechoose=(TextView)findViewById(R.id.shidu_timechoose);
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        timechoose.setText(sdf.format(date));
        ShiduchartFragment sd=new ShiduchartFragment();
        sd.sdate=sdf.format(date);
        //图标表格切换页面点击按钮
        shidu_rb_chart.setOnClickListener(this);
        shidu_rb_table.setOnClickListener(this);
        timechoose.setOnClickListener(this);

        //绘制"图标"，"表格"图标
        Drawable drawablechart = getResources().getDrawable(R.drawable.radiobutton_chart);
        drawablechart.setBounds(0, 0, 50, 50);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        shidu_rb_chart.setCompoundDrawables(drawablechart, null, null, null);//只放上面
        Drawable drawabletable = getResources().getDrawable(R.drawable.radiobutton_table);
        drawabletable.setBounds(0, 0, 50, 50);
        shidu_rb_table.setCompoundDrawables(drawabletable, null, null, null);
        shidu_rg_group.check(R.id.shidu_rb_chart);

        //取消自带标题栏
        shidu_title.setTitle("");
        setSupportActionBar(shidu_title);
        shidu_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
                empty();
            }
        });
        shidu_chart_content=(RelativeLayout)findViewById(R.id.shidu_chart_content);
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
                ShiduchartFragment sd=new ShiduchartFragment();
                sd.cj=spinner.getSelectedItem().toString();
                sd.doPost();
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
            case R.id.shidu_rb_chart:
                showFragment(chartf);
                break;
            case R.id.shidu_rb_table:
                showFragment(tablef);
                break;
            case R.id.shidu_timechoose:
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
        chartf = new ShiduchartFragment();
        chartf.setArguments(bundle);
        bundle = new Bundle();
        bundle.putInt("tag", 2);
        tablef = new ShidutableFragment();
        tablef.setArguments(bundle);
    }
    private void showFragment(Fragment fragment) {
        if (currentFragment!=fragment) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.hide(currentFragment);
            currentFragment = fragment;
            if (!fragment.isAdded()) {
                transaction.add(R.id.shidu_chart_content, fragment).show(fragment).commit();
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
                ShiduchartFragment sd=new ShiduchartFragment();
                sd.chartView.setInteractive(false);
                sd.sdate=sdf.format(date);
                empty();
                sd.doPost();
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
        ShiduchartFragment sd=new ShiduchartFragment();
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
        sd.x1=null;
        sd.x2=null;
        sd.x3=null;
        sd.x4=null;
        sd.x5=null;
        sd.x6=null;
        sd.x7=null;
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
