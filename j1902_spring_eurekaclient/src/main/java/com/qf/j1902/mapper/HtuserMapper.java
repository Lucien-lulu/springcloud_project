package com.qf.j1902.mapper;

import com.qf.j1902.pojo.Htuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */
@Mapper
public interface HtuserMapper {
  public List<Htuser> findAll();
  public List<Htuser> findAllByKeyword(@Param("keyword") String keyword);
  //根据类型查询用户信息
    public List<Htuser> findAllByTypename(@Param("typename") String xuanze);
    //根据用户名查询用户信息
    public Htuser findUserByName(String uname);
    //添加新的管理员信息
   public boolean addUser(Htuser user);
    //根据ids删除管理员信息
   public boolean delUser(Integer ids);
   //根据用户id修改用户信息
    public boolean updateUser(Htuser htuser);
    //根据旧密码修改密码信息
    public boolean updatemima(@Param("uname") String uname,@Param("newpw") String newpw);
}