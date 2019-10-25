package com.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.DataBean;

public class ServerThread extends Thread {
	private Socket socket;
  private String pm;
  //�ڹ����еõ�Ҫ�����Ự��socket
  public ServerThread(Socket socket) {
      this.socket = socket;
  }
  
  public void run() {
      super.run();
//      OutputStream os = null;
      try {
    	  InputStream in=socket.getInputStream();
    	  byte[] data=new byte[1024];
          int len=in.read(data);
          String  chejian= new String(data,0,len);
          System.out.println("��������"+chejian);
          int c=0;
    	  while(true) {	
    		  //��ѭ���ݿ�
    		  if(c>0) {
    			  try {
    				  //���ݿ��ѯʱ��ȴ�
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		  }else {
    			  c=1;
    		  }
    		  try{
    		        socket.sendUrgentData(0xFF);
    		    }catch(Exception e){
    		    	System.out.print("PM2.5�ͻ����Ѿ��Ͽ�����");
    		        break;
    		    }
          String resource = "com/atguiigu/mybatis/test/aam.xml";
      	InputStream inputStream;
  		try {
  			inputStream = Resources.getResourceAsStream(resource);
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			return;
  		}
  		//�����ݿ��ѯ
          SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
  		SqlSession opensession = sqlSessionFactory.openSession();
          try { 
        	  
        		  OutputStream out=socket.getOutputStream();
        		  List<DataBean> databean=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.selectLast",chejian);
        			System.out.println("��������ѯ��ֵ"+databean);
        			int a=0;
        	    	if(a<databean.size()) { //�жϲ�ѯ����Ƿ�Ϊ��
        	    		for(int i=0;i<databean.size();i++){
        	    			pojo.DataBean mac= databean.get(i);
        	    			pm=mac.getPm();
                	        out.write(pm.getBytes());
        	    	
        	        		}
        	    		
        	        	}else {
        	        		out.write("exit".getBytes());
        	        		try {
								Thread.sleep(10000);
								socket.close();
								break;
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        	        		
        	        		
        	        		System.out.print("��������");
        	        		
        	        	} 
        	    	
        	  
  		}finally {
   			 opensession.close(); 
    }
          }   
      } catch (IOException e2) {
          e2.printStackTrace();
      } finally{
   
      }        
  }
}