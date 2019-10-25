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
 
 
public class mybatistest07 {
	public List<employee1> ab ;
	//ÃÏ≤È—Ø
	@Test
	  public void test(Date qishi,Date jiesu,String chejian) throws IOException {
			String resource = "com/atguiigu/mybatis/test/aam.xml";
	        InputStream inputStream = Resources.getResourceAsStream(resource);
	        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	          
	        SqlSession opensession=sqlSessionFactory.openSession();  
	        
	        ArrayList<Date> data = new ArrayList<Date>();
	        
	        employee7 st=new employee7();
	        /*Date date = simpleDateFormat.parse("2019-10-31");*/
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date1=null ;
			//				date1 = simpleDateFormat.parse(qishi);
			date1=qishi;   
	        Date date2=null ;
			//				date2 = simpleDateFormat.parse(jiesu);
			date2=jiesu;
	        		st.setBeginTime(date1);
	        st.setEndTime(date2);
	        st.setCj(chejian);
	        
	        try {
	        	List<employee1> employee=opensession.selectList("com.atguiidu.mybatis.test.employeemapper.selectByTimeDate",st);	        		        	
	        		 System.out.println(employee);
	        		 ab= employee;
	        	
	        }finally {
	        	 opensession.close();
	        }            
}
 
}

