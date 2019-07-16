package com.qf.j1902.controller;

import com.google.gson.Gson;
import com.qf.j1902.pojo.Htuser;
import com.qf.j1902.service.RemoteService;
import com.qf.j1902.vo.EasyuiResult;
import com.qf.j1902.vo.UserCeshi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/13.
 */
@Controller
public class UsreController {
    @Autowired
    private RemoteService remoteService;

    @RequestMapping("/loadshuju")
    @ResponseBody
    public List<Htuser> goloadshuju() {
        List<Htuser> all = remoteService.findAll();
       return all;
    }


    //经模糊查询后，重新载入数据
    @RequestMapping("/loadshuju2")
    public void loadshuju2(HttpServletResponse response,
                           @RequestParam("keyword") String keyword,
                           @RequestParam("xuanze") String xuanze) throws IOException {
        List<Htuser> all=null;
        System.out.println("xuanze:"+xuanze);
        if(!"0".equals(xuanze)){
            if(!StringUtils.isEmpty(xuanze)){
                all = remoteService.findAllByTypename(xuanze);
            }
        }else if(StringUtils.isEmpty(keyword)) {
            all = remoteService.findAll();
        }else {
            all = remoteService.findAllByKeyword(keyword);
        }
        String json = new Gson().toJson(all);
        PrintWriter out = response.getWriter();
        out.write(json);
        out.close();
    }

    @RequestMapping("/addUser")
    public void addUser(@RequestParam("uname") String name,
                        @RequestParam("email") String email,
                        @RequestParam("loginName") String loginName,
                        @RequestParam("typename") String typename,
                        HttpServletResponse response) throws IOException {
       remoteService.addUser(name, email, loginName, typename);
        PrintWriter out = response.getWriter();
        out.write(""+true);
        out.close();
    }
    //批量删除管理员资料
    @RequestMapping("/delUser")
    public void delUser(@RequestParam("ids") List<Integer> ids,
                        HttpServletResponse response) throws IOException {
        System.out.println("收到的数组id: "+ids);
        boolean b=false;
        for(Integer id:ids){
          remoteService.delUser(ids);
        }
        PrintWriter out = response.getWriter();
        out.write(""+true);
        out.close();
    }

    //管理员列表membermain.html，修改管理员资料
    @RequestMapping("/updateUser")
    public void updateUser(@RequestParam("uname") String uname,
                           @RequestParam("email") String email,
                           @RequestParam("loginName") String loginName,
                           @RequestParam("typename") String typename,
                           @RequestParam("id") Integer id,
                           HttpServletResponse response) throws IOException {
         remoteService.updateUser(uname, email, loginName, typename, id);
        PrintWriter out = response.getWriter();
        out.write(""+true);
        out.close();
    }
    //角色管理页面
    @RequestMapping("/goroleMmanager")
    @ResponseBody
    public List<UserCeshi> goroleMmanager(){
        Map<String,Integer> map = new HashMap<>();
        List<UserCeshi> list=new ArrayList<>();
        List<Htuser> all =remoteService.findAll();
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
    }

    //修改角色功能
    @RequestMapping("/goupdateRole")
    public String updateRole(@RequestParam("name") String name){
        return "updateRole";
    }
   /* //操作日志页面
    @RequestMapping("/gojournal")
    @ResponseBody
    public EasyuiResult gojournal(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                  @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                                  @RequestParam(value = "title",defaultValue = "") String title,
                                  @RequestParam(value = "startime",defaultValue = "") String startime,
                                  @RequestParam(value = "endtime",defaultValue = "") String endtime) {

        EasyuiResult all = null;
        System.out.println(startime);
        System.out.println(endtime);
        if (!org.apache.commons.lang.StringUtils.isEmpty(startime) && !org.apache.commons.lang.StringUtils.isEmpty(endtime)) {
            all = remoteService.findOperatAll1(page, rows, title, startime, endtime);
        } else {
            all = remoteService.findOperatAll2(page, rows, title);
        }
        return all;
    }*/

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
}
