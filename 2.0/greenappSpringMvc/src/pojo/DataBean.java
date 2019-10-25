package pojo;

import java.util.ArrayList;
import java.util.Map;

import net.sf.json.JSONArray;

public class DataBean {
	// 车间信息//
		public Map<String, String> map;
	
		public Map<String, String> getMap() {
			return map;
		}
		public void setMap(Map<String, String> map) {
			this.map = map;
		}
		public boolean dr;
		public boolean isDr() {
			return dr;
		}
		public void setDr(boolean dr) {
			this.dr = dr;
		}
		//空值判断
		public boolean error;
		public boolean isError() {
			return error;
		}
		public void setError(boolean error) {
			this.error = error;
		}
		//返回值为空的时间
		public ArrayList<String> cw;
		public ArrayList<String> getCw() {
			return cw;
		}
		public void setCw(ArrayList<String> cw) {
			this.cw = cw;
		}
		// 车间信息//
		private boolean jieguo;
		public boolean isJieguo() {
			return jieguo;
		}
		public void setJieguo(boolean jieguo) {
			this.jieguo = jieguo;
		}
		// 车间信息//
		private String pm;
		private String shohin_wendu;
		private String shohin_shidu;
		private String shohin_shijian;
		private String cj;
		public String getCj() {
			return cj;
		}
		public void setCj(String cj) {
			this.cj = cj;
		}
		public String getPm() {
			return pm;
		}
		public void setPm(String pm) {
			this.pm = pm;
		}
		public String getShohin_wendu() {
			return shohin_wendu;
		}
		public void setShohin_wendu(String shohin_wendu) {
			this.shohin_wendu = shohin_wendu;
		}
		public String getShohin_shidu() {
			return shohin_shidu;
		}
		public void setShohin_shidu(String shohin_shidu) {
			this.shohin_shidu = shohin_shidu;
		}
		public String getShohin_shijian() {
			return shohin_shijian;
		}
		public void setShohin_shijian(String shohin_shijian) {
			this.shohin_shijian = shohin_shijian;
		}
		@Override
		public String toString() {
			return "DataBean [map=" + map + ", dr=" + dr + ", error=" + error + ", cw=" + cw + ", jieguo=" + jieguo
					+ ", pm=" + pm + ", shohin_wendu=" + shohin_wendu + ", shohin_shidu=" + shohin_shidu
					+ ", shohin_shijian=" + shohin_shijian + ", cj=" + cj + "]";
		}
}
