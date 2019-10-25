package com.example.domain.greenapp.Dao;

import java.util.List;

public class ReturnContant {

    /**
     * Shohin_shoujihao : string
     * private String yanzjg;
     * code : int
     * SMS : [{"Shohin_shoujihao":"string","code":"int"}]
     */

    private String shohin_shoujihao;
    private int code;
    private String yanzjg;

    private List<SMSBean> SMS;
    public String getYanzjg() {
        return yanzjg;
    }
    public void setYanzjg(String yanzjg) {
        this.yanzjg = yanzjg;
    }
    public String getShohin_shoujihao() {
        return shohin_shoujihao;
    }

    public void setShohin_shoujihao(String Shohin_shoujihao) {
        this.shohin_shoujihao = Shohin_shoujihao;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<SMSBean> getSMS() {
        return SMS;
    }

    public void setSMS(List<SMSBean> SMS) {
        this.SMS = SMS;
    }

    public static class SMSBean {
        /**
         * Shohin_shoujihao : string
         * code : int
         */

        private String shohin_shoujihao;
        private int code;
        private String yanzjg;
        public String getYanzjg() {
            return yanzjg;
        }
        public void setYanzjg(String yanzjg) {
            this.yanzjg = yanzjg;
        }
        public String getShohin_shoujihao() {
            return shohin_shoujihao;
        }

        public void setShohin_shoujihao(String Shohin_shoujihao) {
            this.shohin_shoujihao = Shohin_shoujihao;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
