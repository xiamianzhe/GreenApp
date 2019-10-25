package pojo;

public class Smsbean {
private String shohin_shoujihao;
private String shohin_gonghao;
private String yanzjg;
public String getYanzjg() {
	return yanzjg;
}
public void setYanzjg(String yanzjg) {
	this.yanzjg = yanzjg;
}
public String getShohin_gonghao() {
	return shohin_gonghao;
}
public void setShohin_gonghao(String shohin_gonghao) {
	this.shohin_gonghao = shohin_gonghao;
}
private int code;
public String getShohin_shoujihao() {
	return shohin_shoujihao;
}
public void setShohin_shoujihao(String shohin_shoujihao) {
	this.shohin_shoujihao = shohin_shoujihao;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
@Override
public String toString() {
	return "Smsbean [shohin_shoujihao=" + shohin_shoujihao + ", shohin_gonghao=" + shohin_gonghao + ", yanzjg=" + yanzjg
			+ ", code=" + code + "]";
}

}
