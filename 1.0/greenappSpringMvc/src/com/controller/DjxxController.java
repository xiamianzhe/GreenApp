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

import pojo.sbxxbean;
@Controller
public class DjxxController {
	//生产设备信息查询
	@RequestMapping("/djxx")
	@ResponseBody
	public sbxxbean testJson(@RequestBody sbxxbean user) {
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
    	List<sbxxbean> sbxxbean=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.djxx",user.getCj());
    	System.out.print("1--"+user.getCj());
    	int a=0;
    	if(a<sbxxbean.size()) {
    	for(int i=0;i<sbxxbean.size();i++){
    		pojo.sbxxbean mac= sbxxbean.get(i);
    		user.setJiqibianhao(mac.getJiqibianhao());
    		user.setJiqixinghao(mac.getJiqixinghao());
    		user.setFuzheren(mac.getFuzheren());
    		user.setChaigoushijian(mac.getChaigoushijian());
    		user.setChuchangshijian(mac.getChuchangshijian());
    
    	}
    	user.setJieguo(true);
    	System.out.print(sbxxbean);
    }else {
    	user.setJieguo(false);
    }
	}finally {
   	 opensession.close();
   }  
	return user;
	}
}
