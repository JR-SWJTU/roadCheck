package com.swjtu.roadCheck.web.controller;

import com.google.gson.Gson;
import com.swjtu.roadCheck.entity.Admin;
import com.swjtu.roadCheck.mapper.AccidentdataMapper;
import com.swjtu.roadCheck.service.IAdminService;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/10/18.
 */
@Controller
@RequestMapping("admin")
@ResponseBody
public class AdminController {

    @Resource
    private IAdminService adminService;

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public JsonResult register(@RequestBody Admin admin) throws  Exception{
        System.out.println("注册信息：" + new Gson().toJson(admin));
        adminService.register(admin);
        return JsonResult.build(StatusCode.SUCCESS);
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public JsonResult login(@RequestBody Admin admin) throws  Exception{
        adminService.login(admin);
        return JsonResult.build(StatusCode.SUCCESS);
    }

    @RequestMapping(value = "/testlogin",method = RequestMethod.POST)
    public JsonResult testLogin( @RequestBody Admin admin){
       System.out.println("admin:"+admin.toString());
        adminService.register(admin);
        return JsonResult.build(StatusCode.SUCCESS);
    }

}
