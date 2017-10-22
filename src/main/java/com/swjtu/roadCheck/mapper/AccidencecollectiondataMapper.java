package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.entity.Accidencecollectiondata;
import com.swjtu.roadCheck.entity.AccidencecollectiondataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccidencecollectiondataMapper {
    int countByExample(AccidencecollectiondataExample example);

    int deleteByExample(AccidencecollectiondataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Accidencecollectiondata record);

    int insertSelective(Accidencecollectiondata record);

    List<Accidencecollectiondata> selectByExampleWithBLOBs(AccidencecollectiondataExample example);

    List<Accidencecollectiondata> selectByExample(AccidencecollectiondataExample example);

    Accidencecollectiondata selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Accidencecollectiondata record, @Param("example") AccidencecollectiondataExample example);

    int updateByExampleWithBLOBs(@Param("record") Accidencecollectiondata record, @Param("example") AccidencecollectiondataExample example);

    int updateByExample(@Param("record") Accidencecollectiondata record, @Param("example") AccidencecollectiondataExample example);

    int updateByPrimaryKeySelective(Accidencecollectiondata record);

    int updateByPrimaryKeyWithBLOBs(Accidencecollectiondata record);

    int updateByPrimaryKey(Accidencecollectiondata record);
}