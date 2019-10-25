package com.clly.modbus;

/** 
* @author 閹靛じ绠伴懢杈箼-fupei
* @version 閸掓稑缂撻弮鍫曟？閿涳拷2019楠烇拷6閺堬拷16閺冿拷 娑撳宕�2:30:42 
* 缁槒顕╅弰锟� 
*/
import com.serotonin.io.serial.*;
import com.serotonin.modbus4j.*;
import com.serotonin.modbus4j.exception.*;
import com.serotonin.modbus4j.msg.*;
import java.util.*;

public class ModbusShelter {
	// MODBUS缂冩垹绮舵稉濠佺矤缁旀瑥婀撮崸锟�
	private final static int SLAVE_ADDRESS = 1;
	// 娑撹尪顢戦崣锝嗗皾閻楀湱宸�
	private final static int BAUD_RATE = 4800;
	private static byte[] lock = new byte[0];  
	 
	public static ShelterData fetchData() throws Exception {
		synchronized(lock) {
		SerialParameters serialParameters = new SerialParameters();
		// 鐠佹儳鐣綧ODBUS闁俺顔嗛惃鍕鐞涘苯褰�
		serialParameters.setCommPortId("COM4");
		// 鐠佹儳鐣鹃幋鎰￥婵傚洤浼撻弽锟犵崣
		serialParameters.setParity(0);
		// 鐠佹儳鐣鹃幋鎰殶閹诡喕缍呴弰锟�8娴ｏ拷
		serialParameters.setDataBits(8);
		// 鐠佹儳鐣炬稉锟�1娑擃亜浠犲顫秴
		serialParameters.setStopBits(1);
		serialParameters.setPortOwnerName("Numb nuts");
		// 娑撹尪顢戦崣锝勭瑐閻ㄥ嫭灏濋悧鍦芳
		serialParameters.setBaudRate(BAUD_RATE);
		ModbusFactory modbusFactory = new ModbusFactory();
		ModbusMaster master = modbusFactory.createRtuMaster(serialParameters);
		try {
			master.init();
		//	readDiscreteInputTest(master, SLAVE_ADDRESS, 0, 8);
		//	writeRegistersTest(master, SLAVE_ADDRESS, 0, new short[] { 0x31, 0xb, 0xc, 0xd, 0xe, 0x9, 0x8, 0x7, 0x6 });
			return readHoldingRegistersTest(master, SLAVE_ADDRESS, 500, 8);
		} finally {
			master.destroy();
		}
		}
	}

	/**
	 * 鐠囪绱戦崗鎶藉櫤閸ㄥ娈戞潏鎾冲弳娣団�冲娇
	 * 
	 * @param master
	 *            娑撹崵鐝�
	 * @param slaveId
	 *            娴犲海鐝崷鏉挎絻
	 * @param start
	 *            鐠у嘲顫愰崑蹇曅╅柌锟�
	 * @param len
	 *            瀵板懓顕伴惃鍕磻閸忔娊鍣洪惃鍕嚋閺侊拷
	 */
	private static void readDiscreteInputTest(ModbusMaster master, int slaveId, int start, int len) {
		try {
			ReadDiscreteInputsRequest request = new ReadDiscreteInputsRequest(slaveId, start, len);
			ReadDiscreteInputsResponse response = (ReadDiscreteInputsResponse) master.send(request);
			if (response.isException())
				System.out.println("Exception response: message=" + response.getExceptionMessage());
			else
				System.out.println(Arrays.toString(response.getBooleanData()));
		} catch (ModbusTransportException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 鐠囪绻氶幐浣哥槑鐎涙ê娅掓稉濠勬畱閸愬懎顔�
	 * 
	 * @param master
	 *            娑撹崵鐝�
	 * @param slaveId
	 *            娴犲海鐝崷鏉挎絻
	 * @param start
	 *            鐠у嘲顫愰崷鏉挎絻閻ㄥ嫬浜哥粔濠氬櫤
	 * @param len
	 *            瀵板懓顕扮�靛嫬鐡ㄩ崳銊ф畱娑擃亝鏆�
	 * @return 
	 */
	private static ShelterData readHoldingRegistersTest(ModbusMaster master, int slaveId, int start, int len) {
		ShelterData sData=new ShelterData();
		try {
			ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(slaveId, start, len);
			ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master.send(request);
			if (response.isException())
				System.out.println("Exception response: message=" + response.getExceptionMessage());
			else
			{
				short [] arr=response.getShortData();
				sData.setHumidity(arr[0]/10.0);
				sData.setTemprature(arr[1]/10.0);
				sData.setNoise(arr[2]/10.0);
				sData.setPm25(arr[3]);
				sData.setPm10(arr[4]);
				sData.setIlluminance(arr[6]*256+arr[7]);
				System.out.println(Arrays.toString(response.getShortData()));
			}
		} catch (ModbusTransportException e) {
			e.printStackTrace();
		}
		return sData;
	}

	/**
	 * 閹靛綊鍣洪崘娆愭殶閹诡喖鍩屾穱婵囧瘮鐎靛嫬鐡ㄩ崳锟�
	 * 
	 * @param master
	 *            娑撹崵鐝�
	 * @param slaveId
	 *            娴犲海鐝崷鏉挎絻
	 * @param start
	 *            鐠у嘲顫愰崷鏉挎絻閻ㄥ嫬浜哥粔濠氬櫤
	 * @param values
	 *            瀵板懎鍟撻弫鐗堝祦
	 */
	public static void writeRegistersTest(ModbusMaster master, int slaveId, int start, short[] values) {
		try {
			WriteRegistersRequest request = new WriteRegistersRequest(slaveId, start, values);
			WriteRegistersResponse response = (WriteRegistersResponse) master.send(request);
			if (response.isException())
				System.out.println("Exception response: message=" + response.getExceptionMessage());
			else
				System.out.println("Success");
		} catch (ModbusTransportException e) {
			e.printStackTrace();
		}
	}
}