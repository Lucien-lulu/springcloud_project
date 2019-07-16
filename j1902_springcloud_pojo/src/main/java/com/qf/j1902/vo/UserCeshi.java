package com.qf.j1902.vo;


/**
 * Created by Administrator on 2019/7/11.
 */

public class UserCeshi {
    private String name;
    private int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "UserCeshi{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    public UserCeshi(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
