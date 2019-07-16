package com.qf.j1902.mapper;

import com.qf.j1902.pojo.Operatuser;
import com.qf.j1902.pojo.OperatuserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OperatuserMapper {
    int countByExample(OperatuserExample example);

    int deleteByExample(OperatuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Operatuser record);

    int insertSelective(Operatuser record);

    List<Operatuser> selectByExample(OperatuserExample example);

    Operatuser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Operatuser record, @Param("example") OperatuserExample example);

    int updateByExample(@Param("record") Operatuser record, @Param("example") OperatuserExample example);

    int updateByPrimaryKeySelective(Operatuser record);

    int updateByPrimaryKey(Operatuser record);


}