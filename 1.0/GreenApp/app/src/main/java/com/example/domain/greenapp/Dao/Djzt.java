package com.example.domain.greenapp.Dao;

import java.util.List;

public class Djzt {

    /**生产设备状态
     * cj : string
     * shohin_kaiguang : string
     * shohin_guzhang : string
     * shohin_nenhao : string
     * shohin_zhuanshu : string
     * jieguo : boolean
     * shj : [{"cj":"string","shohin_kaiguang":"string","shohin_guzhang":"string","shohin_nenhao":"string","shohin_zhuanshu":"string","jieguo":"boolean"}]
     */

    private String cj;
    private String shohin_kaiguang;
    private String shohin_guzhang;
    private String shohin_nenhao;
    private String shohin_zhuanshu;
    private Boolean jieguo;
    private List<ShjBean> shj;

    public String getCj() {
        return cj;
    }

    public void setCj(String cj) {
        this.cj = cj;
    }

    public String getShohin_kaiguang() {
        return shohin_kaiguang;
    }

    public void setShohin_kaiguang(String shohin_kaiguang) {
        this.shohin_kaiguang = shohin_kaiguang;
    }

    public String getShohin_guzhang() {
        return shohin_guzhang;
    }

    public void setShohin_guzhang(String shohin_guzhang) {
        this.shohin_guzhang = shohin_guzhang;
    }

    public String getShohin_nenhao() {
        return shohin_nenhao;
    }

    public void setShohin_nenhao(String shohin_nenhao) {
        this.shohin_nenhao = shohin_nenhao;
    }

    public String getShohin_zhuanshu() {
        return shohin_zhuanshu;
    }

    public void setShohin_zhuanshu(String shohin_zhuanshu) {
        this.shohin_zhuanshu = shohin_zhuanshu;
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
         * shohin_kaiguang : string
         * shohin_guzhang : string
         * shohin_nenhao : string
         * shohin_zhuanshu : string
         * jieguo : boolean
         */

        private String cj;
        private String shohin_kaiguang;
        private String shohin_guzhang;
        private String shohin_nenhao;
        private String shohin_zhuanshu;
        private Boolean jieguo;

        public String getCj() {
            return cj;
        }

        public void setCj(String cj) {
            this.cj = cj;
        }

        public String getShohin_kaiguang() {
            return shohin_kaiguang;
        }

        public void setShohin_kaiguang(String shohin_kaiguang) {
            this.shohin_kaiguang = shohin_kaiguang;
        }

        public String getShohin_guzhang() {
            return shohin_guzhang;
        }

        public void setShohin_guzhang(String shohin_guzhang) {
            this.shohin_guzhang = shohin_guzhang;
        }

        public String getShohin_nenhao() {
            return shohin_nenhao;
        }

        public void setShohin_nenhao(String shohin_nenhao) {
            this.shohin_nenhao = shohin_nenhao;
        }

        public String getShohin_zhuanshu() {
            return shohin_zhuanshu;
        }

        public void setShohin_zhuanshu(String shohin_zhuanshu) {
            this.shohin_zhuanshu = shohin_zhuanshu;
        }

        public Boolean isJieguo() {
            return jieguo;
        }

        public void setJieguo(Boolean jieguo) {
            this.jieguo = jieguo;
        }
    }
}
