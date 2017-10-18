package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.entity.Accidentdata;
import com.swjtu.roadCheck.entity.AccidentdataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccidentdataMapper {
    int countByExample(AccidentdataExample example);

    int deleteByExample(AccidentdataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Accidentdata record);

    int insertSelective(Accidentdata record);

    List<Accidentdata> selectByExampleWithBLOBs(AccidentdataExample example);

    List<Accidentdata> selectByExample(AccidentdataExample example);

    Accidentdata selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Accidentdata record, @Param("example") AccidentdataExample example);

    int updateByExampleWithBLOBs(@Param("record") Accidentdata record, @Param("example") AccidentdataExample example);

    int updateByExample(@Param("record") Accidentdata record, @Param("example") AccidentdataExample example);

    int updateByPrimaryKeySelective(Accidentdata record);

    int updateByPrimaryKeyWithBLOBs(Accidentdata record);

    int updateByPrimaryKey(Accidentdata record);
}