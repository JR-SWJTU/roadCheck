package com.swjtu.roadCheck.web.controller;

import com.swjtu.roadCheck.entity.Cardata;
import com.swjtu.roadCheck.entity.CardataExample;
import com.swjtu.roadCheck.mapper.CardataMapper;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/cardata")
@ResponseBody
public class CarController {

    @Resource
    private CardataMapper cardataMapper;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(@RequestBody Cardata cardata){

        cardataMapper.insert(cardata);
        return JsonResult.build(StatusCode.SUCCESS);
    }
}
