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

import com.socket.Code;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.code.HttpUtils;
import com.socket.Code;

import pojo.Smsbean;
import pojo.employee;


import pojo.employee;

//�ֻ��Ű���֤�������֤
@Controller
public class Acode {
	private int code;
	private String gh;
	private String sj;
		@RequestMapping("/aq")
		@ResponseBody
		public employee testJson(@RequestBody employee user)   {
			code = (int) ((Math.random() * 9 + 1) * 1000);
            String host = "http://dingxin.market.alicloudapi.com";
        	String path ="/dx/sendSms";String method = "POST"; 
        	String appcode ="50ee647a63654a27b45c5cf8a1ecd073"; 
			Map<String, String> headers = new HashMap<String, String>(); 
		  		  //�����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE  83359fd73fe94948385f570e3c139105 
		  		  headers.put("Authorization", "APPCODE " +appcode); 
		  		  Map<String, String> querys = new HashMap<String, String>();
		  		  querys.put("mobile", user.getShohin_shoujihao()); 
		  		  querys.put("param","code:"+code);
		  		  querys.put("tpl_id", "TP1904191"); 
		  		  Map<String, String> bodys = new HashMap<String, String>();
		  		  
		  		  try {
		  		 /*
		  			 * ��Ҫ��ʾ����: HttpUtils���
		  			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
		  			 * ����
		  			 *
		  			 * ��Ӧ�����������
		  			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
		  			 */
		  				  HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys,
		  				  bodys); System.out.println(response.toString()); //��ȡresponse��body
		  				  //System.out.println(EntityUtils.toString(response.getEntity())); 
		  				  } 
		  		  catch(Exception e) 
		  		  { e.printStackTrace(); }
	        //������֤
	        new Thread(){
	            @Override
	            public void run() {
	                super.run();

	        try {
			        	
	            ServerSocket serverSocket = new ServerSocket(code);
	            //��ѭ��
	            while(true){
	                System.out.println("MultiThreadServer~~~����������֤2~~~");
	                //accept������������ֱ���пͻ�����֮��������
	                Socket socket = serverSocket.accept();
//	                ServerThread serverThread = new ServerThread(socket);
	                Code code=new Code(socket);
	                code.start();
	            }    
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch(Exception e){
	            e.printStackTrace();
	        }
	        }
	        }.start();
	        System.out.print(code);
	        String s=String.valueOf(code);
	        user.setCj(s);
			return user;
		}
}
