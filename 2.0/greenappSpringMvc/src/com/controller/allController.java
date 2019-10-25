package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.employee;
@Controller
/*全部员工信息查询*/
public class allController {
	@RequestMapping("/all")
	@ResponseBody
	public employee testJson2(@RequestBody employee user) {
		ArrayList<String> username= new ArrayList<String>();
		ArrayList<String> gh= new ArrayList<String>();
		ArrayList<String> cj= new ArrayList<String>();
		ArrayList<String> mima= new ArrayList<String>();
		ArrayList<String> sjh= new ArrayList<String>();
		ArrayList<String> rzsj= new ArrayList<String>();
		ArrayList<String> zh= new ArrayList<String>();
		ArrayList<String> mc= new ArrayList<String>();
		ArrayList<String> zw= new ArrayList<String>();
		String resource = "com/atguiigu/mybatis/test/aam.xml";
		Boolean jieguo;
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
        System.out.println("opensession"+opensession);
        try {
        	List<employee> employee=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.all");
        	System.out.print(employee);
        	int a=0;
        	if(a<employee.size()) { //判断查询结果是否为空
            		for(int i=0;i<employee.size();i++){
            		pojo.employee mac= employee.get(i);//xx表示list里面装的是什么比如String,等
            		username.add(mac.getName());
            		gh.add(mac.getShohin_gonghao());
            		cj.add(mac.getShohin_gonghao());
            		mima.add(mac.getMima());
            		sjh.add(mac.getShohin_shoujihao());
            		rzsj.add(mac.getRuzhishijian());
            		zh.add(mac.getZhanghu());
            		mc.add(mac.getMac());
            		zw.add(mac.getZhiwu());
            		}
            		user.setNamelist(username);
            		user.setShohin_gonghaolist(gh);
            		user.setCjlist(cj);
            		user.setMimalist(mima);
            		user.setShohin_shoujihaolist(sjh);
            		user.setRuzhishijianlist(rzsj);
            		user.setZhanghulist(zh);
            		user.setMaclist(mc);
            		user.setZhiwulist(zw);
        	}
        		
        }finally {
        	 opensession.close();
        }            
		return user;
	}
}
