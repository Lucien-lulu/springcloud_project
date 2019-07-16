package com.qf.j1902.controller;
import com.qf.j1902.pojo.Htuser;
import com.qf.j1902.pojo.Operatuser;
import com.qf.j1902.service.RemoteService;
import com.qf.j1902.utils.ImgCode;
import com.qf.j1902.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/7/13.
 */
@Controller
public class LoginController {
    @Autowired
    private RemoteService remoteService;

    @RequestMapping(value = "/gologin",method = RequestMethod.POST)
    public String gologin(@RequestParam("userName") String userName,
                          @RequestParam("userPwd") String userPwd,
                          HttpSession session, HttpServletRequest request,
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
            Integer addjournal = remoteService.addjournal(userName);
            session.setAttribute("operatUser",operatUser);

            //将用户信息存入session，方便在个人中心展示使用
            Htuser htuser = remoteService.findUserByName(userName);
            System.out.println("登录的user: "+htuser);
            session.setAttribute("htuser",htuser);
            return "mains";
        }else {
            return "index";
        }
    }
    //验证码
    @RequestMapping(value = "/getImage",method = RequestMethod.GET)
    public void getVerify(HttpServletRequest request, HttpServletResponse response){
        ImgCode imgCode = new ImgCode();
        imgCode.getRandcode(request,response);
    }
    @RequestMapping("/goforgetPw")
    public String forgetPw(){
        return "forgetPw";
    }
}
