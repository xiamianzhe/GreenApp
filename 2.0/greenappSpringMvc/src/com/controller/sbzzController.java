package com.controller;

import java.io.IOException;
import java.io.InputStream;
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

import pojo.sbxxbean;
import pojo.sbzzbean;

@Controller
public class sbzzController {
//环境设备状态查询
	@RequestMapping("/sbzz")
	@ResponseBody
	@Test
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

	SqlSession opensession = sqlSessionFactory.openSession();
	try {
    	List<sbzzbean> sbzzbean=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.sdzt",user.getCj());
    	System.out.print(sbzzbean);
    	System.out.print("1--"+user.getCj()+"\n");
    	int a=0;
    	if(a<sbzzbean.size()) {
    	for(int i=0;i<sbzzbean.size();i++){
    		pojo.sbzzbean mac= sbzzbean.get(i);
					/*
					 * private String id; private String cj; private String jiqibianhao; private
					 * String jiqixinghao; private String fuzheren; private String chaigoushijian;
					 * private String chuchangshijian;
					 */
    		user.setShohin_kgzt(mac.getShohin_kgzt());
    		user.setShohin_ms(mac.getShohin_ms());
    		user.setShohin_sd(mac.getShohin_sd());
    		user.setShohin_wd(mac.getShohin_wd());
    		
    	}
    	user.setJieguo(true);
    	
    }
	}finally {
   	 opensession.close();
   }  
	return user;
	}
}
