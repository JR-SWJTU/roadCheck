package com.swjtu.roadCheck.service.impl;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;
import com.swjtu.roadCheck.entityCustom.BlackPointData;
import com.swjtu.roadCheck.mapper.AccidentMapperCustom;
import com.swjtu.roadCheck.entity.Accidentdata;
import com.swjtu.roadCheck.mapper.Accidentdata2Mapper;
import com.swjtu.roadCheck.service.IAccidentService;
import com.swjtu.roadCheck.util.ExportExcel;
import com.swjtu.roadCheck.web.exception.base.CustomException;
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

    public List<Map.Entry<String, Integer>> getAllAccidentdataByCondition(Map<String, Object> map) {

        List<Accidentdata> accidentdatas = new ArrayList<Accidentdata>();
        if(map.get("jckType").equals("路段")){
            accidentdatas = accidentdata2Mapper.queryAccidentdataByCondition1(map);
        }else{
            accidentdatas = accidentdata2Mapper.queryAccidentdataByCondition2(map);
        }
        Map<String,Integer> resultMap = new HashMap<String,Integer>();
        for(Accidentdata accidentdata : accidentdatas){
            if(!resultMap.containsKey(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu())){
                resultMap.put(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu(),0);
            }
            int score = 0;
            if(accidentdata.getYanzhongcd().equals("死亡")){
                score = 10;
            }else if(accidentdata.getYanzhongcd().equals("轻伤")|| accidentdata.getYanzhongcd().equals("重伤")){
                score = 5;
            }else if(accidentdata.getYanzhongcd().equals("仅财损")){
                score = 1;
            }
            int s = (Integer) resultMap.get(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu());
            s+=score;
            resultMap.put(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu(),s);
        }

        List<Map.Entry<String, Integer>> resultList = new ArrayList<Map.Entry<String, Integer>>(resultMap.entrySet());
        Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
       return resultList;
    }
    public List<BlackPointData> getTopTen(Map<String, Object> map){
        List<Map.Entry<String, Integer>> resultList = getAllAccidentdataByCondition(map);
        int topTenPercent = (int)Math.floor(resultList.size() * 0.1);
        List<BlackPointData> blackPointDatas = new ArrayList<BlackPointData>();
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

    public void exportAccidentData(Map<String, Object> map) {
        List<Map.Entry<String, Integer>> resultList = getAllAccidentdataByCondition(map);
        List<BlackPointData> blackPointDatas = new ArrayList<BlackPointData>();
        for(int i = 0;i < resultList.size();i++){
            Map.Entry entry = resultList.get(i);
            BlackPointData blackPointData = new BlackPointData();
            String str = (String)entry.getKey();
            blackPointData.setBlackPointName(str.split("\\+")[1]);
            blackPointData.setBlackPointRegion(str.split("\\+")[0]);
            blackPointData.setNumber((Integer)entry.getValue());
            blackPointDatas.add(blackPointData);
        }

        Map<String,String> titleMap = new LinkedHashMap<String,String>();
        titleMap.put("blackPointRegion", "行政区");
        titleMap.put("blackPointName", "备注");
        titleMap.put("number", "当量");
        String sheetName = "信息导出";
        try{
            ExportExcel.excelExport(blackPointDatas, titleMap, sheetName,"BPResult");
        }catch (CustomException cex){
           throw new CustomException("信息导出失败");
        }
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
