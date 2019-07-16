package com.qf.j1902.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.mapper.OperatuserMapper;
import com.qf.j1902.pojo.Operatuser;
import com.qf.j1902.pojo.OperatuserExample;
import com.qf.j1902.service.OpUserService;
import com.qf.j1902.vo.EasyuiResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */
@Service
public class OpUserServiceImpl implements OpUserService {
    @Resource
    private OperatuserMapper opUserMapper;
    @Override
    public int addOperaUser(Operatuser operatUser) {
        int insert = opUserMapper.insert(operatUser);
        return insert;
    }

    @Override
    public EasyuiResult findAll(Integer page, Integer pageSize) {
        EasyuiResult easyuiResult = new EasyuiResult();
        OperatuserExample example = new OperatuserExample();
        //添加查询条件
        OperatuserExample.Criteria criteria = example.createCriteria();

        //sendtime不为空的显示
        criteria.andSendtimeIsNotNull();
      /*  System.out.println("111111111111111");*/

        //添加分页功能
        PageHelper.startPage(page,pageSize);
        //执行查询体
        List<Operatuser> operatuserList = opUserMapper.selectByExample(example);
        //从数据集合中提取分页信息
        PageInfo<Operatuser> pageInfo = new PageInfo<>(operatuserList);
        long total = pageInfo.getTotal();
        easyuiResult.setTotal(total);  //获取总记录数
        easyuiResult.setRows(operatuserList); //设置当前页结果集
        return easyuiResult;
    }

    @Override
    public EasyuiResult findAll(Integer page, Integer pageSize,String title) {
        EasyuiResult easyuiResult = new EasyuiResult();
        OperatuserExample example = new OperatuserExample();
        //添加查询条件
        OperatuserExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(title)){ //如果查询条件非空，则执行该查询方法，否则，全查
            criteria.andUnameLike("%"+title+"%");
        }
      /*  System.out.println("222222222222222222222");*/

        //添加分页功能
        PageHelper.startPage(page,pageSize);
        //执行查询体
        List<Operatuser> operatuserList = opUserMapper.selectByExample(example);
        //从数据集合中提取分页信息
        PageInfo<Operatuser> pageInfo = new PageInfo<>(operatuserList);
        long total = pageInfo.getTotal();
        easyuiResult.setTotal(total);  //获取总记录数
        easyuiResult.setRows(operatuserList); //设置当前页结果集
        return easyuiResult;
    }

    @Override
    public EasyuiResult findAll(Integer page, Integer pageSize, String title, String startime, String endtime) {
        EasyuiResult easyuiResult = new EasyuiResult();
        OperatuserExample example = new OperatuserExample();
        System.out.println("startime:"+startime);
        System.out.println("endtime:"+endtime);
        //添加查询条件
        OperatuserExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(title)){ //如果查询条件非空，则执行该查询方法，否则，全查
            criteria.andUnameLike("%"+title+"%");
        }
        if(!StringUtils.isEmpty(startime) && !StringUtils.isEmpty(endtime)){
            try {

               //传入的字符串 要和输入的字符串要和你想要的格式长度神马的都一样才行

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date stime = sdf.parse(startime.toString());
                Date entime = sdf.parse(endtime);
                System.out.println("limain:"+stime);
                criteria.andOperatimeBetween(stime,entime);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

       /* System.out.println("333333333333333333");*/

        //添加分页功能
        PageHelper.startPage(page,pageSize);
        //执行查询体
        List<Operatuser> operatuserList = opUserMapper.selectByExample(example);
        //从数据集合中提取分页信息
        PageInfo<Operatuser> pageInfo = new PageInfo<>(operatuserList);
        long total = pageInfo.getTotal();
        easyuiResult.setTotal(total);  //获取总记录数
        easyuiResult.setRows(operatuserList); //设置当前页结果集
        return easyuiResult;
    }

    @Override
    public int updateOperaById(Operatuser record) {
        int i = opUserMapper.updateByPrimaryKeySelective(record);
        return i;
    }

    @Override
    public int deleteById(Integer id) {
        int i = opUserMapper.deleteByPrimaryKey(id);
        return i;
    }

}
