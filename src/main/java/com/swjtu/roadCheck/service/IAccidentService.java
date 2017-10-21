package com.swjtu.roadCheck.service;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */
public interface IAccidentService {
    /**
     * 空间分析，多条件符合查询
     * @param condition
     * @return
     */
    List<Accident> areaMultiConditionQuery(AccidentQueryCondition condition);
}
