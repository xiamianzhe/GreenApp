package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.djztBean;
import pojo.sbzzbean;
@Controller
public class DjzzController {
	//生产设备状态查询
		@RequestMapping("/djzt")
		@ResponseBody
		@Test
		public djztBean testJson(@RequestBody djztBean user) {
			
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
		try {
	    	List<djztBean> djztbean=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.djzt",user.getCj());
	    	System.out.print(djztbean);
	    	System.out.print("1--"+user.getCj()+"\n");
	    	int a=0;
	    	if(a<djztbean.size()) {
	    	for(int i=0;i<djztbean.size();i++){
	    		pojo.djztBean mac= djztbean.get(i);
	    		user.setShohin_guzhang(mac.getShohin_guzhang());
	    		user.setShohin_kaiguang(mac.getShohin_kaiguang());
	    		user.setShohin_nenhao(mac.getShohin_nenhao());
	    		user.setShohin_zhuanshu(mac.getShohin_zhuanshu());
	    	}
	    	user.setJieguo(true);
	    	
	    }
		}finally {
	   	 opensession.close();
	   }  
		return user;
		}
		
		
		
		@RequestMapping("/djztqb")
		@ResponseBody
		@Test
		public djztBean testJson2(@RequestBody djztBean user) {
	    ArrayList<String> gz= new ArrayList<String>();
	    ArrayList<String> id= new ArrayList<String>();
	    ArrayList<String> cj= new ArrayList<String>();
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
		try {
	    	List<djztBean> djztbean=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.djztqb");
	    	System.out.print(djztbean);
	    	System.out.print("1--"+user.getCj()+"\n");
	    	int a=0;
	    	if(a<djztbean.size()) {
	    	for(int i=0;i<djztbean.size();i++){
	    		pojo.djztBean mac= djztbean.get(i);
	    		gz.add(mac.getShohin_guzhang());
	    		id.add(mac.getId());
	    		cj.add(mac.getCj());
	    	}
	    	user.setJieguo(true);
	    	user.setGulist(gz);
	    	user.setIdlist(id);
	    	user.setCjlist(cj);
	    }
		}finally {
	   	 opensession.close();
	   }  
		return user;
		}
}
