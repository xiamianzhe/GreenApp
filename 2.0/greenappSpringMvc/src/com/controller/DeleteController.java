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

import pojo.employee;
@Controller
//数据删除
public class DeleteController {
	@RequestMapping("/delete")
	@ResponseBody
	public employee testJson(@RequestBody employee user){
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
        
       
        
        int rows=opensession.delete("com.atguiidu.mybatis.test"
        +".employeemapper.deleteCustomer",user.getName());
        if(rows>0) {
        	System.out.println("你成功删除了"+rows+"条数据");
        }else {
        	System.out.println("操作失败");
        }
        opensession.commit();
        opensession.close();
		return user;
	}
}
