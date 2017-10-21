package com.swjtu.roadCheck.web.controller;

import com.swjtu.roadCheck.entity.Accidencecollectiondata;
import com.swjtu.roadCheck.mapper.AccidencecollectiondataMapper;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/accidentcollection")
@ResponseBody
public class AccidentCollectionController {

    @Resource
    private AccidencecollectiondataMapper accidencecollectiondataMapper;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(@RequestBody Accidencecollectiondata accidencecollectiondata){

        accidencecollectiondataMapper.insert(accidencecollectiondata);
        return JsonResult.build(StatusCode.SUCCESS);
    }
}
