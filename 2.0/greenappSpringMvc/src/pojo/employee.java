package pojo;

import java.util.ArrayList;

public class employee {
    private String name;
    private String shohin_gonghao;
    private String shohin_shoujihao;
    private String ruzhishijian;
    private String zhiwu;
    private Boolean jieguo;
    private String mima;
    private String zhanghu;
    private String cj;
    private String mac;

	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShohin_gonghao() {
		return shohin_gonghao;
	}
	public void setShohin_gonghao(String shohin_gonghao) {
		this.shohin_gonghao = shohin_gonghao;
	}
	public String getShohin_shoujihao() {
		return shohin_shoujihao;
	}
	public void setShohin_shoujihao(String shohin_shoujihao) {
		this.shohin_shoujihao = shohin_shoujihao;
	}
	public String getRuzhishijian() {
		return ruzhishijian;
	}
	public void setRuzhishijian(String ruzhishijian) {
		this.ruzhishijian = ruzhishijian;
	}
	public String getZhiwu() {
		return zhiwu;
	}
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}
	public Boolean getJieguo() {
		return jieguo;
	}
	public void setJieguo(Boolean jieguo) {
		this.jieguo = jieguo;
	}
	public String getMima() {
		return mima;
	}
	public void setMima(String mima) {
		this.mima = mima;
	}
	public String getZhanghu() {
		return zhanghu;
	}
	public void setZhanghu(String zhanghu) {
		this.zhanghu = zhanghu;
	}
	public String getCj() {
		return cj;
	}
	public void setCj(String cj) {
		this.cj = cj;
	}
	@Override
	public String toString() {
		return "employee [name=" + name + ", shohin_gonghao=" + shohin_gonghao + ", shohin_shoujihao="
				+ shohin_shoujihao + ", ruzhishijian=" + ruzhishijian + ", zhiwu=" + zhiwu + ", jieguo=" + jieguo
				+ ", mima=" + mima + ", zhanghu=" + zhanghu + ", cj=" + cj + ", mac=" + mac + "]";
	}

    private ArrayList namelist;
    private ArrayList shohin_gonghaolist;
    private ArrayList shohin_shoujihaolist;
    private ArrayList ruzhishijianlist;
    private ArrayList zhiwulist;
    private ArrayList mimalist;
    private ArrayList zhanghulist;
    private ArrayList cjlist;
    private ArrayList maclist;

	public ArrayList getNamelist() {
		return namelist;
	}
	public void setNamelist(ArrayList namelist) {
		this.namelist = namelist;
	}
	public ArrayList getShohin_gonghaolist() {
		return shohin_gonghaolist;
	}
	public void setShohin_gonghaolist(ArrayList shohin_gonghaolist) {
		this.shohin_gonghaolist = shohin_gonghaolist;
	}
	public ArrayList getShohin_shoujihaolist() {
		return shohin_shoujihaolist;
	}
	public void setShohin_shoujihaolist(ArrayList shohin_shoujihaolist) {
		this.shohin_shoujihaolist = shohin_shoujihaolist;
	}
	public ArrayList getRuzhishijianlist() {
		return ruzhishijianlist;
	}
	public void setRuzhishijianlist(ArrayList ruzhishijianlist) {
		this.ruzhishijianlist = ruzhishijianlist;
	}
	public ArrayList getZhiwulist() {
		return zhiwulist;
	}
	public void setZhiwulist(ArrayList zhiwulist) {
		this.zhiwulist = zhiwulist;
	}
	public ArrayList getMimalist() {
		return mimalist;
	}
	public void setMimalist(ArrayList mimalist) {
		this.mimalist = mimalist;
	}
	public ArrayList getZhanghulist() {
		return zhanghulist;
	}
	public void setZhanghulist(ArrayList zhanghulist) {
		this.zhanghulist = zhanghulist;
	}
	public ArrayList getCjlist() {
		return cjlist;
	}
	public void setCjlist(ArrayList cjlist) {
		this.cjlist = cjlist;
	}
	public ArrayList getMaclist() {
		return maclist;
	}
	public void setMaclist(ArrayList maclist) {
		this.maclist = maclist;
	}
}

