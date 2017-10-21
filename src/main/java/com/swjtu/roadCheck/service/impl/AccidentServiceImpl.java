package com.swjtu.roadCheck.service.impl;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;
import com.swjtu.roadCheck.mapper.AccidentMapperCustom;
import com.swjtu.roadCheck.service.IAccidentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */
@Service
public class AccidentServiceImpl implements IAccidentService {

    @Resource
    AccidentMapperCustom accidentMapperCustom;

    /**
     * 空间分析，多条件符合查询
     *
     * @param condition
     * @return
     */
    public List<Accident> areaMultiConditionQuery(AccidentQueryCondition condition) {

        return accidentMapperCustom.multiConditionQueryAccident(condition);
    }
}
