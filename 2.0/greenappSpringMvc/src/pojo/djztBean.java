package pojo;

import java.util.ArrayList;

//电机设备状态
public class djztBean {
	private String cj;//车间
	private String shohin_kaiguang;//开关
	private String shohin_guzhang;//故障
	private String shohin_nenhao;//能耗
	private String shohin_zhuanshu;//转速
	private boolean jieguo;//返回结果是否为空
	private String id;
	private ArrayList gulist;
	private ArrayList idlist;
	private ArrayList cjlist;
	public ArrayList getIdlist() {
		return idlist;
	}
	public void setIdlist(ArrayList idlist) {
		this.idlist = idlist;
	}
	public ArrayList getCjlist() {
		return cjlist;
	}
	public void setCjlist(ArrayList cjlist) {
		this.cjlist = cjlist;
	}
	public ArrayList getGulist() {
		return gulist;
	}
	public void setGulist(ArrayList gulist) {
		this.gulist = gulist;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCj() {
		return cj;
	}
	public void setCj(String cj) {
		this.cj = cj;
	}
	public String getShohin_kaiguang() {
		return shohin_kaiguang;
	}
	public void setShohin_kaiguang(String shohin_kaiguang) {
		this.shohin_kaiguang = shohin_kaiguang;
	}
	public String getShohin_guzhang() {
		return shohin_guzhang;
	}
	public void setShohin_guzhang(String shohin_guzhang) {
		this.shohin_guzhang = shohin_guzhang;
	}
	public String getShohin_nenhao() {
		return shohin_nenhao;
	}
	public void setShohin_nenhao(String shohin_nenhao) {
		this.shohin_nenhao = shohin_nenhao;
	}
	public String getShohin_zhuanshu() {
		return shohin_zhuanshu;
	}
	public void setShohin_zhuanshu(String shohin_zhuanshu) {
		this.shohin_zhuanshu = shohin_zhuanshu;
	}
	public boolean isJieguo() {
		return jieguo;
	}
	public void setJieguo(boolean jieguo) {
		this.jieguo = jieguo;
	}
	@Override
	public String toString() {
		return "djztBean [cj=" + cj + ", shohin_kaiguang=" + shohin_kaiguang + ", shohin_guzhang=" + shohin_guzhang
				+ ", shohin_nenhao=" + shohin_nenhao + ", shohin_zhuanshu=" + shohin_zhuanshu + ", jieguo=" + jieguo
				+ "]";
	}

}
