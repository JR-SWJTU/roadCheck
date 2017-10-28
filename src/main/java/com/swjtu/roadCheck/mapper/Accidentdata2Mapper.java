package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.entity.Accidentdata;
import com.swjtu.roadCheck.entity.AccidentdataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Accidentdata2Mapper {

    List<String> getRegionList();

    List<Accidentdata> queryAccidentdataByCondition1(Map<String,Object> map);

    List<Accidentdata> queryAccidentdataByCondition2(Map<String,Object> map);

    List<String> queryCrossing();

    List<String> quueryOrdinayRoad();
}