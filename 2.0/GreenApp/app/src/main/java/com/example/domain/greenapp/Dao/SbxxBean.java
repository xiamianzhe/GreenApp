package com.example.domain.greenapp.Dao;

import java.util.List;

public class SbxxBean {

    /**
     * cj : string
     * jiqibianhao : string
     * jiqixinghao : string
     * fuzheren : ArrayList
     * chaigoushijian : string
     * chuchangshijian : string
     * jieguo : boolean
     * shj : [{"cj":"string","jiqibianhao":"string","jiqixinghao":"string","fuzheren":"ArrayList","chaigoushijian":"string","chuchangshijian":"string","jieguo":"boolean"}]
     */

    private String cj;
    private String jiqibianhao;
    private String jiqixinghao;
    private String fuzheren;
    private String chaigoushijian;
    private String chuchangshijian;
    private Boolean jieguo;
    private List<ShjBean> shj;

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
         * jiqibianhao : string
         * jiqixinghao : string
         * fuzheren : ArrayList
         * chaigoushijian : string
         * chuchangshijian : string
         * jieguo : boolean
         */

        private String cj;
        private String jiqibianhao;
        private String jiqixinghao;
        private String fuzheren;
        private String chaigoushijian;
        private String chuchangshijian;
        private Boolean jieguo;

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

        public Boolean isJieguo() {
            return jieguo;
        }

        public void setJieguo(Boolean jieguo) {
            this.jieguo = jieguo;
        }
    }
}
