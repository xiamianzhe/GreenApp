package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.djztBean;
import pojo.employee;

@Controller
public class MacData {
	@RequestMapping("/Macdata")
	@ResponseBody
	public employee testJson(@RequestBody employee user) {
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
        employee custome=new employee();
        custome.setMac(user.getMac());
        custome.setShohin_gonghao(user.getShohin_gonghao());
        int rows=opensession.update("com.atguiidu.mybatis.test"
        +".employeemapper.updatedmac",custome);
		
        //System.out.println(user.getShohin_kaiguang()+"-------------"+user.getCj());
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
