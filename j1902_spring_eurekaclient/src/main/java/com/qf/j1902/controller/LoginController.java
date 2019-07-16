package com.qf.j1902.controller;
import com.qf.j1902.pojo.Htuser;
import com.qf.j1902.pojo.Operatuser;
import com.qf.j1902.service.OpUserService;
import com.qf.j1902.service.UserService;
import com.qf.j1902.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/6/26.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private OpUserService opUserService;

    @RequestMapping(value = "/findUserByName")
    @ResponseBody
    public Htuser findUserByName(@RequestParam("userName") String userName){
        Htuser htuser = userService.findUserByName(userName);
        return htuser;
    }

    @RequestMapping("/addjournal")
    @ResponseBody
    public Integer addjournal(@RequestParam("userName") String userName,
              HttpServletRequest reques) throws ParseException, UnknownHostException {
        Operatuser operatUser=new Operatuser();
        operatUser.setUname(userName);
        //添加访客的访问时间  string类型转date类型
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fortime = df.format(new Date());
        Date parse = df.parse(fortime);
        System.out.println("登录日期："+parse);
        operatUser.setOperatime(parse);
        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        String ipAddr = IpUtil.getIpAddr(reques);
        operatUser.setOpratip(ipAddr);
        int i = opUserService.addOperaUser(operatUser);
        return i;

    }

    @RequestMapping(value = "/gologin",method = RequestMethod.POST)
    public String gologin(@RequestParam("userName") String userName,
                          @RequestParam("userPwd") String userPwd,
                         HttpSession session,HttpServletRequest request,
                         Model model) throws IOException, ParseException {
        //验证码图片验证
       // String verify = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);
        if("wl".equals(userName) && "114".equals(userPwd)){
            //添加访客的访问时间  string类型转date类型
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fortime = df.format(new Date());
            Date parse = df.parse(fortime);
            System.out.println("登录日期："+parse);
            Operatuser operatUser=new Operatuser();
            operatUser.setUname(userName);
            operatUser.setOperatime((parse));
            //获取ip地址
            InetAddress localHost = InetAddress.getLocalHost();
            String hostAddress = localHost.getHostAddress();
            String ipAddr = IpUtil.getIpAddr(request);
            operatUser.setOpratip(ipAddr);
            //添加operatuser表，的信息，方便展示使用
            //opUserService.addOperaUser(operatUser);
            session.setAttribute("operatUser",operatUser);

            //将用户信息存入session，方便在个人中心展示使用
            Htuser htuser = userService.findUserByName(userName);
            System.out.println("登录的user: "+htuser);
            session.setAttribute("htuser",htuser);
            return "mains";
        }else {
           return "index";
        }
    }


}
