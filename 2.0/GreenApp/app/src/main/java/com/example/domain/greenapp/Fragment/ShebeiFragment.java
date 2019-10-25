package com.example.domain.greenapp.Fragment;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.domain.greenapp.R;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import java.util.ArrayList;
import java.util.List;



public class ShebeiFragment extends Fragment implements ObservableScrollViewCallbacks {
    private TabLayout shebei_tablayout;
    private ViewPager shebei_viewpager;
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> titles=new ArrayList<>();

    //    private String[] titles={"车间01","车间02","车间03"};
    private MyAdapter adapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shebei, container, false);
        String zw=this.getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).getString("zhiwu","");
        if (zw.equals("生产员")){
            titles.add(this.getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).getString("cj",""));
        }else {
            int i = 0;
            while ( i==0||i>0) {
                String str=this.getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).getString("cjh"+i,"");
                i++;
                if (str==null||str=="")
                    break;
                titles.add("车间"+str);
                Log.e("bbbbbbbbbb", str);
            }
        }
        TabchejianoneFragment tb=new TabchejianoneFragment();
        String ew=titles.get(0).substring(titles.get(0).length()-3);
        tb.cj=ew;
        tb.doPost1();
        tb.doPost2();
        tb.doPost3();
        tb.doPost4();
        shebei_tablayout=view.findViewById(R.id.shebei_tablayout);
        shebei_viewpager=view.findViewById(R.id.shebei_viewpager);
        shebei_tablayout.setTabIndicatorFullWidth(false);
        shebei_tablayout.setUnboundedRipple(true);
        GradientDrawable gradientDrawable=new GradientDrawable();
        gradientDrawable.setCornerRadius(5);
        shebei_tablayout.setSelectedTabIndicator(gradientDrawable);
        for(int i=1;i<=titles.size();i++){
            fragments.add(new TabchejianoneFragment());
        }
        adapter=new MyAdapter(getActivity().getSupportFragmentManager());
        shebei_viewpager.setAdapter(adapter);
        shebei_tablayout.setupWithViewPager(shebei_viewpager);

        shebei_tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                showIndex(tab.getPosition());

                TabchejianoneFragment tb=new TabchejianoneFragment();
                String ewS=titles.get(tab.getPosition()).substring(titles.get(tab.getPosition()).length()-3);
                Log.e("设备车间号选择",""+ewS);
                tb.fuzer1=null;
                tb.jqbh1=null;
                tb.jqxh1=null;
                tb.cgsj1=null;
                tb.ccsj1=null;
                tb.moshi=null;
                tb.fengsu=null;
                tb.wendu=null;
//                tb.kaig=null;
                tb.cj=ewS;
                tb.doPost1();
                tb.doPost2();
                tb.doPost3();
                tb.doPost4();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm){
            super(fm);
        }
        public Fragment getItem(int position){
            return fragments.get(position);
        }
        public int getCount(){
            return fragments.size();
        }
        public CharSequence getPageTitle(int position){
            return titles.get(position);
        }
    }
    private void showIndex(int index) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            if (i == index) {
                transaction.show(fragments.get(i));
            } else {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.commit();
    }

    //上下滑动控件的方法
    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }

}
