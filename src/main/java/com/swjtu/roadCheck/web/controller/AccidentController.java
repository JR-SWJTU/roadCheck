package com.swjtu.roadCheck.web.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.swjtu.roadCheck.entity.Accidentdata;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;
import com.swjtu.roadCheck.entityCustom.BlackPointData;
import com.swjtu.roadCheck.mapper.AccidentdataMapper;
import com.swjtu.roadCheck.service.IAccidentService;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/20.
 */
@Controller
@RequestMapping("/accidentDatas")
@ResponseBody
public class AccidentController {
    @Resource
    private AccidentdataMapper accidentdataMapper;
    @Resource
    IAccidentService accidentService;

    /**
     * 空间分析中的多条件查询特定地点的事故数或者各个不同严重程度下的事故数量
     * @param condition
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/analyseData/areaMultiConditionQuery", method = RequestMethod.POST)
    public JsonResult areaMultiConditionQuery(@RequestBody AccidentQueryCondition condition) throws Exception{
        return JsonResult.build(StatusCode.SUCCESS, accidentService.areaMultiConditionQuery(condition));
    }

    /**
     * 时间分析中的多条件查询特定地点的事故数或者各个不同严重程度下的事故数量或者事故数量统计，按年月日进行统计
     * @param condition
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/analyseData/timeMultiConditionQuery", method = RequestMethod.POST)
    public JsonResult timeMultiConditionQuery(@RequestBody AccidentQueryCondition condition) throws Exception{
        System.out.println(new Gson().toJson(condition));
        return JsonResult.build(StatusCode.SUCCESS, accidentService.timeMultiConditionQuery(condition));
    }

    /**
     * 数据分析，单点分析功能
     * @param condition
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/analyseData/singlePointAnalyseDataQuery", method = RequestMethod.POST)
    public JsonResult singlePointAnalyseDataQuery(@RequestBody AccidentQueryCondition condition) throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalNum", accidentService.areaTotalAccidentNumsQuery(condition));
        jsonObject.put("severity", accidentService.queryAreaTotalAccidentNumsForYZCD(condition));
        jsonObject.put("accidentType", accidentService.queryAreaTotalAccidentNumsForSGType(condition));
        jsonObject.put("weather", accidentService.queryAreaTotalAccidentNumsSGWeather(condition));
        jsonObject.put("carType", accidentService.queryAreaTotalAccidentNumsSGCarType(condition));
        return  JsonResult.build(StatusCode.SUCCESS, jsonObject);
    }

    @RequestMapping(value = "/add/accidentdatas",method = RequestMethod.POST)
    public JsonResult addAccidentDatas(@RequestBody Accidentdata accidentdata){
        accidentdataMapper.insert(accidentdata);
        return JsonResult.build(StatusCode.SUCCESS);
    }

    @RequestMapping(value = "/blackPointDiagnosis/regions", method = RequestMethod.GET)
    public JsonResult getAllRegions() throws Exception{
        List<String> regions = accidentService.getRegions();
        return JsonResult.build(StatusCode.SUCCESS,regions);
    }

    @RequestMapping(value = "/blackPointDiagnosis/results", method = RequestMethod.POST)
    public JsonResult analyseBlackPoint(@RequestBody Map map) throws Exception{
        List<BlackPointData> blackPointDatas = new ArrayList<BlackPointData>();
        blackPointDatas = accidentService.getTopTen(map);
        return JsonResult.build(StatusCode.SUCCESS,blackPointDatas);
    }

    @RequestMapping(value = "/blackPointDiagnosis/exportaion", method = RequestMethod.POST)
    public JsonResult exportBlackPoint(@RequestBody Map map) throws Exception{
        List<BlackPointData> blackPointDatas = new ArrayList<BlackPointData>();
        accidentService.exportAccidentData(map);
        return JsonResult.build(StatusCode.SUCCESS);
    }
}
