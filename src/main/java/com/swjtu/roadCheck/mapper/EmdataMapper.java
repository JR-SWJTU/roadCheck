package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.entity.Emdata;
import com.swjtu.roadCheck.entity.EmdataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmdataMapper {
    int countByExample(EmdataExample example);

    int deleteByExample(EmdataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Emdata record);

    int insertSelective(Emdata record);

    List<Emdata> selectByExampleWithBLOBs(EmdataExample example);

    List<Emdata> selectByExample(EmdataExample example);

    Emdata selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Emdata record, @Param("example") EmdataExample example);

    int updateByExampleWithBLOBs(@Param("record") Emdata record, @Param("example") EmdataExample example);

    int updateByExample(@Param("record") Emdata record, @Param("example") EmdataExample example);

    int updateByPrimaryKeySelective(Emdata record);

    int updateByPrimaryKeyWithBLOBs(Emdata record);
}