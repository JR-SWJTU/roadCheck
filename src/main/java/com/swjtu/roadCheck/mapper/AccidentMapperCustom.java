package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.dto.ResMap;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;

import java.util.List;

/**
 * Created by Administrator on 2017/10/21.
 */
public interface AccidentMapperCustom {

    List<Accident> multiConditionQueryAccidentForSGS(AccidentQueryCondition condition);

    List<Accident> multiConditionQueryAccidentForYZCD(AccidentQueryCondition condition);

    List<Accident> multiConditionQueryAccidentForTime(AccidentQueryCondition condition);

    Integer areaTotalAccidentNumsQuery(AccidentQueryCondition condition);

    List<ResMap> queryAreaTotalAccidentNumsForYZCD(AccidentQueryCondition condition);

    List<ResMap> queryAreaTotalAccidentNumsForSGType(AccidentQueryCondition condition);

    List<ResMap> queryAreaTotalAccidentNumsSGWeather(AccidentQueryCondition condition);

    List<ResMap> queryAreaTotalAccidentNumsSGCarType(AccidentQueryCondition condition);

}
