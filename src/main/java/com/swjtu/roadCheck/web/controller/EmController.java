package com.swjtu.roadCheck.web.controller;

import com.swjtu.roadCheck.entity.Emdata;
import com.swjtu.roadCheck.mapper.EmdataMapper;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/emdata")
@ResponseBody
public class EmController {
    @Resource
    private EmdataMapper emdataMapper;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(@RequestBody Emdata emdata){
        emdataMapper.insert(emdata);
        return JsonResult.build(StatusCode.SUCCESS);
    }
}
