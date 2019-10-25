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
//用户注册
public class RegisterController {
	/**
	 * 接收页面请求的JSON数据，并返回JSON格式结果
	 * @throws IOException 
	 */
	@RequestMapping("/register")
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
        employee custome=new employee();
      custome.setName(user.getName());
//      custome.setShohin_gonghao(user.getShohin_gonghao());
      custome.setShohin_shoujihao(user.getShohin_shoujihao());
      custome.setRuzhishijian(user.getRuzhishijian());
      custome.setZhiwu(user.getZhiwu());
      custome.setZhanghu(user.getZhanghu());
      custome.setMima(user.getMima());
        int rows=opensession.insert("com.atguiidu.mybatis.test"
        +".employeemapper.addCustomer",custome);
        if(rows>0) {
        	System.out.println("你成功插入了"+rows+"条数据");
        }else {
        	System.out.println("操作失败");
        }
        opensession.commit();
        opensession.close();
		// 打印接收的JSON格式数据
		System.out.println(user);           
		// 返回JSON格式的响应
		//这里访问数据库，成功则返回用户注册成功，否则返回失败
		return user;
	}
}
