package com.qf.j1902.service;


import com.qf.j1902.pojo.Operatuser;
import com.qf.j1902.vo.EasyuiResult;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */
public interface OpUserService {
    public int addOperaUser(Operatuser operatUser);
    //查询用户信息显示（登录时间，ip地址等）
    //public List<Operatuser> findAll();
   //添加分页的查询
  public EasyuiResult findAll(Integer page, Integer pageSize);

  public EasyuiResult findAll(Integer page, Integer pageSize, String title);

  public EasyuiResult findAll(Integer page, Integer pageSize, String title, String startime,String endtime);

  //根据id修改消息功能
   public int updateOperaById(Operatuser record);

    //根据id删除operatuser表的信息
   public int deleteById(Integer id);


}
