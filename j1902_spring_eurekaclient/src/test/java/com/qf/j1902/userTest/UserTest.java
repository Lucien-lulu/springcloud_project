package com.qf.j1902.userTest;

import com.qf.j1902.mapper.HtuserMapper;
import com.qf.j1902.pojo.Htuser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Configuration("com.qf.j1902.mapper")
public class UserTest {
    @Resource
    private HtuserMapper htuserMapper;
    @Test
    public void test1(){
        List<Htuser> w = htuserMapper.findAllByKeyword("w");
        System.out.println(w);
    }

    @Test
    public void test2(){
        Htuser user=new Htuser();
        user.setUname("zhao");
        user.setTypename("junior_admin");
        user.setLoginName("溜溜");
        user.setEmail("56525629@163.com");
        user.setUpw("123");
        boolean b = htuserMapper.addUser(user);
        System.out.println(b);
    }

    @Test
    public void test3(){
        boolean b = htuserMapper.delUser(11);
        System.out.println(b);
    }
    @Test
    public void test4(){
        Htuser htuser = new Htuser();
        htuser.setId(7);
        htuser.setEmail("555252525@qq.com");
        htuser.setLoginName("lidazui");
        htuser.setTypename("junior_admin");
        htuser.setUname("licaixia");
        boolean b = htuserMapper.updateUser(htuser);
        System.out.println(b);
    }
    @Test
    public void test5(){
        Htuser wl = htuserMapper.findUserByName("wl");
        System.out.println(wl);
    }
    @Test
    public void testgaimima(){
        boolean admin = htuserMapper.updatemima("admin", "222");
        System.out.println(admin);
    }
    @Test
    public void test7(){
        List<Htuser> junior_admin = htuserMapper.findAllByTypename("junior_admin");
        System.out.println(junior_admin);
    }
}
