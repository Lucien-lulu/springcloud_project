package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.HtuserMapper;
import com.qf.j1902.pojo.Htuser;
import com.qf.j1902.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/6/29.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private HtuserMapper htuserMapper;

    @Override
    public List<Htuser> findAll() {
        List<Htuser> all = htuserMapper.findAll();
        return all;
    }

    @Override
    public List<Htuser> findAllByKeyword(String keyword) {
        List<Htuser> allByKeyword = htuserMapper.findAllByKeyword(keyword);
        return allByKeyword;
    }

    @Override
    public Htuser findUserByName(String uname) {
        Htuser userByName = htuserMapper.findUserByName(uname);
        return userByName;
    }

    @Override
    public boolean addUser(Htuser user) {
        boolean b = htuserMapper.addUser(user);
        return b;
    }

    @Override
    public boolean delUser(Integer ids) {
        boolean b = htuserMapper.delUser(ids);
        return b;
    }

    @Override
    public boolean updateUser(Htuser htuser) {
        boolean b = htuserMapper.updateUser(htuser);
        return b;
    }

    @Override
    public boolean updatemima(String uname, String newpw) {
        boolean updatemima = htuserMapper.updatemima(uname, newpw);
        return updatemima;
    }

    @Override
    public List<Htuser> findAllByTypename(String xuanze) {
        List<Htuser> allByTypename = htuserMapper.findAllByTypename(xuanze);
        return allByTypename;
    }
}
