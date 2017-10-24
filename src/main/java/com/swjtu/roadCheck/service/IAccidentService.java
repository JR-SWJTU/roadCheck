package com.swjtu.roadCheck.service;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.entity.Accidentdata;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;
import com.swjtu.roadCheck.entityCustom.BlackPointData;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/20.
 */
public interface IAccidentService {

    List<String> getRegions();

    List<BlackPointData> getTopTen(Map<String, Object> map);

    void exportAccidentData(Map<String,Object> map);

    /**
     * 空间分析，多条件符合查询
     * @param condition
     * @return
     */
    List<Accident> areaMultiConditionQuery(AccidentQueryCondition condition);

    /**
     * 时间分析，多条件符合查询
     * @param condition
     * @return
     */
    List<Accident> timeMultiConditionQuery(AccidentQueryCondition condition);
}
