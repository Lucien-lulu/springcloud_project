package com.qf.j1902.service;

import com.qf.j1902.pojo.Htuser;

import java.util.List;

/**
 * Created by Administrator on 2019/6/29.
 */
public interface UserService {

    public List<Htuser> findAll();
   // public EasyuiResult findAll(Integer page, Integer pageSize, String title);
    //搜素查询(根据关键字)
   public List<Htuser> findAllByKeyword(String keyword);
   //根据用户名查询用户信息
    public Htuser findUserByName(String uname);
    //添加新的管理员信息
   public boolean addUser(Htuser user);
    //根据ids删除管理员信息
    public boolean delUser(Integer ids);
    //根据用户id修改用户信息
    public boolean updateUser(Htuser htuser);
    //根据旧密码修改密码信息
    public boolean updatemima(String uname,String newpw);
    //根据类型查询用户信息
    public List<Htuser> findAllByTypename(String xuanze);

}

