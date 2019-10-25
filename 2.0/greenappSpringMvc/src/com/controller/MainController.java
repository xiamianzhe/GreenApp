
package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.DataBean;
//实时记录查询
@Controller
public class MainController<Socket> {
	@RequestMapping("/mian")
	@ResponseBody
	@Test
	public DataBean testJson(@RequestBody DataBean user){
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
		try { List<DataBean> databean=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.selectLast",user.getCj());
		int a=0;
		System.out.print("11111"+user.getCj());
    	if(a<databean.size()) { //判断查询结果是否为空
    		for(int i=0;i<databean.size();i++){
    			pojo.DataBean mac= databean.get(i);
    			user.setPm(mac.getPm());
    			user.setShohin_shidu(mac.getShohin_shidu());
    			user.setShohin_wendu(mac.getShohin_wendu());
    			user.setShohin_shijian(mac.getShohin_shijian());
        		 System.out.print("SJ"+mac.getShohin_shijian()+"\n");
        		 System.out.print("PM:"+mac.getPm()+"\n");
        		 System.out.print("SD"+mac.getShohin_shidu()+"\n");
        		 System.out.print("WD"+mac.getShohin_wendu()+"\n");
        		}
    		
    			user.setJieguo(true);
        	}else {
        		System.out.print("哈哈哈哈");
        	}
		
		}	 
		finally {
  			 opensession.close(); 
  		}

		return user;
	}
}
