package pojo;

import java.util.ArrayList;

public class employee2 {
		// Ö°Îñ//
		private  String id;
		private  String shohin_guangliyuan;
		private  String cj;
		private ArrayList<String> cjh;

        public ArrayList<String> getCjh() {
            return cjh;
        }

        public void setCjh(ArrayList<String> cjh) {
            this.cjh = cjh;
        }
		public void setId(String id) {
			this.id = id;
		}
		public String getShohin_guangliyuan() {
			return shohin_guangliyuan;
		}
		public void setShohin_guangliyuan(String shohin_guangliyuan) {
			this.shohin_guangliyuan = shohin_guangliyuan;
		}

		public String getCj() {
			return cj;
		}

		public void setCj(String cj) {
			this.cj = cj;
		}

		public String getId() {
			return id;
		}

		@Override
		public String toString() {
			return "employee2 [id=" + id + ", shohin_guangliyuan=" + shohin_guangliyuan + ", cj=" + cj + ", cjh=" + cjh
					+ "]";
		}
		
	}


