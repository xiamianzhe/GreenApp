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
//�ֻ��Ű���֤�������֤

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
			  //�����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE  83359fd73fe94948385f570e3c139105 
			  headers.put("Authorization", "APPCODE " + appcode); 
			  Map<String, String> querys = new HashMap<String, String>();
			  querys.put("mobile", user.getShohin_shoujihao());
			  querys.put("param","code:"+code); 
			  querys.put("tpl_id", "TP1904191"); Map<String, String> bodys =
			  new HashMap<String, String>();
			  
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
					  } catch(Exception e) { e.printStackTrace(); }
			 
        //������֤
        new Thread(){
            @Override
            public void run() {
                super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(code);
            //��ѭ��
            while(true){
                System.out.println("MultiThreadServer~~~����������֤~~~");
                //accept������������ֱ���пͻ�����֮��������
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
//			if (a < employee.size()) { // �жϲ�ѯ����Ƿ�Ϊ��
//				for (int i = 0; i < employee.size(); i++) {
//					pojo.employee mac = employee.get(i);// xx��ʾlist����װ����ʲô����String,��
//					if (mac.getShohin_shoujihao().equals(null) || mac.getShohin_shoujihao().equals("")) {
//						gh = mac.getShohin_gonghao();
//					} else {
//						System.out.print("�����˻��Ѱ��ֻ���");
//						user.setShohin_shoujihao(mac.getShohin_shoujihao());
//					}
//
//				}
//			} else {
//				System.out.print("�����ڴ˹���");
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
//		System.out.println("��֤�롾1��" + code);
//		System.out.print("��ȡ�ֻ��Ų���2019-4-24----" + user.getShohin_shoujihao());
//		sj = user.getShohin_shoujihao();
//		 user.setCode(code); 
//////		 System.out.println((int)((Math.random()*9+1)*1000));
////		  String host = "http://dingxin.market.alicloudapi.com"; String path =
////		  "/dx/sendSms"; String method = "POST"; String appcode =
////		  "50ee647a63654a27b45c5cf8a1ecd073"; Map<String, String> headers = new
////		  HashMap<String, String>(); 
////		  //�����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE  83359fd73fe94948385f570e3c139105 
////		  headers.put("Authorization", "APPCODE " +
////		  appcode); Map<String, String> querys = new HashMap<String, String>();
////		  querys.put("mobile", user.getShohin_shoujihao()); querys.put("param",
////		  "code:"+code); querys.put("tpl_id", "TP1904191"); Map<String, String> bodys =
////		  new HashMap<String, String>();
////		  
////		  try {
////		 /*
////			 * ��Ҫ��ʾ����: HttpUtils���
////			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
////			 * ����
////			 *
////			 * ��Ӧ�����������
////			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
////			 */
////				  HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys,
////				  bodys); System.out.println(response.toString()); //��ȡresponse��body
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
//		System.out.print("�����޸�" + gh);
//		System.out.print("�ֻ����޸�" + sj);
//		System.out.print("��֤�����" + code + "<br/>");
//		System.out.print(user.getCode() + "<br/>");
//		if (user.getCode() != code) {
//			System.out.print("��֤ʧ��");
//			user.setYanzjg("��֤������ʧ��");
//		} else {
//			custome.setShohin_shoujihao(sj);
//			custome.setShohin_gonghao(gh);
//			int rows = opensession.update("com.atguiidu.mybatis.test.employeemapper.updateMobile", custome);
//			System.out.print("�󶨳ɹ�");
//			user.setYanzjg("YZCG");
//		}
//		opensession.commit();
//		opensession.close();
//		return user;
//	}

}
