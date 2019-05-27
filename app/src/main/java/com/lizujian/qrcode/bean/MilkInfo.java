package com.lizujian.qrcode.bean;

import android.widget.EditText;

import java.util.List;

public class MilkInfo {

    private T1Bean t1;
    private T2Bean t2;
    private T3Bean t3;
    private T4Bean t4;

    public T1Bean getT1() {
        return t1;
    }

    public void setT1(T1Bean t1) {
        this.t1 = t1;
    }

    public T2Bean getT2() {
        return t2;
    }

    public void setT2(T2Bean t2) {
        this.t2 = t2;
    }

    public T3Bean getT3() {
        return t3;
    }

    public void setT3(T3Bean t3) {
        this.t3 = t3;
    }

    public T4Bean getT4() {
        return t4;
    }

    public void setT4(T4Bean t4) {
        this.t4 = t4;
    }

    public static class T1Bean{
        String lyfs;
        String nnzk;
        String czy;
        String batch;

        public String getLyfs() {
            return lyfs;
        }

        public void setLyfs(String lyfs) {
            this.lyfs = lyfs;
        }

        public String getNnzk() {
            return nnzk;
        }

        public void setNnzk(String nnzk) {
            this.nnzk = nnzk;
        }

        public String getCzy() {
            return czy;
        }

        public void setCzy(String czy) {
            this.czy = czy;
        }

        public String getBatch() {
            return batch;
        }

        public void setBatch(String batch) {
            this.batch = batch;
        }
    }

    public static class T2Bean{

        String  jgcs;
        String  jgzq;
        String  glbz;
        String  sjfs;
        String  batch;

        public String getJgcs() {
            return jgcs;
        }

        public void setJgcs(String jgcs) {
            this.jgcs = jgcs;
        }

        public String getJgzq() {
            return jgzq;
        }

        public void setJgzq(String jgzq) {
            this.jgzq = jgzq;
        }

        public String getGlbz() {
            return glbz;
        }

        public void setGlbz(String glbz) {
            this.glbz = glbz;
        }

        public String getSjfs() {
            return sjfs;
        }

        public void setSjfs(String sjfs) {
            this.sjfs = sjfs;
        }

        public String getBatch() {
            return batch;
        }

        public void setBatch(String batch) {
            this.batch = batch;
        }
    }

    public static class T3Bean{
        String  ysy;
        String cph;
        String cnwd;
        String batch;
        public String getYsy() {
            return ysy;
        }

        public void setYsy(String ysy) {
            this.ysy = ysy;
        }

        public String getCph() {
            return cph;
        }

        public void setCph(String cph) {
            this.cph = cph;
        }

        public String getCnwd() {
            return cnwd;
        }

        public void setCnwd(String cnwd) {
            this.cnwd = cnwd;
        }

        public String getBatch() {
            return batch;
        }

        public void setBatch(String batch) {
            this.batch = batch;
        }
    }

    public static class T4Bean{
        String xsfs;
        String bzrq;
        String lsjg;
        String batch;

        public String getXsfs() {
            return xsfs;
        }

        public void setXsfs(String xsfs) {
            this.xsfs = xsfs;
        }

        public String getBzrq() {
            return bzrq;
        }

        public void setBzrq(String bzrq) {
            this.bzrq = bzrq;
        }

        public String getLsjg() {
            return lsjg;
        }

        public void setLsjg(String lsjg) {
            this.lsjg = lsjg;
        }

        public String getBatch() {
            return batch;
        }

        public void setBatch(String batch) {
            this.batch = batch;
        }
    }

    public MilkInfo(){

    }

    public static MilkInfo addNewInfo(List<EditText> list) {
        MilkInfo info = new MilkInfo();

        return info;
    }
}
