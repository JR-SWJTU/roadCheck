package com.swjtu.roadCheck.web.controller;

import com.swjtu.roadCheck.entity.Accidentdata;
import com.swjtu.roadCheck.mapper.AccidentdataMapper;
import com.swjtu.roadCheck.service.IAccidentService;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @RequestMapping(value = "/analyseData/multiConditionQuery", method = RequestMethod.POST)
    public JsonResult anlMultiConditionQuery(@RequestBody Map map) throws Exception{

        return JsonResult.build(StatusCode.SUCCESS);
    }

    @RequestMapping(value = "/add/accidentdatas",method = RequestMethod.POST)
    public JsonResult addAccidentDatas(@RequestBody Accidentdata accidentdata){
        accidentdataMapper.insert(accidentdata);
        return JsonResult.build(StatusCode.SUCCESS);
    }

}
