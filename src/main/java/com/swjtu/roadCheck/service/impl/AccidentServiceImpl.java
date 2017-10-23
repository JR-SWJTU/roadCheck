package com.swjtu.roadCheck.service.impl;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;
import com.swjtu.roadCheck.entityCustom.BlackPointData;
import com.swjtu.roadCheck.mapper.AccidentMapperCustom;
import com.swjtu.roadCheck.entity.Accidentdata;
import com.swjtu.roadCheck.mapper.Accidentdata2Mapper;
import com.swjtu.roadCheck.service.IAccidentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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

    public List<BlackPointData> getAllAccidentdataByCondition(Map<String, Object> map) {

        List<Accidentdata> accidentdatas = new ArrayList<Accidentdata>();
        accidentdatas = accidentdata2Mapper.queryAccidentdataByCondition(map);
        Map<String,Integer> resultMap = new HashMap<String,Integer>();
        for(Accidentdata accidentdata : accidentdatas){
            if(!resultMap.containsKey(accidentdata.getXianqu())){
                resultMap.put(accidentdata.getXianqu(),0);
            }
            int score = 0;
            if(accidentdata.getYanzhongcd().equals("死亡")){
                score = 10;
            }else if(accidentdata.getYanzhongcd().equals("轻伤")|| accidentdata.getYanzhongcd().equals("重伤")){
                score = 5;
            }else if(accidentdata.getYanzhongcd().equals("仅财损")){
                score = 1;
            }
            int s = (Integer) resultMap.get(accidentdata.getXianqu());
            s+=score;
            resultMap.put(accidentdata.getXianqu(),s);
        }

        List<Map.Entry<String, Integer>> resultList = new ArrayList<Map.Entry<String, Integer>>(resultMap.entrySet());
        Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<BlackPointData> blackPointDatas = new ArrayList<BlackPointData>();
        int topTenPercent = (int)Math.floor(resultList.size() * 0.1);
        for(int i = 0;i < topTenPercent;i++){
            Map.Entry entry = resultList.get(i);
            BlackPointData blackPointData = new BlackPointData();
            String str = (String)entry.getKey();
            blackPointData.setBlackPointName(str.split("\\+")[1]);
            blackPointData.setBlackPointRegion(str.split("\\+")[0]);
            blackPointData.setNumber((Integer)entry.getValue());
            blackPointDatas.add(blackPointData);
        }
        return blackPointDatas;
    }


    /**
     * 空间分析，多条件符合查询
     *
     * @param condition
     * @return
     */
    public List<Accident> areaMultiConditionQuery(AccidentQueryCondition condition) {
        if ( condition.isyType() )
            return accidentMapperCustom.multiConditionQueryAccidentForSGS(condition);
        else
            return accidentMapperCustom.multiConditionQueryAccidentForYZCD(condition);
    }

    /**
     * 时间分析，多条件符合查询
     *
     * @param condition
     * @return
     */
    public List<Accident> timeMultiConditionQuery(AccidentQueryCondition condition) {
        return accidentMapperCustom.multiConditionQueryAccidentForTime(condition);
    }


}
