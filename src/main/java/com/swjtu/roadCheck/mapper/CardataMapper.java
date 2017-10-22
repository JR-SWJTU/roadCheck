package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.entity.Cardata;
import com.swjtu.roadCheck.entity.CardataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardataMapper {
    int countByExample(CardataExample example);

    int deleteByExample(CardataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cardata record);

    int insertSelective(Cardata record);

    List<Cardata> selectByExampleWithBLOBs(CardataExample example);

    List<Cardata> selectByExample(CardataExample example);

    Cardata selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cardata record, @Param("example") CardataExample example);

    int updateByExampleWithBLOBs(@Param("record") Cardata record, @Param("example") CardataExample example);

    int updateByExample(@Param("record") Cardata record, @Param("example") CardataExample example);

    int updateByPrimaryKeySelective(Cardata record);

    int updateByPrimaryKeyWithBLOBs(Cardata record);

    int updateByPrimaryKey(Cardata record);
}