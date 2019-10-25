package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
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

import pojo.NpBean;
import pojo.djztBean;

@Controller
public class NpController {
	//生产设备能耗使用频次查询
	@RequestMapping("/np")
	@ResponseBody
	@Test
	public NpBean testJson(@RequestBody NpBean user) {
		
	String resource = "com/atguiigu/mybatis/test/aam.xml";
	InputStream inputStream;
	try {
		inputStream = Resources.getResourceAsStream(resource);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	/*使用Map储存返回的值*/
	Map<String, String> map = new HashMap<String, String>();
	String date,date2,date3,date4,date5,date6,date7;
	/*周期查询条件*/
	Calendar calendar = new GregorianCalendar();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//规定时间格式
	date=user.getShohin_shijian();
	Date date1;
	System.out.print("np时间"+user.getShohin_shijian());
	System.out.print("np车间"+user.getCj());
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
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	SqlSession opensession = sqlSessionFactory.openSession();
	try {
    	List<NpBean> pnbean=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.np",user.getCj());
    	System.out.print(pnbean);
    	System.out.print("1--"+user.getCj()+"\n");
    	int a=0;
    	if(a<pnbean.size()) { 
    	 for(int i=0;i<pnbean.size();i++){
    		 NpBean mac= pnbean.get(i);
    		 String newStr=mac.getShohin_shijian();
    		 if(newStr.equals(date7)) {
    			 map.put("nenghao7", mac.getNenghao());
    			 map.put("pinci7", mac.getPinci());
    			 map.put("shohin_shijian_7",date7);
    			 System.out.print("7"+date7);
    		}
    		
    		if(newStr.equals(date6)) {
    			map.put("nenghao6", mac.getNenghao());
   			 	map.put("pinci6", mac.getPinci());
    			map.put("shohin_shijian_6",date6);
    			System.out.print("6"+date6);
    		}
    		
    		if(newStr.equals(date5)) {
    			map.put("nenghao5", mac.getNenghao());
   			 	map.put("pinci5", mac.getPinci());
    			map.put("shohin_shijian_5",date5);
    			System.out.print("5"+date5);
    		}
    		
    		if(newStr.equals(date4)) {
    			map.put("nenghao4", mac.getNenghao());
   			 	map.put("pinci4", mac.getPinci());
     			map.put("shohin_shijian_4",date4);
     			System.out.print("4"+date4+"\n");
     		}
    		
    		if(newStr.equals(date3)) {
    			map.put("nenghao3", mac.getNenghao());
   			 	map.put("pinci3", mac.getPinci());
      			map.put("shohin_shijian_3",date3);
      			System.out.print("3"+date3+"\n");
  		}
    		
    		if(newStr.equals(date2)) {
    			map.put("nenghao2", mac.getNenghao());
   			 	map.put("pinci2", mac.getPinci());
      			map.put("shohin_shijian_2",date2);
      			System.out.print("2"+date2+"\n");
    		}
    		
    		if(newStr.equals(date)) {
    			map.put("nenghao1", mac.getNenghao());
	   			map.put("pinci1", mac.getPinci());
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
}
