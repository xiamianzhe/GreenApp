package com.xin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class xintiao extends Thread {
	private Socket socket;
	  public xintiao(Socket socket) {
	      this.socket = socket;
	  }
	  public void run() {
	      super.run();
	      try {
	    	  InputStream in=socket.getInputStream();
	    	  byte[] data=new byte[1024];
	          int len=in.read(data);
	          String  chejian= new String(data,0,len);
	          while(true) {
	        	  OutputStream out=socket.getOutputStream();
	        	  out.write("q".getBytes());
	          }
	      } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	   
	      }  
	      }
}
