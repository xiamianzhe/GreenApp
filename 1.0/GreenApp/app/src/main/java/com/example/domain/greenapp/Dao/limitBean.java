package com.example.domain.greenapp.Dao;

import java.util.List;

public class limitBean {

    /**
     * sx_shohin_wendu : string
     * xx_shohin_wendu : string
     * sx_shohin_shidu : string
     * xx_shohin_shidu : string
     * sx_pm : string
     * xx_pm : string
     * jieguo : boolean
     * shj : [{"sx_shohin_wendu":"string","xx_shohin_wendu":"string","sx_shohin_shidu":"string","xx_shohin_shidu":"string","sx_pm":"string","xx_pm":"string","jieguo":"boolean"}]
     */

    private String sx_shohin_wendu;
    private String xx_shohin_wendu;
    private String sx_shohin_shidu;
    private String xx_shohin_shidu;
    private String sx_pm;
    private String xx_pm;
    private Boolean jieguo;
    private List<ShjBean> shj;

    public String getSx_shohin_wendu() {
        return sx_shohin_wendu;
    }

    public void setSx_shohin_wendu(String sx_shohin_wendu) {
        this.sx_shohin_wendu = sx_shohin_wendu;
    }

    public String getXx_shohin_wendu() {
        return xx_shohin_wendu;
    }

    public void setXx_shohin_wendu(String xx_shohin_wendu) {
        this.xx_shohin_wendu = xx_shohin_wendu;
    }

    public String getSx_shohin_shidu() {
        return sx_shohin_shidu;
    }

    public void setSx_shohin_shidu(String sx_shohin_shidu) {
        this.sx_shohin_shidu = sx_shohin_shidu;
    }

    public String getXx_shohin_shidu() {
        return xx_shohin_shidu;
    }

    public void setXx_shohin_shidu(String xx_shohin_shidu) {
        this.xx_shohin_shidu = xx_shohin_shidu;
    }

    public String getSx_pm() {
        return sx_pm;
    }

    public void setSx_pm(String sx_pm) {
        this.sx_pm = sx_pm;
    }

    public String getXx_pm() {
        return xx_pm;
    }

    public void setXx_pm(String xx_pm) {
        this.xx_pm = xx_pm;
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
         * sx_shohin_wendu : string
         * xx_shohin_wendu : string
         * sx_shohin_shidu : string
         * xx_shohin_shidu : string
         * sx_pm : string
         * xx_pm : string
         * jieguo : boolean
         */

        private String sx_shohin_wendu;
        private String xx_shohin_wendu;
        private String sx_shohin_shidu;
        private String xx_shohin_shidu;
        private String sx_pm;
        private String xx_pm;
        private Boolean jieguo;

        public String getSx_shohin_wendu() {
            return sx_shohin_wendu;
        }

        public void setSx_shohin_wendu(String sx_shohin_wendu) {
            this.sx_shohin_wendu = sx_shohin_wendu;
        }

        public String getXx_shohin_wendu() {
            return xx_shohin_wendu;
        }

        public void setXx_shohin_wendu(String xx_shohin_wendu) {
            this.xx_shohin_wendu = xx_shohin_wendu;
        }

        public String getSx_shohin_shidu() {
            return sx_shohin_shidu;
        }

        public void setSx_shohin_shidu(String sx_shohin_shidu) {
            this.sx_shohin_shidu = sx_shohin_shidu;
        }

        public String getXx_shohin_shidu() {
            return xx_shohin_shidu;
        }

        public void setXx_shohin_shidu(String xx_shohin_shidu) {
            this.xx_shohin_shidu = xx_shohin_shidu;
        }

        public String getSx_pm() {
            return sx_pm;
        }

        public void setSx_pm(String sx_pm) {
            this.sx_pm = sx_pm;
        }

        public String getXx_pm() {
            return xx_pm;
        }

        public void setXx_pm(String xx_pm) {
            this.xx_pm = xx_pm;
        }

        public Boolean isJieguo() {
            return jieguo;
        }

        public void setJieguo(Boolean jieguo) {
            this.jieguo = jieguo;
        }
    }
}
