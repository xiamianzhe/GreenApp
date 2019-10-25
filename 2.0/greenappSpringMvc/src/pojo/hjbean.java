package pojo;

public class hjbean {
	private String shohin_kaiguang   ;
	private String shohin_moshi; 
	private String shohin_wndu ;
	private String shohin_fesu ;
	public String getShohin_kaiguang() {
		return shohin_kaiguang;
	}
	public void setShohin_kaiguang(String shohin_kaiguang) {
		this.shohin_kaiguang = shohin_kaiguang;
	}
	public String getShohin_moshi() {
		return shohin_moshi;
	}
	public void setShohin_moshi(String shohin_moshi) {
		this.shohin_moshi = shohin_moshi;
	}
	public String getShohin_wndu() {
		return shohin_wndu;
	}
	public void setShohin_wndu(String shohin_wndu) {
		this.shohin_wndu = shohin_wndu;
	}
	public String getShohin_fesu() {
		return shohin_fesu;
	}
	public void setShohin_fesu(String shohin_fesu) {
		this.shohin_fesu = shohin_fesu;
	}
	@Override
	public String toString() {
		return "hjbean [shohin_kaiguang=" + shohin_kaiguang + ", shohin_moshi=" + shohin_moshi + ", shohin_wndu="
				+ shohin_wndu + ", shohin_fesu=" + shohin_fesu + "]";
	}
}
