package com.qf.j1902.userTest;

import com.qf.j1902.mapper.OperatuserMapper;
import com.qf.j1902.pojo.Operatuser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Configuration("com.qf.j1902.mapper")
public class OperUserTest {
    @Resource
    private OperatuserMapper opuser;
    @Test
    public void test1() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fortime = df.format(new Date());
        Date parse = df.parse(fortime);
        System.out.println("登录日期："+parse);
        Operatuser operatUser=new Operatuser();
        operatUser.setUname("wl");
        operatUser.setOperatime((parse));
        //获取ip地址
        operatUser.setOpratip("10.12.159.32");
        int insert = opuser.insert(operatUser);
        System.out.println(insert);
    }
}
