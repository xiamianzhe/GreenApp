package pojo;

import java.util.Map;

public class NpBean {
	private String nenghao;
	private String pinci;
	private String shohin_shijian;
	private String cj;
	public String getNenghao() {
		return nenghao;
	}
	public void setNenghao(String nenghao) {
		this.nenghao = nenghao;
	}
	public String getPinci() {
		return pinci;
	}
	public void setPinci(String pinci) {
		this.pinci = pinci;
	}
	public String getShohin_shijian() {
		return shohin_shijian;
	}
	public void setShohin_shijian(String shohin_shijian) {
		this.shohin_shijian = shohin_shijian;
	}
	public String getCj() {
		return cj;
	}
	public void setCj(String cj) {
		this.cj = cj;
	}
	private boolean jieguo;
	public boolean isJieguo() {
		return jieguo;
	}
	public void setJieguo(boolean jieguo) {
		this.jieguo = jieguo;
	}
	public Map<String, String> map;
	
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "NpBean [nenghao=" + nenghao + ", pinci=" + pinci + ", shohin_shijian=" + shohin_shijian + ", cj=" + cj
				+ "]";
	}
}
