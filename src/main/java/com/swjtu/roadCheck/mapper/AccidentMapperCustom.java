package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;

import java.util.List;

/**
 * Created by Administrator on 2017/10/21.
 */
public interface AccidentMapperCustom {

    List<Accident> multiConditionQueryAccident(AccidentQueryCondition condition);

}
