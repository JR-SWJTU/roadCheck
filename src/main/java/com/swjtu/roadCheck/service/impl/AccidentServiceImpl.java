package com.swjtu.roadCheck.service.impl;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.dto.ResMap;
import com.swjtu.roadCheck.entity.Accidentdata;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;
import com.swjtu.roadCheck.entityCustom.BlackPointData;
import com.swjtu.roadCheck.entityCustom.BlackPointDataForWeb;
import com.swjtu.roadCheck.mapper.AccidentMapperCustom;
import com.swjtu.roadCheck.mapper.Accidentdata2Mapper;
import com.swjtu.roadCheck.service.IAccidentService;
import com.swjtu.roadCheck.util.ExportExcel;
import com.swjtu.roadCheck.util.ObjectUtil;
import com.swjtu.roadCheck.web.exception.base.CustomException;
import com.swjtu.roadCheck.web.exception.base.ReqParmIncorException;
import net.sf.json.JSONArray;
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
        if(map.get("roadType").equals("路段")){
            accidentdatas = accidentdata2Mapper.queryAccidentdataByCondition1(map);
        }else{
            accidentdatas = accidentdata2Mapper.queryAccidentdataByCondition2(map);
        }
        Map<String,Integer> resultMap = new HashMap<String,Integer>();
        for(Accidentdata accidentdata : accidentdatas){
            if(!resultMap.containsKey(accidentdata.getXianqu()+"+"
                    +accidentdata.getDimingbeizhu()+"+"+accidentdata.getLat()+"+"+accidentdata.getLng())){
                resultMap.put(accidentdata.getXianqu()+"+"
                        +accidentdata.getDimingbeizhu()+"+"+accidentdata.getLat()+"+"+accidentdata.getLng(),0);
            }
            int score = 0;
            if(accidentdata.getYanzhongcd().equals("死亡")){
                score = 10;
            }else if(accidentdata.getYanzhongcd().equals("轻伤")|| accidentdata.getYanzhongcd().equals("重伤")){
                score = 5;
            }else if(accidentdata.getYanzhongcd().equals("仅财损")){
                score = 1;
            }
            int s = (Integer) resultMap.get(accidentdata.getXianqu()+"+"
                    +accidentdata.getDimingbeizhu()+"+"+accidentdata.getLat()+"+"+accidentdata.getLng());
            s+=score;
            resultMap.put(accidentdata.getXianqu()+"+"
                    +accidentdata.getDimingbeizhu()+"+"+accidentdata.getLat()+"+"+accidentdata.getLng(),s);
        }

        List<Map.Entry<String, Integer>> resultList = new ArrayList<Map.Entry<String, Integer>>(resultMap.entrySet());
        Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

       return resultList;
    }
    public List<BlackPointDataForWeb> getTopTen(Map<String, Object> map){
        List<Map.Entry<String, Integer>> resultList = getAllAccidentdataByCondition(map);

        int topTenPercent = resultList.size() <= 10 ? resultList.size():(int)Math.floor(resultList.size() * 0.1);
        List<BlackPointDataForWeb> blackPointDataForWebs = new ArrayList<BlackPointDataForWeb>();
        for(int i = 0;i < topTenPercent;i++){
            Map.Entry entry = resultList.get(i);
            BlackPointDataForWeb blackPointDataForWeb = new BlackPointDataForWeb();
            String str = (String)entry.getKey();
            blackPointDataForWeb.setBlackPointName(str.split("\\+")[1]);
            blackPointDataForWeb.setBlackPointRegion(str.split("\\+")[0]);
            blackPointDataForWeb.setLat(Double.parseDouble(str.split("\\+")[2]));
            blackPointDataForWeb.setLng(Double.parseDouble(str.split("\\+")[3]));
            blackPointDataForWeb.setNumber((Integer)entry.getValue());
            blackPointDataForWebs.add(blackPointDataForWeb);

        }
        return blackPointDataForWebs;
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
    public List<Accident> areaMultiConditionQuery(AccidentQueryCondition condition) throws Exception{
        if(condition.getRoadType() == null ||
                condition.getStartTime() == null || condition.getEndTime() == null ||
                (condition.getAreaName() == null && condition.getTeamName() == null))
            throw new ReqParmIncorException("缺少必须参数");

        //查询路段时，需将交叉口类型设为非交叉口
        if(condition.getRoadType().equals("路段"))
            condition.setIntersectionType("非交叉口");

        //大队和辖区的查询不能同时存在
        if(condition.getAreaName() != null && condition.getTeamName() != null)
            throw new ReqParmIncorException("TeamName和AreaName的查询不能同时存在");

        if ( condition.isyType() )
            return accidentMapperCustom.multiConditionQueryAccidentForSGS(ObjectUtil.objectToMap(condition));
        else
            return accidentMapperCustom.multiConditionQueryAccidentForYZCD(ObjectUtil.objectToMap(condition));
    }

    /**
     * 导出空间分析结果
     * @param condition
     * @throws Exception
     */
    public void exportAreaAnalyse(AccidentQueryCondition condition) throws Exception{
        List<Accident> accidentList = areaMultiConditionQuery(condition);
        Map<String,String> titleMap = new LinkedHashMap<String,String>();
        //导出各地点事故数量
        if(condition.isyType()){
            titleMap.put("diMingBeiZhu", "地名");
            titleMap.put("num", "事故数量");
        }
        //导出各地点各严重程度下的事故数量
        else{
            titleMap.put("diMingBeiZhu", "地名");
            titleMap.put("num", "事故数量");
        }

        String sheetName = "信息导出";
        try{
            ExportExcel.excelExport(accidentList, titleMap, sheetName,"空间分析数据");
        }catch (CustomException cex){
            throw new CustomException("信息导出失败");
        }
    }

    /**
     * 时间分析，多条件符合查询
     *
     * @param condition
     * @return
     */
    public List<Accident> timeMultiConditionQuery(AccidentQueryCondition condition) throws  Exception{
        //必须参数要填
        if(condition.getRoadType() == null ||
                condition.getStartTime() == null || condition.getEndTime() == null ||
                (condition.getAreaName() == null && condition.getTeamName() == null) ||
                condition.getTimePrecision() == 0)
            throw new CustomException("缺少必须参数");

        //大队和辖区的查询不能同时存在
        if(condition.getAreaName() != null && condition.getTeamName() != null)
            throw new CustomException("TeamName和AreaName的查询不能同时存在");

        //查询路段时，需将交叉口类型设为非交叉口
        if(condition.getRoadType().equals("路段"))
            condition.setIntersectionType("非交叉口");

        //以事故数为纵轴时，不能设置查询的严重程度
        if(condition.isyType() == true &&
                (condition.getPropertyLoss() != null || condition.getSlightInjury() != null || condition.getSeverInjury() != null || condition.getDead() != null))
            throw  new CustomException("以事故数为纵轴时，不能设置查询的严重程度");

        return accidentMapperCustom.multiConditionQueryAccidentForTime(ObjectUtil.objectToMap(condition));
    }

    /**
     * 查询某大队、某个地区或某个地点发生的事故总数
     *
     * @param condition
     * @return
     */
    public Integer areaTotalAccidentNumsQuery(AccidentQueryCondition condition)  throws Exception{
        if(condition.getTeamName() == null && condition.getAreaName() == null && condition.getRoadType() == null ||
                condition.getStartTime() == null || condition.getEndTime() == null)
            throw new ReqParmIncorException("缺少必须参数");

        if(condition.getAreaName() != null && condition.getRoadType() != null)
            throw new ReqParmIncorException();

        return accidentMapperCustom.areaTotalAccidentNumsQuery(ObjectUtil.objectToMap(condition));
    }

    /**
     * 查询某大队、某个地区或某个地点各个严重程度的事故的数量
     *
     * @param condition
     * @return
     */
    public List<ResMap> queryAreaTotalAccidentNumsForYZCD(AccidentQueryCondition condition)  throws Exception{
        //大队、辖区、地点的查询不能同时存在
        if(condition.getAreaName() != null && condition.getTeamName() != null && condition.getRoadType() != null ||
                condition.getStartTime() == null || condition.getEndTime() == null )
            throw new ReqParmIncorException("TeamName和AreaName的查询不能同时存在");

        List<ResMap> resMap = accidentMapperCustom.queryAreaTotalAccidentNumsForYZCD(ObjectUtil.objectToMap(condition));

        String yanZhongCD[] = {"仅财损","轻伤","重伤","死亡","未知"};
        if(resMap.size() < yanZhongCD.length){
            resMap = singlePointAnalyseAddNulObject(yanZhongCD,resMap);
        }
        return resMap;
    }

    /**
     * 查询某大队、某个地区或某个地点各个事故类型的事故的数量
     *
     * @param condition
     * @return
     */
    public List<ResMap> queryAreaTotalAccidentNumsForSGType(AccidentQueryCondition condition)  throws Exception{
        if(condition.getAreaName() != null && condition.getTeamName() != null && condition.getRoadType() != null ||
                condition.getStartTime() == null || condition.getEndTime() == null )
            throw new ReqParmIncorException("TeamName和AreaName的查询不能同时存在");

        List<ResMap> resMap =  accidentMapperCustom.queryAreaTotalAccidentNumsForSGType(ObjectUtil.objectToMap(condition));
        String sgType[] = {"非碰撞","撞人、撞机动车或其他非固定物","碰撞固定物"};
        if(resMap.size() < sgType.length){
           resMap = singlePointAnalyseAddNulObject(sgType,resMap);
        }
        return resMap;
    }

    /**
     * 查询某大队、某个地区或某个地点各个天气类型的事故的数量
     *
     * @param condition
     * @return
     */
    public List<ResMap> queryAreaTotalAccidentNumsSGWeather(AccidentQueryCondition condition)  throws Exception{
        if(condition.getAreaName() != null && condition.getRoadType() != null)
            throw new ReqParmIncorException();

        List<ResMap> resMap =  accidentMapperCustom.queryAreaTotalAccidentNumsSGWeather(ObjectUtil.objectToMap(condition));
        String weather[] = {"晴天","阴天","雨","雾","雪","冰雹","台风","其它"};
        if(resMap.size() < weather.length){
            resMap = singlePointAnalyseAddNulObject(weather,resMap);
        }
        return resMap;
    }

    /**
     * 查询某大队、某个地区或某个地点各个车辆类型的事故数量
     *
     * @param condition
     * @return
     */
    public List<ResMap> queryAreaTotalAccidentNumsSGCarType(AccidentQueryCondition condition) throws Exception{
        if(condition.getAreaName() != null && condition.getTeamName() != null && condition.getRoadType() != null ||
                condition.getStartTime() == null || condition.getEndTime() == null )
            throw new ReqParmIncorException("TeamName和AreaName的查询不能同时存在");
        List<ResMap> resMap =  accidentMapperCustom.queryAreaTotalAccidentNumsSGCarType(ObjectUtil.objectToMap(condition));
        String carType[] = {"小客车","中客车","大客车","公交","校车","小货车","中货车","大货车","拖挂车","特种车辆","摩托车","非机动车","畜力车"};
        if(resMap.size() < carType.length){
            resMap = singlePointAnalyseAddNulObject(carType,resMap);
        }
        return resMap;
    }

    /**
     * 单点分析时，添加某些事故数量为0的类型进入数据数组中，方便前端操作
     * @param attribute
     * @param resMap
     * @return
     */
    public  List<ResMap> singlePointAnalyseAddNulObject(String attribute[], List<ResMap> resMap){
        int flag = 0;
        int size = resMap.size();
        for(int i = 0; i < attribute.length; i++){
            for(int j = 0; j < size; j++){
                if(resMap.get(j).getKeyRes().equals( attribute[i])){
                    flag = 1;
                    break;
                }
            }
            //当前数据集内部没有该天气对应的数据，则添加进去
            if(flag == 0){
                ResMap temp = new ResMap();
                temp.setKeyRes(attribute[i]);
                temp.setNum(0);
                resMap.add(temp);
            }else{
                flag = 0;
            }
        }
        return resMap;
    }

    public List<String> queryCrossings() {
        List<String> crossingList = new ArrayList<String>();
        crossingList = accidentdata2Mapper.queryCrossing();
        return crossingList;
    }

    public List<String> queryOrdinaryRoad() {
        List<String> rodaList = new ArrayList<String>();
        rodaList = accidentdata2Mapper.quueryOrdinayRoad();
        return rodaList;
    }

}
