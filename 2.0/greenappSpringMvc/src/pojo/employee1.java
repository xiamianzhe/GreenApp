package pojo;

import java.sql.Date;

public class employee1 {
	// 车间信息//
	
	
	
	private String shohin_shijian;
	private String shohin_cj;
	private String maxshohin_wendu;
	private String minshohin_wendu;
	private String maxshohin_shidu;
	private String minshohin_shidu;
	private String maxpm;
	
	public String getShohin_cj() {
		return shohin_cj;
	}
	public void setShohin_cj(String shohin_cj) {
		this.shohin_cj = shohin_cj;
	}
	public String getMaxshohin_wendu() {
		return maxshohin_wendu;
	}
	public void setMaxshohin_wendu(String maxshohin_wendu) {
		this.maxshohin_wendu = maxshohin_wendu;
	}
	public String getMinshohin_wendu() {
		return minshohin_wendu;
	}
	public void setMinshohin_wendu(String minshohin_wendu) {
		this.minshohin_wendu = minshohin_wendu;
	}
	public String getMaxshohin_shidu() {
		return maxshohin_shidu;
	}
	public void setMaxshohin_shidu(String maxshohin_shidu) {
		this.maxshohin_shidu = maxshohin_shidu;
	}
	public String getMinshohin_shidu() {
		return minshohin_shidu;
	}
	public void setMinshohin_shidu(String minshohin_shidu) {
		this.minshohin_shidu = minshohin_shidu;
	}
	public String getMaxpm() {
		return maxpm;
	}
	public void setMaxpm(String maxpm) {
		this.maxpm = maxpm;
	}
	public String getMinpm() {
		return minpm;
	}
	public void setMinpm(String minpm) {
		this.minpm = minpm;
	}
	private String minpm;
	
	/*private String max_shohin_wendu;
	private String min_shohin_wendu;
	private String max_shohin_shidu;
	private String min_shohin_shidu;


	public String getShohin_cj() {
		return shohin_cj;
	}
	public void setShohin_cj(String shohin_cj) {
		this.shohin_cj = shohin_cj;
	}
	/*public String getMax_shohin_wendu() {
		return max_shohin_wendu;
	}
	public void setMax_shohin_wendu(String max_shohin_wendu) {
		this.max_shohin_wendu = max_shohin_wendu;
	}
	public String getMin_shohin_wendu() {
		return min_shohin_wendu;
	}
	public void setMin_shohin_wendu(String min_shohin_wendu) {
		this.min_shohin_wendu = min_shohin_wendu;
	}
	public String getMax_shohin_shidu() {
		return max_shohin_shidu;
	}
	public void setMax_shohin_shidu(String max_shohin_shidu) {
		this.max_shohin_shidu = max_shohin_shidu;
	}
	public String getMin_shohin_shidu() {
		return min_shohin_shidu;
	}
	public void setMin_shohin_shidu(String min_shohin_shidu) {
		this.min_shohin_shidu = min_shohin_shidu;
	}*/
	
	@Override
	public String toString() {
		return "employee1 [shohin_shijian=" + shohin_shijian + ", shohin_cj=" + shohin_cj + ", maxshohin_wendu="
				+ maxshohin_wendu + ", minshohin_wendu=" + minshohin_wendu + ", maxshohin_shidu=" + maxshohin_shidu
				+ ", minshohin_shidu=" + minshohin_shidu + ", maxpm=" + maxpm + ", minpm=" + minpm + "]";
	}
	
	public String getShohin_shijian() {
		return shohin_shijian;
	}
	public void setShohin_shijian(String shohin_shijian) {
		this.shohin_shijian = shohin_shijian;
	}
	
	
}

	
	
	
