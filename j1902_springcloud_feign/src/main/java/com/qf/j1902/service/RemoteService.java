package com.qf.j1902.service;


import com.qf.j1902.pojo.Htuser;
import com.qf.j1902.pojo.Operatuser;
import com.qf.j1902.vo.EasyuiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2019/6/27.
 */
@FeignClient(value = "server-provider")
public interface RemoteService {
    @RequestMapping(value="/goloadshuju")
     public List<Htuser> findAll();
    @RequestMapping("/goaddUser")
    public void addUser(@RequestParam("uname") String name,
                          @RequestParam("email") String email,
                          @RequestParam("loginName") String loginName,
                          @RequestParam("typename") String typename);
    @RequestMapping("/godelUser")
    public void delUser(@RequestParam("ids") List<Integer> ids);
    @RequestMapping("/loadshuju21")
    public List<Htuser> findAllByTypename(@RequestParam("xuanze") String xuanze);
    @RequestMapping("/loadshuju22")
    public List<Htuser> findAllByKeyword(@RequestParam("keyword") String keyword);
    @RequestMapping("/goupdateUser")
    public void updateUser(@RequestParam("uname") String uname,
                              @RequestParam("email") String email,
                              @RequestParam("loginName") String loginName,
                              @RequestParam("typename") String typename,
                              @RequestParam("id") Integer id);
    /*@RequestMapping("/gotoroleMmanager")
    public List<UserCeshi> getroleMmanager();*/
    @RequestMapping(value = "/opefindAll1")
    public EasyuiResult findOperats1(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                 @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                                 @RequestParam(value = "title",defaultValue = "") String title,
                                 @RequestParam(value = "startime",defaultValue = "") String startime,
                                 @RequestParam(value = "endtime",defaultValue = "") String endtime);
    @RequestMapping(value = "/opefindAll2")
    public EasyuiResult findOperats2(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                 @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                                 @RequestParam(value = "title",defaultValue = "") String title);
    @RequestMapping(value = "/findUserByName")
    public Htuser findUserByName(@RequestParam("userName") String userName);
    @RequestMapping(value = "/gotid")
    public EasyuiResult findtidings(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "rows",defaultValue = "10") Integer rows);
    @RequestMapping(value = "goupoperatuser")
    public Integer upOpById(@RequestParam("id") Integer id, @RequestParam("utitle") String utitle,
                              @RequestParam("utext") String utext, @RequestParam("linkage") String linkage);
    @RequestMapping("/godeltidings")
    public Integer deleteTidById(@RequestParam("idv") Integer idv);
    @RequestMapping(value = "/gosavetidings")
    public Integer addOperaUser(@RequestParam("utext") String utext,
                                @RequestParam("linkage") String linkage,
                                @RequestParam("utitle") String utitle,
                                @RequestParam("uname") String uname,
                                @RequestParam("opratip") String opratip);
    @RequestMapping("/addjournal")
    public Integer addjournal(@RequestParam("userName") String userName);
}


