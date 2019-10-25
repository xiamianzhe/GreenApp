package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Dictionary;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.DataBean;
import pojo.employee11;
import pojo.employee2;
import pojo.employee7;

@Controller
//查询温度、湿度PM2.5的最高值与最低值
public class DataController {
	@RequestMapping("/DataBean")
	@ResponseBody
	@Test
	public employee11 testJson(@RequestBody employee11 user){
		String resource = "com/atguiigu/mybatis/test/aam.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession opensession = sqlSessionFactory.openSession();
		/*使用Map储存返回的值*/
		Map<String, String> map = new HashMap<String, String>();
		String date,date2,date3,date4,date5,date6,date7;
		/*周期查询条件*/
    	Calendar calendar = new GregorianCalendar();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//规定时间格式
    	date=user.getShohin_shijian();
    	Date date1;
		try {
			date1 = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	System.out.print("接收到的时间"+date);
    	System.out.println("转化后的时间"+date1);
    	try {
			calendar.setTime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	calendar.add(calendar.DATE,-1);//前一天
    	date2= sdf.format(calendar.getTime());
    	calendar.add(calendar.DATE,-1);//前二天
    	date3= sdf.format(calendar.getTime());
    	calendar.add(calendar.DATE,-1);//前三天
    	date4= sdf.format(calendar.getTime());
    	calendar.add(calendar.DATE,-1);//前四天
    	date5= sdf.format(calendar.getTime());
    	calendar.add(calendar.DATE,-1);//前五天
    	date6= sdf.format(calendar.getTime());
    	calendar.add(calendar.DATE,-1);//前六天
    	date7= sdf.format(calendar.getTime());
    	System.out.print(date2+date3+date4+date5+date6+date7+"\n");
		try {
        	List<employee11> employee=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.selectByTime2",user.getCj());
        	System.out.println(user.getCj());
        	System.out.println(employee);
        	employee11 mac=null;
        	int a=0;
        	if(a<employee.size()) { 
        	 for(int i=0;i<employee.size();i++){
        		 mac= employee.get(i);
        		 String sj=mac.getShohin_shijian();
        		 String newStr=(sj.substring(0,10));//取后5位
        		 if(newStr.equals(date7)) {
        			 map.put("max_7", mac.getMax_shohin_wendu());
        			 map.put("min_7", mac.getMin_shohin_wendu());
        			 map.put("s_max_7", mac.getMax_shohin_shidu());
        			 map.put("s_max_7", mac.getMin_shohin_wendu());
        			 map.put("s_min_7", mac.getMax_shohin_wendu());
        			 map.put("p_max_7", mac.getMax_pm());
        			 map.put("p_min_7", mac.getMin_pm());
        			 map.put("shohin_shijian_7",date7);
        			 System.out.print("7"+date7);
        		}
        		
        		if(newStr.equals(date6)) {
        			 map.put("max_6", mac.getMax_shohin_wendu());
        			 map.put("min_6", mac.getMin_shohin_wendu());
        			 map.put("s_max_6", mac.getMax_shohin_shidu());
        			 map.put("s_max_6", mac.getMin_shohin_wendu());
        			 map.put("s_min_6", mac.getMax_shohin_wendu());
        			 map.put("p_max_6", mac.getMax_pm());
        			 map.put("p_min_6", mac.getMin_pm());
        			map.put("shohin_shijian_6",date6);
        			System.out.print("6"+date6);
        		}
        		
        		if(newStr.equals(date5)) {
        			 map.put("max_5", mac.getMax_shohin_wendu());
        			 map.put("min_5", mac.getMin_shohin_wendu());
        			 map.put("s_max_5", mac.getMax_shohin_shidu());
        			 map.put("s_max_5", mac.getMin_shohin_wendu());
        			 map.put("s_min_5", mac.getMax_shohin_wendu());
        			 map.put("p_max_5", mac.getMax_pm());
        			 map.put("p_min_5", mac.getMin_pm());
        			map.put("shohin_shijian_5",date5);
        			System.out.print("5"+date5);
        		}
        		
        		if(newStr.equals(date4)) {
         			 map.put("max_4", mac.getMax_shohin_wendu());
         			 map.put("min_4", mac.getMin_shohin_wendu());
         			 map.put("s_max_4", mac.getMax_shohin_shidu());
         			 map.put("s_max_4", mac.getMin_shohin_wendu());
         			 map.put("s_min_4", mac.getMax_shohin_wendu());
         			 map.put("p_max_4", mac.getMax_pm());
         			 map.put("p_min_4", mac.getMin_pm());
         			map.put("shohin_shijian_4",date4);
         			System.out.print("4"+date4+"\n");
         		}
        		
        		if(newStr.equals(date3)) {
       			 map.put("max_3", mac.getMax_shohin_wendu());
          			 map.put("min_3", mac.getMin_shohin_wendu());
          			 map.put("s_max_3", mac.getMax_shohin_shidu());
          			 map.put("s_max_3", mac.getMin_shohin_wendu());
          			 map.put("s_min_3", mac.getMax_shohin_wendu());
          			 map.put("p_max_3", mac.getMax_pm());
          			 map.put("p_min_3", mac.getMin_pm());
          			map.put("shohin_shijian_3",date3);
          			System.out.print("3"+date3+"\n");
      		}
        		
        		if(newStr.equals(date2)) {
        			map.put("max_2", mac.getMax_shohin_wendu());
          			 map.put("min_2", mac.getMin_shohin_wendu());
          			 map.put("s_max_2", mac.getMax_shohin_shidu());
          			 map.put("s_max_2", mac.getMin_shohin_wendu());
          			 map.put("s_min_2", mac.getMax_shohin_wendu());
          			 map.put("p_max_2", mac.getMax_pm());
          			 map.put("p_min_2", mac.getMin_pm());
          			 map.put("shohin_shijian_2",date2);
          			System.out.print("2"+date2+"\n");
        		}
        		
        		if(newStr.equals(date)) {
        			map.put("max_1", mac.getMax_shohin_wendu());
       			 map.put("min_1", mac.getMin_shohin_wendu());
       			 map.put("s_max_1", mac.getMax_shohin_shidu());
       			 map.put("s_max_1", mac.getMin_shohin_wendu());
       			 map.put("s_min_1", mac.getMax_shohin_wendu());
       			 map.put("p_max_1", mac.getMax_pm());
       			 map.put("p_min_1", mac.getMin_pm());
       			 map.put("shohin_shijian_1",date);
       			 System.out.print("1"+date+"\n");
        		}
        	 }
        		user.setMap(map);
        		user.setJieguo(true);	
         }
        	
        }finally {
        	 opensession.close();
        }
		return user;
	}
	@RequestMapping("/e2Bean")
	@ResponseBody
	@Test
	public employee2 testJson(@RequestBody employee2 user){
		String resource = "com/atguiigu/mybatis/test/aam.xml";
        InputStream inputStream;
        ArrayList<String> cjh=new ArrayList();
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
          
        SqlSession opensession=sqlSessionFactory.openSession();        
        try {
        	List<employee2> employee2=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.listCategoryatwo1");
        	System.out.println(employee2);
        	employee2 mac=null;
        	for(int i=0;i<employee2.size();i++){
        		mac= employee2.get(i);
        		cjh.add(mac.getCj());
        	}
        	user.setCjh(cjh);
        }finally {
        	 opensession.close();
        }  
		return user;
	}
}
