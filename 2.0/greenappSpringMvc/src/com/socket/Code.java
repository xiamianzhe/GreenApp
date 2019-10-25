package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.DataBean;
import pojo.employee;

public class Code extends Thread {
	private Socket socket;
	private int code;
	private String gh;
	private String sj;
	  //�ڹ����еõ�Ҫ�����Ự��socket	  
	  public Code(Socket socket) {
		// TODO Auto-generated constructor stub
		  this.socket = socket;
	}

	public void run() {
	      super.run();
//	      OutputStream os = null;
	      try {
	    	  InputStream in=socket.getInputStream();
	    	  byte[] data=new byte[1024];
	          int len=in.read(data);
	          String  chejian= new String(data,0,len);
	          System.out.println("��������"+chejian);
	          OutputStream out=socket.getOutputStream();
	    		  try{
	    		        socket.sendUrgentData(0xFF);
	    		    }catch(Exception e){
	    		    	System.out.print("�ͻ����Ѿ��Ͽ�����");
	    		    }
	    		  String resource = "com/atguiigu/mybatis/test/aam.xml";
	    			InputStream inputStream = null;
	    			try {
	    				inputStream = Resources.getResourceAsStream(resource);
	    			} catch (IOException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    			SqlSession opensession = sqlSessionFactory.openSession();
	    			employee custome = new employee();
	    			gh=chejian.substring(0,3);
	    			sj=chejian.substring(3,14);
	    			System.out.print("�����޸�" + gh);
	    			System.out.print("�ֻ����޸�" + sj);
//	    			System.out.print("��֤�����" + code + "<br/>");
	    	
	    				custome.setShohin_shoujihao(sj);
	    				custome.setShohin_gonghao(gh);
	    				int rows = opensession.update("com.atguiidu.mybatis.test.employeemapper.updateMobile", custome);
	    				if(rows>0) {
	    		        	System.out.println("��ɹ��޸���"+rows+"������");
	    		        	out.write("true".getBytes());
	    		        }else {
	    		        	System.out.println("����ʧ��");
	    		        	out.write("false".getBytes());
	    		        }
	    		        opensession.commit();
	    		        opensession.close();
	    				
	    		  
	        	    	
	      } catch (IOException e2) {
	          e2.printStackTrace();
	      } finally{
	   
	      }        
	  }
	}
