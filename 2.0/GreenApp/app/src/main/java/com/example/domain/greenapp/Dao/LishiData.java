package com.example.domain.greenapp.Dao;

import java.util.ArrayList;
import java.util.Date;

//历史数据
public class LishiData {
    private ArrayList<String> As;
    public ArrayList<String> getAs() {
        return As;
    }



    public void setAs(ArrayList<String> as) {
        As = as;
    }
    private String cj;
    public String getCj() {
        return cj;
    }



    public void setCj(String cj) {
        this.cj = cj;
    }



    public Date getBeginTime() {
        return beginTime;
    }



    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }



    public Date getEndTime() {
        return endTime;
    }



    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }



    private Date beginTime;
    private Date endTime;
    public static class ShjBean {
        private ArrayList<String> As;
        public ArrayList<String> getAs() {
            return As;
        }



        public void setAs(ArrayList<String> as) {
            As = as;
        }
        private String cj;
        public String getCj() {
            return cj;
        }



        public void setCj(String cj) {
            this.cj = cj;
        }



        public Date getBeginTime() {
            return beginTime;
        }



        public void setBeginTime(Date beginTime) {
            this.beginTime = beginTime;
        }



        public Date getEndTime() {
            return endTime;
        }



        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }



        private Date beginTime;
        private Date endTime;
    }
}
