package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.dto.ResMap;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/21.
 */
public interface AccidentMapperCustom {

    List<Accident> multiConditionQueryAccidentForSGS(Map<String,Object> condition);

    List<Accident> multiConditionQueryAccidentForYZCD(Map<String,Object> condition);

    List<Accident> multiConditionQueryAccidentForTime(Map<String,Object> condition);

    Integer areaTotalAccidentNumsQuery(Map<String,Object> condition);

    List<ResMap> queryAreaTotalAccidentNumsForYZCD(Map<String,Object> condition);

    List<ResMap> queryAreaTotalAccidentNumsForSGType(Map<String,Object> condition);

    List<ResMap> queryAreaTotalAccidentNumsSGWeather(Map<String,Object> condition);

    List<ResMap> queryAreaTotalAccidentNumsSGCarType(Map<String,Object> condition);

}
