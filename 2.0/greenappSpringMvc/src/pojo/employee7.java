package pojo;

import java.util.ArrayList;
import java.util.Date;

public class employee7 {
	/*Date beginTime;
	Date endTime;
	String cj;*/
	private String lei;
	public String getLei() {
		return lei;
	}
	public void setLei(String lei) {
		this.lei = lei;
	}
	public ArrayList getAs() {
		return As;
	}
	public void setAs(ArrayList as) {
		As = as;
	}
	private ArrayList As;
	
	private String cj;
	public String getCj() {
		return cj;
	}



	public void setCj(String cj) {
		this.cj = cj;
	}



	public Date getBeginTime() {
		return beginTime;
	}



	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}



	public Date getEndTime() {
		return endTime;
	}



	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}



	private Date beginTime;
	private Date endTime;
	 
	
	
	@Override
	public String toString() {
		return "employee7 [cj=" + cj + ", beginTime=" + beginTime + ", endTime=" + endTime + "]";
	}
	
	
    
}
