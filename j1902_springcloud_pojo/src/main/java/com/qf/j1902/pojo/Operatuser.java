package com.qf.j1902.pojo;

import java.util.Date;


public class Operatuser {
    private Integer id; //用户id

    private String uname; //用户名称

    private Date operatime; //操作时间

    private String opratip; //操作ip地址

    private Date sendtime; //发送消息的时间

    private String utitle; //发送消息的标题

    private String utext; //发送消息的内容

    private String linkage; //备注链接地址
    private String remark="成功登陆后台系统";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Date getOperatime() {
        return operatime;
    }

    public void setOperatime(Date operatime) {
        this.operatime = operatime;
    }

    public String getOpratip() {
        return opratip;
    }

    public void setOpratip(String opratip) {
        this.opratip = opratip == null ? null : opratip.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getUtitle() {
        return utitle;
    }

    public void setUtitle(String utitle) {
        this.utitle = utitle == null ? null : utitle.trim();
    }

    public String getUtext() {
        return utext;
    }

    public void setUtext(String utext) {
        this.utext = utext == null ? null : utext.trim();
    }

    public String getLinkage() {
        return linkage;
    }

    public void setLinkage(String linkage) {
        this.linkage = linkage == null ? null : linkage.trim();
    }

    @Override
    public String toString() {
        return "Operatuser{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", operatime=" + operatime +
                ", opratip='" + opratip + '\'' +
                ", sendtime=" + sendtime +
                ", utitle='" + utitle + '\'' +
                ", utext='" + utext + '\'' +
                ", linkage='" + linkage + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}