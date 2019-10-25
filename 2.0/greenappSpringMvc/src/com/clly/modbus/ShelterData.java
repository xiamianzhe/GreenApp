package com.clly.modbus;
/** 
* @author 承乐莱远-fupei
* @version 创建时间：2019年6月16日 下午3:21:33 
* 类说明 
*/
public class ShelterData {

	private double humidity;
	private double temprature;
	private double noise;
	private double pm25;
	private double pm10;
	private double illuminance;
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getTemprature() {
		return temprature;
	}
	public void setTemprature(double temprature) {
		this.temprature = temprature;
	}
	public double getNoise() {
		return noise;
	}
	public void setNoise(double noise) {
		this.noise = noise;
	}
	public double getPm25() {
		return pm25;
	}
	public void setPm25(double pm25) {
		this.pm25 = pm25;
	}
	public double getPm10() {
		return pm10;
	}
	public void setPm10(double pm10) {
		this.pm10 = pm10;
	}
	public double getIlluminance() {
		return illuminance;
	}
	public void setIlluminance(double illuminance) {
		this.illuminance = illuminance;
	}
	public String toString()
	{
		return "湿度："+humidity+" 温度："+temprature+" 噪音："+noise+" PM2.5"+pm25+" PM10"+pm10+" 照度"+illuminance;
	}
	 
	
	
}
