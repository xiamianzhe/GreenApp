package com.example.domain.greenapp.Dao;

import java.util.List;

public class FlyRouteBean {

    /**
     * name : string
     * shohin_gonghao : string
     * shohin_shoujihao : string
     * ruzhishijian : string
     * zhiwu : string
     * jieguo : boolean
     * mima : string
     * zhanghu : string
     * Serial : [{"name":"string","shohin_gonghao":"string","shohin_shoujihao":"string","ruzhishijian":"string","zhiwu":"string","jieguo":"boolean","mima":"string","zhanghu":"string"}]
     */

    private String name;
    private String shohin_gonghao;
    private String shohin_shoujihao;
    private String ruzhishijian;
    private String zhiwu;
    private Boolean jieguo;
    private String mima;
    private String zhanghu;
    private String cj;
    public String getCj() {
        return cj;
    }
    private String mac;

    public void setCj(String cj) {
        this.cj = cj;
    }
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    private List<SerialBean> Serial;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShohin_gonghao() {
        return shohin_gonghao;
    }

    public void setShohin_gonghao(String shohin_gonghao) {
        this.shohin_gonghao = shohin_gonghao;
    }

    public String getShohin_shoujihao() {
        return shohin_shoujihao;
    }

    public void setShohin_shoujihao(String shohin_shoujihao) {
        this.shohin_shoujihao = shohin_shoujihao;
    }

    public String getRuzhishijian() {
        return ruzhishijian;
    }

    public void setRuzhishijian(String ruzhishijian) {
        this.ruzhishijian = ruzhishijian;
    }

    public String getZhiwu() {
        return zhiwu;
    }

    public void setZhiwu(String zhiwu) {
        this.zhiwu = zhiwu;
    }

    public Boolean isJieguo() {
        return jieguo;
    }

    public void setJieguo(Boolean jieguo) {
        this.jieguo = jieguo;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    public String getZhanghu() {
        return zhanghu;
    }

    public void setZhanghu(String zhanghu) {
        this.zhanghu = zhanghu;
    }

    public List<SerialBean> getSerial() {
        return Serial;
    }

    public void setSerial(List<SerialBean> Serial) {
        this.Serial = Serial;
    }

    public static class SerialBean {
        /**
         * name : string
         * shohin_gonghao : string
         * shohin_shoujihao : string
         * ruzhishijian : string
         * zhiwu : string
         * jieguo : boolean
         * mima : string
         * zhanghu : string
         */

        private String name;
        private String shohin_gonghao;
        private String shohin_shoujihao;
        private String ruzhishijian;
        private String zhiwu;
        private Boolean jieguo;
        private String mima;
        private String zhanghu;
        private String cj;
        private String mac;
        public String getMac() {
            return mac;
        }
        public void setMac(String mac) {
            this.mac = mac;
        }
        public String getCj() {
            return cj;
        }
        public void setCj(String cj) {
            this.cj = cj;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShohin_gonghao() {
            return shohin_gonghao;
        }

        public void setShohin_gonghao(String shohin_gonghao) {
            this.shohin_gonghao = shohin_gonghao;
        }

        public String getShohin_shoujihao() {
            return shohin_shoujihao;
        }

        public void setShohin_shoujihao(String shohin_shoujihao) {
            this.shohin_shoujihao = shohin_shoujihao;
        }

        public String getRuzhishijian() {
            return ruzhishijian;
        }

        public void setRuzhishijian(String ruzhishijian) {
            this.ruzhishijian = ruzhishijian;
        }

        public String getZhiwu() {
            return zhiwu;
        }

        public void setZhiwu(String zhiwu) {
            this.zhiwu = zhiwu;
        }

        public Boolean isJieguo() {
            return jieguo;
        }

        public void setJieguo(Boolean jieguo) {
            this.jieguo = jieguo;
        }

        public String getMima() {
            return mima;
        }

        public void setMima(String mima) {
            this.mima = mima;
        }

        public String getZhanghu() {
            return zhanghu;
        }

        public void setZhanghu(String zhanghu) {
            this.zhanghu = zhanghu;
        }
    }
}
