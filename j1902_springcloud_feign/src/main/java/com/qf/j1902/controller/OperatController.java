package com.qf.j1902.controller;

import com.qf.j1902.pojo.Operatuser;
import com.qf.j1902.service.RemoteService;
import com.qf.j1902.vo.EasyuiResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/7/14.
 */
@Controller
public class OperatController {
    @Autowired
    private RemoteService remoteService;

    //操作日志页面
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
        if (!StringUtils.isEmpty(startime) && !StringUtils.isEmpty(endtime)) {
            all = remoteService.findOperats1(page, rows, title, startime, endtime);
        } else {
            all = remoteService.findOperats2(page, rows, title);
        }
        return all;
    }

    //消息管理页面
    @RequestMapping("/gotidings")
    @ResponseBody
    public EasyuiResult gotidings(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                  @RequestParam(value = "rows",defaultValue = "10") Integer rows) {

        EasyuiResult all = remoteService.findtidings(page,rows);
        return all;
    }
    //新增系统消息功能
    @RequestMapping("/goaddtidings")
    public String goaddtidings(){
        return "addtidings";
    }

    @RequestMapping("/updatetidings")
    public void updatetidings(@RequestParam("id") Integer id,
                              @RequestParam("utitle") String utitle,
                              @RequestParam("utext") String utext,
                              @RequestParam("utext") String linkage,
                              HttpServletResponse response) throws IOException {
        Integer integer = remoteService.upOpById(id, utitle, utext, linkage);
        PrintWriter out = response.getWriter();
        out.write(""+true);
        out.close();
    }
    //删除operatuser信息
    @RequestMapping("/deltidings")
    public void deltidings(@RequestParam("idv") Integer idv,
                           HttpServletResponse response) throws IOException {
        Integer integer = remoteService.deleteTidById(idv);
        System.out.println("删除operatuser成功："+integer);
        PrintWriter out = response.getWriter();
        out.write(""+true);
        out.close();
    }

    //新增系统消息功能
    @RequestMapping("/gosavetidings")
    public void gosavetidings(@RequestParam("utext") String utext,
                              @RequestParam("linkage") String linkage,
                              @RequestParam("utitle") String utitle,HttpSession session,
                               HttpServletResponse response) throws IOException, ParseException {

        Operatuser operatUser = (Operatuser)session.getAttribute("operatUser");
       /* operatUser.setUtitle(utitle);
        operatUser.setUtext(utext);
        operatUser.setLinkage(linkage);*/

        String uname = operatUser.getUname();
        String opratip = operatUser.getOpratip();
        Integer integer = remoteService.addOperaUser(utext,linkage,utitle,uname,opratip);
        PrintWriter out = response.getWriter();
        out.write(""+true);
        out.close();
    }
}
