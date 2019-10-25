package pojo;

import java.util.Map;

public class employee11 {
	// 车间信息//
	
	private String max_shohin_wendu;
	private String min_shohin_wendu;
	private String max_shohin_shidu;
	private String min_shohin_shidu;
	private String shohin_shijian;
	private String cj;
	public String getCj() {
		return cj;
	}
	public void setCj(String cj) {
		this.cj = cj;
	}
	public Map<String, String> map;
	
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public String getMax_pm() {
		return max_pm;
	}
	public void setMax_pm(String max_pm) {
		this.max_pm = max_pm;
	}
	public String getMin_pm() {
		return min_pm;
	}
	public void setMin_pm(String min_pm) {
		this.min_pm = min_pm;
	}
	private String max_pm;
	private String min_pm;
	private boolean jieguo;
	public boolean isJieguo() {
		return jieguo;
	}
	public void setJieguo(boolean jieguo) {
		this.jieguo = jieguo;
	}
	public String getMax_shohin_wendu() {
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
	}
	public String getShohin_shijian() {
		return shohin_shijian;
	}
	public void setShohin_shijian(String shohin_shijian) {
		this.shohin_shijian = shohin_shijian;
	}
	@Override
	public String toString() {
		return "employee11 [max_shohin_wendu=" + max_shohin_wendu + ", min_shohin_wendu=" + min_shohin_wendu
				+ ", max_shohin_shidu=" + max_shohin_shidu + ", min_shohin_shidu=" + min_shohin_shidu
				+ ", shohin_shijian=" + shohin_shijian + ", map=" + map + ", max_pm=" + max_pm + ", min_pm=" + min_pm
				+ ", jieguo=" + jieguo + "]";
	}
	
}

	
	
	
