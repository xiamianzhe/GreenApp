package pojo;

public class sbxxbean {
	private String id;
	private String cj;
	private String jiqibianhao;
	private String jiqixinghao;
	private String fuzheren;
	private String chaigoushijian;
	private String chuchangshijian;
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
	public String getJiqibianhao() {
		return jiqibianhao;
	}
	public void setJiqibianhao(String jiqibianhao) {
		this.jiqibianhao = jiqibianhao;
	}
	public String getJiqixinghao() {
		return jiqixinghao;
	}
	public void setJiqixinghao(String jiqixinghao) {
		this.jiqixinghao = jiqixinghao;
	}
	public String getFuzheren() {
		return fuzheren;
	}
	public void setFuzheren(String fuzheren) {
		this.fuzheren = fuzheren;
	}
	public String getChaigoushijian() {
		return chaigoushijian;
	}
	public void setChaigoushijian(String chaigoushijian) {
		this.chaigoushijian = chaigoushijian;
	}
	public String getChuchangshijian() {
		return chuchangshijian;
	}
	public void setChuchangshijian(String chuchangshijian) {
		this.chuchangshijian = chuchangshijian;
	}
	@Override
	public String toString() {
		return "sbxxbean [id=" + id + ", cj=" + cj + ", jiqibianhao=" + jiqibianhao + ", jiqixinghao=" + jiqixinghao
				+ ", fuzheren=" + fuzheren + ", chaigoushijian=" + chaigoushijian + ", chuchangshijian="
				+ chuchangshijian + "]";
	}
	
}
