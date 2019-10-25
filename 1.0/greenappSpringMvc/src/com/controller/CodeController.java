package com.controller;

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

@Controller
//手机号绑定验证与短信验证

public class CodeController {
	private int code;
	private String gh;
	private String sj;

	@RequestMapping("/Jnq")
	@ResponseBody
	public employee testJson(@RequestBody employee user)   {
		code = (int) ((Math.random() * 9 + 1) * 1000);
		  String host = "http://dingxin.market.alicloudapi.com"; 
		  String path = "/dx/sendSms"; String method = "POST";
		  String appcode ="50ee647a63654a27b45c5cf8a1ecd073"; 
		  Map<String, String> headers = new HashMap<String, String>(); 
			  //最后在header中的格式(中间是英文空格)为Authorization:APPCODE  83359fd73fe94948385f570e3c139105 
			  headers.put("Authorization", "APPCODE " + appcode); 
			  Map<String, String> querys = new HashMap<String, String>();
			  querys.put("mobile", user.getShohin_shoujihao());
			  querys.put("param","code:"+code); 
			  querys.put("tpl_id", "TP1904191"); Map<String, String> bodys =
			  new HashMap<String, String>();
			  
			  try {
			 /*
				 * 重要提示如下: HttpUtils请从
				 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
				 * 下载
				 *
				 * 相应的依赖请参照
				 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
				 */
					  HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys,
					  bodys); System.out.println(response.toString()); //获取response的body
					  //System.out.println(EntityUtils.toString(response.getEntity())); 
					  } catch(Exception e) { e.printStackTrace(); }
			 
        //短信验证
        new Thread(){
            @Override
            public void run() {
                super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(code);
            //死循环
            while(true){
                System.out.println("MultiThreadServer~~~监听短信验证~~~");
                //accept方法会阻塞，直到有客户端与之建立连接
                Socket socket = serverSocket.accept();
//                ServerThread serverThread = new ServerThread(socket);
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
//		String resource = "com/atguiigu/mybatis/test/aam.xml";
//		Boolean jieguo;
//		InputStream inputStream;
//		try {
//			inputStream = Resources.getResourceAsStream(resource);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		SqlSession opensession = sqlSessionFactory.openSession();
//		System.out.println("opensession" + opensession);
//		try {
//			List<employee> employee = opensession.selectList("com.atguiidu.mybatis.test.employeemapper.listCategorya",
//					user.getShohin_gonghao());
//			System.out.print(employee);
//			System.out.print(user.getShohin_gonghao());
//			int a = 0;
//			if (a < employee.size()) { // 判断查询结果是否为空
//				for (int i = 0; i < employee.size(); i++) {
//					pojo.employee mac = employee.get(i);// xx表示list里面装的是什么比如String,等
//					if (mac.getShohin_shoujihao().equals(null) || mac.getShohin_shoujihao().equals("")) {
//						gh = mac.getShohin_gonghao();
//					} else {
//						System.out.print("您的账户已绑定手机号");
//						user.setShohin_shoujihao(mac.getShohin_shoujihao());
//					}
//
//				}
//			} else {
//				System.out.print("不存在此工号");
//			}
//		} finally {
//			opensession.close();
//		}

		return user;
	}

//	@RequestMapping("/code")
//	@ResponseBody
//	public Smsbean testJson(@RequestBody Smsbean user)  {
//		code = (int) ((Math.random() * 9 + 1) * 1000);
//		System.out.println("验证码【1】" + code);
//		System.out.print("获取手机号测试2019-4-24----" + user.getShohin_shoujihao());
//		sj = user.getShohin_shoujihao();
//		 user.setCode(code); 
//////		 System.out.println((int)((Math.random()*9+1)*1000));
////		  String host = "http://dingxin.market.alicloudapi.com"; String path =
////		  "/dx/sendSms"; String method = "POST"; String appcode =
////		  "50ee647a63654a27b45c5cf8a1ecd073"; Map<String, String> headers = new
////		  HashMap<String, String>(); 
////		  //最后在header中的格式(中间是英文空格)为Authorization:APPCODE  83359fd73fe94948385f570e3c139105 
////		  headers.put("Authorization", "APPCODE " +
////		  appcode); Map<String, String> querys = new HashMap<String, String>();
////		  querys.put("mobile", user.getShohin_shoujihao()); querys.put("param",
////		  "code:"+code); querys.put("tpl_id", "TP1904191"); Map<String, String> bodys =
////		  new HashMap<String, String>();
////		  
////		  try {
////		 /*
////			 * 重要提示如下: HttpUtils请从
////			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
////			 * 下载
////			 *
////			 * 相应的依赖请参照
////			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
////			 */
////				  HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys,
////				  bodys); System.out.println(response.toString()); //获取response的body
////				  //System.out.println(EntityUtils.toString(response.getEntity())); 
////				  } catch(Exception e) { e.printStackTrace(); }
//				 
//		return user;
//	}
//
//	@RequestMapping("/mius")
//	@ResponseBody
//	public Smsbean Sms(@RequestBody Smsbean user)   {
//		String resource = "com/atguiigu/mybatis/test/aam.xml";
//		InputStream inputStream;
//		try {
//			inputStream = Resources.getResourceAsStream(resource);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		SqlSession opensession = sqlSessionFactory.openSession();
//		employee custome = new employee();
//		System.out.print("工号修改" + gh);
//		System.out.print("手机号修改" + sj);
//		System.out.print("验证码测试" + code + "<br/>");
//		System.out.print(user.getCode() + "<br/>");
//		if (user.getCode() != code) {
//			System.out.print("验证失败");
//			user.setYanzjg("验证码错误绑定失败");
//		} else {
//			custome.setShohin_shoujihao(sj);
//			custome.setShohin_gonghao(gh);
//			int rows = opensession.update("com.atguiidu.mybatis.test.employeemapper.updateMobile", custome);
//			System.out.print("绑定成功");
//			user.setYanzjg("YZCG");
//		}
//		opensession.commit();
//		opensession.close();
//		return user;
//	}

}
