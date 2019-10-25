package com.example.domain.greenapp.Dao;

import java.util.ArrayList;
import java.util.List;

public class EzBean {

    /**
     * cjh : ArrayList
     * shj : [{"cjh":"ArrayList"}]
     */

    private ArrayList cjh;
    private List<ShjBean> shj;

    public ArrayList getCjh() {
        return cjh;
    }

    public void setCjh(ArrayList cjh) {
        this.cjh = cjh;
    }

    public List<ShjBean> getShj() {
        return shj;
    }

    public void setShj(List<ShjBean> shj) {
        this.shj = shj;
    }

    public static class ShjBean {
        /**
         * cjh : ArrayList
         */

        private ArrayList cjh;

        public ArrayList getCjh() {
            return cjh;
        }

        public void setCjh(ArrayList cjh) {
            this.cjh = cjh;
        }
    }
}
