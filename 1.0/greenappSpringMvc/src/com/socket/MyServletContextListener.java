package com.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("加载业务字典");
      //pm2.5
        new Thread(){
            @Override
            public void run() {
                super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(12306);
            //死循环
            while(true){
                System.out.println("MultiThreadServer~~~监听1~~~");
                //accept方法会阻塞，直到有客户端与之建立连接
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }    
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
        }
        }.start();
      //温度
        new Thread(){
            @Override
            public void run() {
                super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(12307);
            //死循环
            while(true){
                System.out.println("MultiThreadServer~~~监听2~~~");
                //accept方法会阻塞，直到有客户端与之建立连接
                Socket socket = serverSocket.accept();
//                ServerThread serverThread = new ServerThread(socket);
                wenServer wens=new wenServer(socket);
                wens.start();
            }    
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
        }
        }.start();
        
        
        //湿度
        new Thread(){
            @Override
            public void run() {
                super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(12308);
            //死循环
            while(true){
                System.out.println("MultiThreadServer~~~监听3~~~");
                //accept方法会阻塞，直到有客户端与之建立连接
                Socket socket = serverSocket.accept();
//                ServerThread serverThread = new ServerThread(socket);
                shiServer shis=new shiServer(socket);
                shis.start();
            }    
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
        }
        }.start();
        
    }
    
}