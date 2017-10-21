package com.swjtu.roadCheck.service.impl;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;
import com.swjtu.roadCheck.mapper.AccidentMapperCustom;
import com.swjtu.roadCheck.entity.Accidentdata;
import com.swjtu.roadCheck.mapper.Accidentdata2Mapper;
import com.swjtu.roadCheck.service.IAccidentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/20.
 */
@Service
public class AccidentServiceImpl implements IAccidentService {

    @Resource
    AccidentMapperCustom accidentMapperCustom;
    @Resource
    private Accidentdata2Mapper accidentdata2Mapper;


    public List<String> getRegions() {
        List<String> regionList = new ArrayList<String>();
        regionList = accidentdata2Mapper.getRegionList();
        return regionList;
    }

    public List<Accidentdata> getAllAccidentdataByCondition(Map<String, Object> map) {

        List<Accidentdata> accidentdatas = new ArrayList<Accidentdata>();
        accidentdatas = accidentdata2Mapper.queryAccidentdataByCondition(map);
        return accidentdatas;
    }


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
