package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.socket.ServerThread;
import com.socket.wenServer;

import net.sf.json.JSON;
import pojo.employee;

@Controller
//用户登录
public class SigninController {
	@RequestMapping("/Signin")
	@ResponseBody
	public employee testJson(@RequestBody employee user) {
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
        	List<employee> employee=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.listCategorya",user.getShohin_gonghao());
        	System.out.print(employee);
        	int a=0;
        	if(a<employee.size()) { //判断查询结果是否为空
            		for(int i=0;i<employee.size();i++){
            		pojo.employee mac= employee.get(i);//xx表示list里面装的是什么比如String,等
            		if(mac.getMima().equals(user.getMima())) {
            			user.setJieguo(true);
            			user.setName(mac.getName());
            			user.setRuzhishijian(mac.getRuzhishijian());
            			user.setShohin_shoujihao(mac.getShohin_shoujihao());
            			user.setZhanghu(mac.getZhanghu());
            			user.setZhiwu(mac.getZhiwu());
            			user.setCj(mac.getCj());
            			user.setMac(mac.getMac());
            			System.out.print("车间"+mac.getCj()+"\n");
            			System.out.print("登录成功"+"\n");   
            		}else {
            			System.out.print("密码错误");
            			user.setJieguo(false);
            		}
            		
        	}
        		}
        		else {
        			user.setShohin_gonghao("false");
        			System.out.print("不存在此工号");
        	} 
        }finally {
        	 opensession.close();
        }  
		return user;
	}
	
	
	
	
	@RequestMapping("/Signinweb")
	@ResponseBody
	public employee testJsonweb(HttpSession session,@RequestBody employee user) {
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
        	List<employee> employee=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.listCategorya",user.getShohin_gonghao());
        	System.out.print(employee);
        	int a=0;
        	if(a<employee.size()) { //判断查询结果是否为空
            		for(int i=0;i<employee.size();i++){
            		pojo.employee mac= employee.get(i);//xx表示list里面装的是什么比如String,等
            			if(mac.getZhiwu().equals("管理员")) {
            			if(mac.getMima().equals(user.getMima())) {
							/*
							 * user.setJieguo(true); user.setName(mac.getName());
							 * user.setRuzhishijian(mac.getRuzhishijian());
							 * user.setShohin_shoujihao(mac.getShohin_shoujihao());
							 * user.setZhanghu(mac.getZhanghu()); user.setZhiwu(mac.getZhiwu());
							 * user.setCj(mac.getCj()); user.setMac(mac.getMac());
							 */
            			session.setAttribute("username", mac.getName());
            			session.setAttribute("Zhiwu", mac.getZhiwu());
            			session.setAttribute("cj", mac.getCj());
            			System.out.print("车间"+mac.getCj()+"\n");
            			System.out.print("登录成功"+"\n");   
            
            			
            			}else {
            				System.out.print("密码错误");
                			user.setJieguo(false);
            			}
            		}else {
            			user.setShohin_gonghao("false");
            			
            		}
            		
        	}
        }
        }finally {
        	 opensession.close();
        }            
		return user;
	}
}

