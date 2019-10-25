package com.clly.modbus;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
* @author 承乐莱远-fupei
* @version 创建时间：2019年6月16日 下午3:36:43 
* 类说明 
*/
public class ModbusShelterTest {

	@Test
	public void testFetchData() {
		try {
			ShelterData sData= ModbusShelter.fetchData();
			System.out.println(sData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
