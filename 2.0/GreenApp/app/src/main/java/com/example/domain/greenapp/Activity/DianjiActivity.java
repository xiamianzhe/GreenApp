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
import android.view.KeyEvent;
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
import com.example.domain.greenapp.Fragment.DianjichartFragment;
import com.example.domain.greenapp.Fragment.DianjitableFragment;
import com.example.domain.greenapp.Fragment.ShiduchartFragment;
import com.example.domain.greenapp.Fragment.ShidutableFragment;;
import com.example.domain.greenapp.Fragment.WenduchartFragment;
import com.example.domain.greenapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DianjiActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar dianji_title;
    private ImageView dianji_back;
    private RadioGroup dianji_rg_group;
    private RadioButton dianji_rb_chart;
    private RadioButton dianji_rb_table;
    private RelativeLayout dianji_chart_content;
    private DianjichartFragment chartf;
    private DianjitableFragment tablef;
    private Fragment currentFragment=new Fragment();
    private FragmentManager manager;
    private Spinner spinner ;
    private ArrayAdapter adapter ;
    private TextView timechoose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dianji);
        dianji_title=(Toolbar)findViewById(R.id.dianji_title);
        dianji_back=(ImageView)findViewById(R.id.dianji_back);
        dianji_rg_group=(RadioGroup)findViewById(R.id.dianji_rg_group);
        dianji_rb_chart=(RadioButton)findViewById(R.id.dianji_rb_chart);
        dianji_rb_table=(RadioButton)findViewById(R.id.dianji_rb_table);
        timechoose=(TextView)findViewById(R.id.dianji_timechoose);
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        timechoose.setText(sdf.format(date));
        DianjichartFragment sd=new DianjichartFragment();
        sd.sdate=sdf.format(date);
        //图标表格切换页面点击按钮
        dianji_rb_chart.setOnClickListener(this);
        dianji_rb_table.setOnClickListener(this);
        timechoose.setOnClickListener(this);

        //绘制"图标"，"表格"图标
        Drawable drawablechart = getResources().getDrawable(R.drawable.radiobutton_chart);
        drawablechart.setBounds(0, 0, 50, 50);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        dianji_rb_chart.setCompoundDrawables(drawablechart, null, null, null);//只放上面
        Drawable drawabletable = getResources().getDrawable(R.drawable.radiobutton_table);
        drawabletable.setBounds(0, 0, 50, 50);
        dianji_rb_table.setCompoundDrawables(drawabletable, null, null, null);
        dianji_rg_group.check(R.id.dianji_rb_chart);

        //取消自带标题栏
        dianji_title.setTitle("");
        setSupportActionBar(dianji_title);
        dianji_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                empty();
                overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
            }
        });
        dianji_chart_content=(RelativeLayout)findViewById(R.id.shidu_chart_content);
        //图表表格fragnment
        initFragment();
        showFragment(chartf);
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
                DianjichartFragment dj=new  DianjichartFragment();
                dj.cj=spinner.getSelectedItem().toString();
                dj.doPost();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dianji_rb_chart:
                showFragment(chartf);
                break;
            case R.id.dianji_rb_table:
                showFragment(tablef);
                break;
            case R.id.dianji_timechoose:
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
        chartf = new DianjichartFragment();
        chartf.setArguments(bundle);
        bundle = new Bundle();
        bundle.putInt("tag", 2);
        tablef = new DianjitableFragment();
        tablef.setArguments(bundle);
    }
    private void showFragment(Fragment fragment) {
        if (currentFragment!=fragment) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.hide(currentFragment);
            currentFragment = fragment;
            if (!fragment.isAdded()) {
                transaction.add(R.id.dianji_chart_content, fragment).show(fragment).commit();
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
                DianjichartFragment sd=new DianjichartFragment();
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            finish();  //finish当前activity
            overridePendingTransition(R.anim.anim_right,R.anim.anim_toright);
        }
        return super.onKeyDown(keyCode, event);
    }
    public void empty(){
        DianjichartFragment sd=new DianjichartFragment();
        sd.map=null;
        sd.newStr_1=null;
        sd.newStr_2=null;
        sd.newStr_3=null;
        sd.newStr_4=null;
        sd.newStr_5=null;
        sd.newStr_6=null;
        sd.newStr_7=null;
        sd.p1=0;
        sd.p2=0;
        sd.p3=0;
        sd.p4=0;
        sd.p5=0;
        sd.p6=0;
        sd.p7=0;
        sd.n1=0;
        sd.n2=0;
        sd.n3=0;
        sd.n4=0;
        sd.n5=0;
        sd.n6=0;
        sd.n7=0;

    }
}
