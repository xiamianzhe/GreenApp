package com.example.domain.greenapp.Dao;

import java.util.List;
import java.util.Map;

public class NpBean {

    /**
     * cj : string
     * pinci : string
     * shohin_shijian : string
     * nenhao : string
     * jieguo : boolean
     * shj : [{"cj":"string","pinci":"string","shohin_shijian":"string","nenhao":"string","jieguo":"boolean"}]
     */

    private String cj;
    private String pinci;
    private String shohin_shijian;
    private String nenhao;
    private Boolean jieguo;
    public Map<String, String> map;
    private List<ShjBean> shj;
    public Map<String, String> getMap() {
        return map;
    }
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
    public String getCj() {
        return cj;
    }

    public void setCj(String cj) {
        this.cj = cj;
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

    public String getNenhao() {
        return nenhao;
    }

    public void setNenhao(String nenhao) {
        this.nenhao = nenhao;
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
         * cj : string
         * pinci : string
         * shohin_shijian : string
         * nenhao : string
         * jieguo : boolean
         */

        private String cj;
        private String pinci;
        private String shohin_shijian;
        private String nenhao;
        private Boolean jieguo;
        public Map<String, String> map;
        public String getCj() {
            return cj;
        }

        public void setCj(String cj) {
            this.cj = cj;
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

        public String getNenhao() {
            return nenhao;
        }

        public void setNenhao(String nenhao) {
            this.nenhao = nenhao;
        }

        public Boolean isJieguo() {
            return jieguo;
        }

        public void setJieguo(Boolean jieguo) {
            this.jieguo = jieguo;
        }
        public Map<String, String> getMap() {
            return map;
        }
        public void setMap(Map<String, String> map) {
            this.map = map;
        }
    }
}
