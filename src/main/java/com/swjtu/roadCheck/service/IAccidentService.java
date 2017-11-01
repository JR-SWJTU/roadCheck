package com.swjtu.roadCheck.service;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.dto.ResMap;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;
import com.swjtu.roadCheck.entityCustom.BlackPointDataForWeb;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/20.
 */
public interface IAccidentService {

    /**
     * 黑点分析
     * 获取所有行政区
     * @return
     */
    List<String> getRegions();


    /**
     * 返回事故当量排名前10%
     * @param map
     * @return
     */
    List<BlackPointDataForWeb> getTopTen(Map<String, Object> map);

    /**
     * 导出数据
     * @param map
     * @return
     */
    String exportAccidentData(Map<String,Object> map);

    /**
     * 空间分析，多条件符合查询
     * @param condition
     * @return
     */
    List<Accident> areaMultiConditionQuery(AccidentQueryCondition condition) throws Exception;

    /**
     * 导出空间分析结果
     * @param condition
     * @throws Exception
     */
    String exportAreaAnalyse(AccidentQueryCondition condition, HttpServletResponse res) throws Exception;

    /**
     * 时间分析，多条件符合查询
     * @param condition
     * @return
     */
    List<Accident> timeMultiConditionQuery(AccidentQueryCondition condition) throws Exception;

    /**
     * 查询某大队、某个地区或某个地点发生的事故总数
     * @param condition
     * @return
     */
    Integer areaTotalAccidentNumsQuery(AccidentQueryCondition condition) throws Exception;

    /**
     * 查询某大队、某个地区或某个地点各个严重程度的事故的数量
     * @param condition
     * @return
     */
    List<ResMap> queryAreaTotalAccidentNumsForYZCD(AccidentQueryCondition condition) throws Exception;

    /**
     * 查询某大队、某个地区或某个地点各个事故类型的事故的数量
     * @param condition
     * @return
     */
    List<ResMap> queryAreaTotalAccidentNumsForSGType(AccidentQueryCondition condition) throws Exception;

    /**
     * 查询某大队、某个地区或某个地点各个天气类型的事故的数量
     * @param condition
     * @return
     */
    List<ResMap> queryAreaTotalAccidentNumsSGWeather(AccidentQueryCondition condition) throws Exception;

    /**
     *  查询某大队、某个地区或某个地点各个车辆类型的事故数量
     * @param condition
     * @return
     */
    List<ResMap> queryAreaTotalAccidentNumsSGCarType(AccidentQueryCondition condition) throws Exception;

    /**
     * 获取所有事故交叉口
     * @return
     */
    List<String> queryCrossings();

    /**
     * 获取所有非交叉口
     * @return
     */
    List<String> queryOrdinaryRoad();

}
