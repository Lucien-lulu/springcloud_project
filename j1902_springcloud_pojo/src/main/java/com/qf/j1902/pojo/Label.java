package com.qf.j1902.pojo;



/**
 * Created by Administrator on 2019/7/13.
 */

public class Label {
    private int id; //id
    private String syspag;//系统标签
    private String mempag;//用户标签

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSyspag() {
        return syspag;
    }

    public void setSyspag(String syspag) {
        this.syspag = syspag;
    }

    public String getMempag() {
        return mempag;
    }

    public void setMempag(String mempag) {
        this.mempag = mempag;
    }
}
