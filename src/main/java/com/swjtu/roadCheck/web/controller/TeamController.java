package com.swjtu.roadCheck.web.controller;

import com.google.gson.Gson;
import com.swjtu.roadCheck.entity.Admin;
import com.swjtu.roadCheck.entity.Team;
import com.swjtu.roadCheck.service.ITeamService;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by windows on 2017/10/20.
 */
@Controller
@RequestMapping("/teams")
@ResponseBody
public class TeamController {


    @Resource
    private ITeamService teamService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public JsonResult getAllTeams() throws  Exception{
        List<Team> teamList = teamService.getAllTeams();
        return JsonResult.build(StatusCode.SUCCESS,teamList);
    }
}
