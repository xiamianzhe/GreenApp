package com.example.domain.greenapp.Dao;

import java.util.List;

public class HjzzBean {

    /**
     * id : string
     * cj : string
     * shohin_kgzt : string
     * shohin_ms : string
     * shohin_sd : ArrayList
     * shohin_wd : string
     * shohin_kt : string
     * jieguo : boolean
     * shj : [{"id":"string","cj":"string","shohin_kgzt":"string","shohin_ms":"string","shohin_sd":"ArrayList","shohin_wd":"string","shohin_kt":"string","jieguo":"boolean"}]
     */

    private String id;
    private String cj;
    private String shohin_kgzt;
    private String shohin_ms;
    private String shohin_sd;
    private String shohin_wd;
    private String shohin_kt;
    private Boolean jieguo;
    private List<ShjBean> shj;

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

    public String getShohin_kt() {
        return shohin_kt;
    }

    public void setShohin_kt(String shohin_kt) {
        this.shohin_kt = shohin_kt;
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
         * id : string
         * cj : string
         * shohin_kgzt : string
         * shohin_ms : string
         * shohin_sd : ArrayList
         * shohin_wd : string
         * shohin_kt : string
         * jieguo : boolean
         */

        private String id;
        private String cj;
        private String shohin_kgzt;
        private String shohin_ms;
        private String shohin_sd;
        private String shohin_wd;
        private String shohin_kt;
        private Boolean jieguo;

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

        public String getShohin_kt() {
            return shohin_kt;
        }

        public void setShohin_kt(String shohin_kt) {
            this.shohin_kt = shohin_kt;
        }

        public Boolean isJieguo() {
            return jieguo;
        }

        public void setJieguo(Boolean jieguo) {
            this.jieguo = jieguo;
        }
    }
}
