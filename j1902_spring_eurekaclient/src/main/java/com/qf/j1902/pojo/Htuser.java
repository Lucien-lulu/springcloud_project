package com.qf.j1902.pojo;

import lombok.Data;

@Data
public class Htuser {
    private Integer id;  //管理员id

    private String uname;  //管理员的姓名

    private String upw;  //管理员密码

    private String loginName;  //管理员登录名

    private String typename; //管理员的类型挂你要

    private String email;   //管理员的邮箱
    private String tel;  //电话
}