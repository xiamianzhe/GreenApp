package com.atguiigu.mybatis.test;
 
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import pojo.employee1;
import pojo.employee7;
 
 
public class mybatistest8 {
	//ÔÂ²éÑ¯
	@Test
	  public void test(String qishi,String jiesu,String chejian) throws IOException {
			String resource = "com/atguiigu/mybatis/test/aam.xml";
	        InputStream inputStream = Resources.getResourceAsStream(resource);
	        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	          
	        SqlSession opensession=sqlSessionFactory.openSession();  
	        
	        ArrayList<Date> data = new ArrayList<Date>();
	        
	        employee7 st=new employee7();
	        /*Date date = simpleDateFormat.parse("2019-10-31");*/
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date1=null ;
			try {
				date1 = simpleDateFormat.parse(qishi);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
	        Date date2=null ;
			try {
				date2 = simpleDateFormat.parse(jiesu);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        		st.setBeginTime(date1);
	        st.setEndTime(date2);
	        st.setCj(chejian);
	        
	        try {
	        	List<employee1> employee=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.selectByTimeMonth",st);	        		        	
	        		 System.out.println(employee);
 	
	        	
	        }finally {
	        	 opensession.close();
	        }            
}
 
}

