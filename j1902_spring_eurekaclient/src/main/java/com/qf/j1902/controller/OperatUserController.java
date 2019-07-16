package com.qf.j1902.controller;


import com.qf.j1902.pojo.Operatuser;
import com.qf.j1902.service.OpUserService;
import com.qf.j1902.vo.EasyuiResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/7/9.
 */
@Controller
public class OperatUserController {

    @Autowired
    private OpUserService opUserService;
   /* @RequestMapping("/gojournal")
    @ResponseBody
    public EasyuiResult gojournal(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                      @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                                      @RequestParam(value = "title",defaultValue = "") String title){

        EasyuiResult all  = opUserService.findAll(page, rows, title);
        return all;
    }*/

   @RequestMapping(value = "/opefindAll1")
   @ResponseBody
   public EasyuiResult findOperatAll1(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                                @RequestParam(value = "title",defaultValue = "") String title,
                                @RequestParam(value = "startime",defaultValue = "") String startime,
                                @RequestParam(value = "endtime",defaultValue = "") String endtime){
       EasyuiResult all = opUserService.findAll(page, rows, title, startime, endtime);
       return all;
   }
   @RequestMapping(value = "/opefindAll2")
   @ResponseBody
   public EasyuiResult findOperatAll2(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                                @RequestParam(value = "title",defaultValue = "") String title){
       EasyuiResult all = opUserService.findAll(page, rows, title);
       return all;
   }

   /* //操作日志页面
    @RequestMapping("/gojournal")
    @ResponseBody
    public EasyuiResult gojournal(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                  @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                                  @RequestParam(value = "title",defaultValue = "") String title,
                                  @RequestParam(value = "startime",defaultValue = "") String startime,
                                  @RequestParam(value = "endtime",defaultValue = "") String endtime){

        EasyuiResult all =null;
        System.out.println(startime);
        System.out.println(endtime);
        if(!StringUtils.isEmpty(startime) && !StringUtils.isEmpty(endtime)){
            all = opUserService.findAll(page, rows, title, startime, endtime);
        }else {
            all  = opUserService.findAll(page, rows, title);
        }
        return all;
    }*/


    //消息管理页面i
    @RequestMapping(value = "/gotid")
    @ResponseBody
    public EasyuiResult findtidings(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "rows",defaultValue = "10") Integer rows){
        EasyuiResult all = opUserService.findAll(page, rows);
        return all;
    }


    //新增系统消息功能
    @RequestMapping(value = "/gosavetidings")
    @ResponseBody
    public Integer gosavetidings(@RequestParam("utext") String utext,
                                 @RequestParam("linkage") String linkage,
                                 @RequestParam("utitle") String utitle,
                                 @RequestParam("uname") String uname,
                                 @RequestParam("opratip") String opratip) throws ParseException {
        Operatuser operatUser=new Operatuser();
        operatUser.setUtitle(utitle);
        operatUser.setUtext(utext);
        operatUser.setLinkage(linkage);
        operatUser.setUname(uname);
        operatUser.setOpratip(opratip);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fortime = df.format(new Date());
        Date parsetime = df.parse(fortime);
        operatUser.setSendtime(parsetime);
        operatUser.setOperatime(parsetime);
        System.out.println(operatUser+"after:::;");

        int i = opUserService.addOperaUser(operatUser);
        return i;
    }

    @RequestMapping(value = "goupoperatuser")
    @ResponseBody
    public Integer updatetidings(@RequestParam("id") Integer id,
                              @RequestParam("utitle") String utitle,
                              @RequestParam("utext") String utext,
                              @RequestParam("linkage") String linkage) {
        Operatuser operatuser = new Operatuser();
        operatuser.setId(id);
        operatuser.setUtext(utext);
        operatuser.setUtitle(utitle);
        operatuser.setLinkage(linkage);
        int i = opUserService.updateOperaById(operatuser);
        return i;
    }

    //删除operatuser信息
    @RequestMapping("/godeltidings")
    @ResponseBody
    public Integer deltidings(@RequestParam("idv") Integer idv,
                           HttpServletResponse response) {
        int i = opUserService.deleteById(idv);
        System.out.println("删除operatuser成功："+i);
        return i;
    }
}
