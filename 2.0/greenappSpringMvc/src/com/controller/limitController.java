package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.socket.ServerThread;

import pojo.employee;
import pojo.employee12;

@Controller
public class limitController {
	//上下限查询
	@RequestMapping("/limit")
	@ResponseBody
	public employee12 testJson(@RequestBody employee12 user){
		String resource = "com/atguiigu/mybatis/test/aam.xml";
        InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			System.out.print("1----"+inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("2---");
			return null;
		}
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession opensession=sqlSessionFactory.openSession(); 
        try {
        	List<employee12> employee12=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.selectByTime3");
        	System.out.print("1----"+employee12);
		int a=0;
    	if(a<employee12.size()) { //判断查询结果是否为空
        		for(int i=0;i<employee12.size();i++){
        		pojo.employee12 mac= employee12.get(i);
        		user.setSx_pm(mac.getSx_pm());
        		user.setSx_shohin_shidu(mac.getSx_shohin_shidu());
        		user.setSx_shohin_wendu(mac.getSx_shohin_wendu());
        		
//        		user.setXx_pm(mac.getXx_pm());
        		user.setXx_shohin_shidu(mac.getXx_shohin_shidu());
        		user.setXx_shohin_wendu(mac.getXx_shohin_wendu());
        		}
        		user.setJieguo(true);
        	}
        }finally {
       	 opensession.close();
       } 
		return user;
	}
}
