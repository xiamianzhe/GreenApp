package pojo;

public class sbzzbean {
	private String id;
	private String cj;
	private String shohin_kt;//¿Õµ÷
	private String shohin_kgzt;//¿ª¹Ø×´Ì¬
	private String shohin_ms;
	private String shohin_sd;
	private String shohin_wd;
	private boolean jieguo;
	public boolean isJieguo() {
		return jieguo;
	}
	public void setJieguo(boolean jieguo) {
		this.jieguo = jieguo;
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
	public String getShohin_kt() {
		return shohin_kt;
	}
	public void setShohin_kt(String shohin_kt) {
		this.shohin_kt = shohin_kt;
	}
	public String getShohin_kgzt() {
		return shohin_kgzt;
	}
	public void setShohin_kgzt(String shohin_kgzt) {
		this.shohin_kgzt = shohin_kgzt;
	}
	public String getShohin_ms() {
		return shohin_ms;
	}
	public void setShohin_ms(String shohin_ms) {
		this.shohin_ms = shohin_ms;
	}
	public String getShohin_sd() {
		return shohin_sd;
	}
	public void setShohin_sd(String shohin_sd) {
		this.shohin_sd = shohin_sd;
	}
	public String getShohin_wd() {
		return shohin_wd;
	}
	public void setShohin_wd(String shohin_wd) {
		this.shohin_wd = shohin_wd;
	}
	@Override
	public String toString() {
		return "sbzzbean [id=" + id + ", cj=" + cj + ", shohin_kt=" + shohin_kt + ", shohin_kgzt=" + shohin_kgzt
				+ ", shohin_ms=" + shohin_ms + ", shohin_sd=" + shohin_sd + ", shohin_wd=" + shohin_wd + ", jieguo="
				+ jieguo + "]";
	}

}
