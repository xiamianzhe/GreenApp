package com.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.djztBean;
import pojo.sbzzbean;
//设备开关控制
@Controller
public class KgController {
	@RequestMapping("/djztmodify")
	@ResponseBody
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
         
        SqlSession opensession=sqlSessionFactory.openSession(); 
        djztBean custome=new djztBean();
        custome.setShohin_kaiguang(user.getShohin_kaiguang());
        custome.setCj(user.getCj());
        int rows=opensession.update("com.atguiidu.mybatis.test"
        +".employeemapper.updatedjzt",custome);
		
        System.out.println(user.getShohin_kaiguang()+"-------------"+user.getCj());
        if(rows>0) {
        	System.out.println("你成功修改了"+rows+"条数据");
        	user.setJieguo(true);
        }else {
        	System.out.println("操作失败");
        }
        opensession.commit();
        opensession.close();
		return user;
	}
	
	@RequestMapping("/hjztmodify")
	@ResponseBody
	public sbzzbean testJson(@RequestBody sbzzbean user) {
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
         
        SqlSession opensession=sqlSessionFactory.openSession(); 
        sbzzbean custome=new sbzzbean();
        custome.setShohin_kgzt(user.getShohin_kgzt());
        custome.setCj(user.getCj());
        int rows=opensession.update("com.atguiidu.mybatis.test"
        +".employeemapper.updatehjzt2",custome);
		
        System.out.println(user.getShohin_kgzt()+"-------------"+user.getCj());
        if(rows>0) {
        	System.out.println("你成功修改了"+rows+"条数据");
        	user.setJieguo(true);
        }else {
        	System.out.println("操作失败");
        }
        opensession.commit();
        opensession.close();
		return user;
	}
}
