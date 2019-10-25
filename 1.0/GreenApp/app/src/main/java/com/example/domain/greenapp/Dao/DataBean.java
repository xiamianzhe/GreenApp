package com.example.domain.greenapp.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBean {

    /**
     * pm : string
     * shohin_wendu : string
     * shohin_shidu : string
     * andshidu : ArrayList
     * shohin_shijian : string
     * jieguo : boolean
     * shj : [{"pm":"string","shohin_wendu":"string","shohin_shidu":"string","andshidu":"ArrayList","shohin_shijian":"string","jieguo":"boolean"}]
     */

    private String pm;
    private String shohin_wendu;
    private String shohin_shidu;
    public Map<String, String> map;
    private String shohin_shijian;
    private Boolean jieguo;
    private String cj;
    private List<ShjBean> shj;
    public String getCj() {
        return cj;
    }
    public void setCj(String cj) {
        this.cj = cj;
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
    public boolean dr;
    public boolean isDr() {
        return dr;
    }
    public void setDr(boolean dr) {
        this.dr = dr;
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

    public Map<String, String> getMap() {
        return map;
    }
    public void setMap1(Map<String, String> map) {
        this.map = map;
    }

    public String getShohin_shijian() {
        return shohin_shijian;
    }

    public void setShohin_shijian(String shohin_shijian) {
        this.shohin_shijian = shohin_shijian;
    }

    public Boolean isJieguo() {
        return jieguo;
    }

    public void setJieguo(Boolean jieguo) {
        this.jieguo = jieguo;
    }

    public List<ShjBean> getShj() {
        return shj;
    }

    public void setShj(List<ShjBean> shj) {
        this.shj = shj;
    }

    public static class ShjBean {
        /**
         * pm : string
         * shohin_wendu : string
         * shohin_shidu : string
         * andshidu : ArrayList
         * shohin_shijian : string
         * jieguo : boolean
         */

        private String pm;
        private String shohin_wendu;
        private String shohin_shidu;
        public Map<String, String> map;
        private String shohin_shijian;
        private Boolean jieguo;
        private String cj;
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
        public boolean dr;
        public boolean isDr() {
            return dr;
        }
        public void setDr(boolean dr) {
            this.dr = dr;
        }
        public Map<String, String> getMap() {
            return map;
        }
        public void setMap(Map<String, String> map) {
            this.map = map;
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

        public Boolean isJieguo() {
            return jieguo;
        }

        public void setJieguo(Boolean jieguo) {
            this.jieguo = jieguo;
        }
        public String getCj() {
            return cj;
        }
        public void setCj(String cj) {
            this.cj = cj;
        }
    }
}
