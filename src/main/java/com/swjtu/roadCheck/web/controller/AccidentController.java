package com.swjtu.roadCheck.web.controller;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.entity.Accidentdata;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;
import com.swjtu.roadCheck.entityCustom.BlackPointData;
import com.swjtu.roadCheck.entityCustom.BlackPointDataForWeb;
import com.swjtu.roadCheck.mapper.AccidentdataMapper;
import com.swjtu.roadCheck.service.IAccidentService;
import com.swjtu.roadCheck.util.ConfigUtil;
import com.swjtu.roadCheck.util.IPUtil;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
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
        JSONObject jsonObject = new JSONObject();
        List<Accident> list =  accidentService.areaMultiConditionQuery(condition);
        int allnum = 0;
        for(int i = 0 ; i < list.size(); i++){
            allnum += list.get(i).getNum();
        }
        jsonObject.put("arr", list);
        jsonObject.put("allnum",allnum);
        return JsonResult.build(StatusCode.SUCCESS, jsonObject);
    }

    /**
     * 空间分析中的多条件查询结果导出excel
     * @param condition
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/analyseData/areaAnalyseDataExport", method = RequestMethod.POST)
    public JsonResult areaAnalyseDataExport(@RequestBody AccidentQueryCondition condition, HttpServletResponse res) throws Exception{
        condition.setPropertyLoss(1);
        condition.setSlightInjury(1);
        condition.setSeverInjury(1);
        condition.setDead(1);
        System.out.println("导出excel了");

        String fileName = accidentService.exportAreaAnalyse(condition, res);
        String addr = ConfigUtil.ip;
        String fileUrl = "http://" + addr + "/roadCheck/excel/" + fileName;
        System.out.println(fileUrl);
        return JsonResult.build(StatusCode.SUCCESS,fileUrl);
    }

    /**
     * 时间分析中的多条件查询特定地点的事故数或者各个不同严重程度下的事故数量或者事故数量统计，按年月日进行统计
     * @param condition
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/analyseData/timeMultiConditionQuery", method = RequestMethod.POST)
    public JsonResult timeMultiConditionQuery(@RequestBody AccidentQueryCondition condition) throws Exception{
        JSONObject jsonObject = new JSONObject();
        List<Accident> list =  accidentService.timeMultiConditionQuery(condition);
        int allnum = 0;
        for(int i = 0 ; i < list.size(); i++){
            allnum += list.get(i).getNum();
        }
        jsonObject.put("arr", list);
        jsonObject.put("allnum",allnum);
        return JsonResult.build(StatusCode.SUCCESS, jsonObject);
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
        List<BlackPointDataForWeb> blackPointDataForWebs = new ArrayList<BlackPointDataForWeb>();
        blackPointDataForWebs = accidentService.getTopTen(map);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("arr",blackPointDataForWebs);
        int number = 0;
        for(BlackPointDataForWeb blackPointDataForWeb:blackPointDataForWebs){
            number+=blackPointDataForWeb.getNumber().intValue();
        }
        jsonObject.put("allnum",number);
        return JsonResult.build(StatusCode.SUCCESS,jsonObject);
    }

    @RequestMapping(value = "/blackPointDiagnosis/exportaion", method = RequestMethod.POST)
    public JsonResult exportBlackPoint(@RequestBody Map map) throws Exception{
        List<BlackPointData> blackPointDatas = new ArrayList<BlackPointData>();
        String fileName = accidentService.exportAccidentData(map);
        String addr = ConfigUtil.ip;
        String fileUrl = "http://" + addr + "/roadCheck/excel/" + fileName;
        System.out.println(fileUrl);
        return JsonResult.build(StatusCode.SUCCESS,fileUrl);
    }

    @RequestMapping(value = "/blackPointDiagnosis/crossings", method = RequestMethod.GET)
    public JsonResult getCrossings() throws Exception{
        List<String> crossingsList = accidentService.queryCrossings();
        return JsonResult.build(StatusCode.SUCCESS,crossingsList);
    }

    @RequestMapping(value = "/blackPointDiagnosis/ordinaryRoads", method = RequestMethod.GET)
    public JsonResult getOrdinaryRoads() throws Exception{
        List<String> roadsList = accidentService.queryOrdinaryRoad();
        return JsonResult.build(StatusCode.SUCCESS,roadsList);
    }

}
