package com.swjtu.roadCheck.web.controller;

import com.swjtu.roadCheck.entity.Cardata;
import com.swjtu.roadCheck.entity.ChenzuoPeopelData;
import com.swjtu.roadCheck.entity.DriverPeoPelData;
import com.swjtu.roadCheck.entity.QitaPeopelData;
import com.swjtu.roadCheck.mapper.ChenzuoPeopelDataMapper;
import com.swjtu.roadCheck.mapper.DriverPeoPelDataMapper;
import com.swjtu.roadCheck.mapper.QitaPeopelDataMapper;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/peopel")
@ResponseBody
public class PeopelController {

    @Resource
    private DriverPeoPelDataMapper driverPeoPelDataMapper;

    @Resource
    private ChenzuoPeopelDataMapper chenzuoPeopelDataMapper;

    @Resource
    private QitaPeopelDataMapper qitaPeopelDataMapper;


    @RequestMapping(value = "/add/driver")
    public JsonResult addDriver(@RequestBody DriverPeoPelData driverPeoPelData){

        driverPeoPelDataMapper.insert(driverPeoPelData);
        return JsonResult.build(StatusCode.SUCCESS);
    }

    @RequestMapping(value = "/add/chezuoren")
    public JsonResult addChezuoren(@RequestBody ChenzuoPeopelData chenzuoPeopelData){

        chenzuoPeopelDataMapper.insert(chenzuoPeopelData);
        return JsonResult.build(StatusCode.SUCCESS);
    }

    @RequestMapping(value = "/add/qitaren")
    public JsonResult addQitaren(@RequestBody QitaPeopelData qitaPeopelData){

        qitaPeopelDataMapper.insert(qitaPeopelData);
        return JsonResult.build(StatusCode.SUCCESS);
    }
}

