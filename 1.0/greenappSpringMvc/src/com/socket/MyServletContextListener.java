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
        System.out.println("����ҵ���ֵ�");
      //pm2.5
        new Thread(){
            @Override
            public void run() {
                super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(12306);
            //��ѭ��
            while(true){
                System.out.println("MultiThreadServer~~~����1~~~");
                //accept������������ֱ���пͻ�����֮��������
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
      //�¶�
        new Thread(){
            @Override
            public void run() {
                super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(12307);
            //��ѭ��
            while(true){
                System.out.println("MultiThreadServer~~~����2~~~");
                //accept������������ֱ���пͻ�����֮��������
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
        
        
        //ʪ��
        new Thread(){
            @Override
            public void run() {
                super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(12308);
            //��ѭ��
            while(true){
                System.out.println("MultiThreadServer~~~����3~~~");
                //accept������������ֱ���пͻ�����֮��������
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