package com.qf.j1902.controller;

import com.google.gson.Gson;
import com.qf.j1902.pojo.Htuser;
import com.qf.j1902.service.UserService;
import com.qf.j1902.vo.UserCeshi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/3.
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    //初始载入数据至membermain,html，管理列表的数据展示
    @RequestMapping("/goloadshuju")
    @ResponseBody
    public List<Htuser> loadshuju() {
        List<Htuser> all = userService.findAll();
       return all;
    }
    @RequestMapping("/loadshuju21")
    @ResponseBody
    public  List<Htuser> loadshuju21(@RequestParam("xuanze") String xuanze){
        List<Htuser> all = userService.findAllByTypename(xuanze);
        return all;
    }
    @RequestMapping("/loadshuju22")
    @ResponseBody
    public  List<Htuser> loadshuju22(@RequestParam("keyword") String keyword){
        List<Htuser> all = userService.findAllByKeyword(keyword);
        return all;
    }


   /* //经模糊查询后，重新载入数据
    @RequestMapping("/goloadshuju2")
    public void loadshuju2(HttpServletResponse response,
                           @RequestParam("keyword") String keyword,
                           @RequestParam("xuanze") String xuanze) throws IOException {
        List<Htuser> all=null;
        System.out.println("xuanze:"+xuanze);
        if(!"0".equals(xuanze)){
            if(!StringUtils.isEmpty(xuanze)){
                all = userService.findAllByTypename(xuanze);
            }
        }else if(StringUtils.isEmpty(keyword)) {
            all = userService.findAll();
        }else {
            all = userService.findAllByKeyword(keyword);
        }
        String json = new Gson().toJson(all);
        PrintWriter out = response.getWriter();
        out.write(json);
        out.close();
    }*/

    //添加管理列表的管理员资料
    @RequestMapping("/goaddUser")
    public void addUser(@RequestParam("uname") String name,
                        @RequestParam("email") String email,
                        @RequestParam("loginName") String loginName,
                        @RequestParam("typename") String typename,
                        HttpServletResponse response) throws IOException {
        Htuser user=new Htuser();
        user.setUname(name);
        user.setUpw("123");
        user.setLoginName(loginName);
        user.setTypename(typename);
        user.setEmail(email);
        System.out.println("aaaaa:"+user);
        boolean b = userService.addUser(user);
        System.out.println(b);
    }
    //批量删除管理员资料
    @RequestMapping("/godelUser")
    public void delUser(@RequestParam("ids") List<Integer> ids,
                        HttpServletResponse response) throws IOException {
        System.out.println("收到的数组id: "+ids);
        boolean b=false;
        for(Integer id:ids){
            b = userService.delUser(id);
        }
        PrintWriter out = response.getWriter();
        out.write(""+b);
        out.close();
    }
    //管理员列表membermain.html，修改管理员资料
    @RequestMapping("/goupdateUser")
    public void updateUser(@RequestParam("uname") String uname,
                           @RequestParam("email") String email,
                           @RequestParam("loginName") String loginName,
                           @RequestParam("typename") String typename,
                           @RequestParam("id") Integer id) throws IOException {
        Htuser htuser = new Htuser();
        htuser.setId(id);
        htuser.setUname(uname);
        htuser.setTypename(typename);
        htuser.setLoginName(loginName);
        htuser.setEmail(email);
        boolean b = userService.updateUser(htuser);
        System.out.println(b);

    }
    //载入个人中心的个人资料
    @RequestMapping("/loadpersonal")
    @ResponseBody
    public Htuser loadpersonal( HttpSession session,
                              HttpServletResponse response,Model model) throws IOException {
        Htuser htuser = (Htuser) session.getAttribute("htuser");
        System.out.println("daozhele......."+htuser);
        model.addAttribute("htuser",htuser);
       /* PrintWriter out = response.getWriter();
        out.write(""+true);
        out.close();*/
        System.out.println(htuser+"5566");
        return htuser;
    }

    //实验跳转controoer获取值得方法
    @RequestMapping("/goperson_center")
    public String loadperson( HttpSession session,
                                HttpServletResponse response,Model model) throws IOException {
        Htuser htuser = (Htuser) session.getAttribute("htuser");
        System.out.println("daozhele......."+htuser);
        model.addAttribute("htuser",htuser);
       /* PrintWriter out = response.getWriter();
        out.write(""+true);
        out.close();*/
        return "person_center";
    }



    //修改个人中心的管理员密码
    @RequestMapping("/updatepw")
    public void updatemima(@RequestParam("oldpw") String oldpw,
                           @RequestParam("newpw") String newpw,
                           HttpSession session,
                           HttpServletResponse response) throws IOException {
        System.out.println("old:"+oldpw);
        System.out.println("new: "+newpw);
        Htuser htuser = (Htuser) session.getAttribute("htuser");
        String uname = htuser.getUname();
      /*  System.out.println("改密码的uname:"+uname);*/
        boolean b = userService.updatemima(uname, newpw);
        PrintWriter out = response.getWriter();
        out.write(""+b);
        out.close();
    }
   /* //角色管理页面
    @RequestMapping("/gotoroleMmanager")
    @ResponseBody
    public List<UserCeshi> goroleMmanager(){
        Map<String,Integer> map = new HashMap<>();
        List<UserCeshi> list=new ArrayList<>();
        List<Htuser> all = userService.findAll();
        for(Htuser user: all ){
            if(map.containsKey(user.getTypename())){
                int i = map.get(user.getTypename());
                i++;
                map.remove(user.getTypename());
                map.put(user.getTypename(), i);
            }else{
                map.put(user.getTypename(), 1);
            }
        }
        for(Map.Entry<String,Integer> m:map.entrySet()){
            list.add(new UserCeshi(m.getKey(),m.getValue()));
        }
        System.out.println("llll  "+list);
        return list;
    }*/

    //添加角色功能
    @RequestMapping("/addRole")
    public Htuser addrole(@RequestParam("id") Integer id){
        System.out.println(id);
        return null;
    }

}


