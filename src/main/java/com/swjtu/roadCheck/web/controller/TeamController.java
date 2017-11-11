package com.swjtu.roadCheck.web.controller;

import com.swjtu.roadCheck.entity.Team;
import com.swjtu.roadCheck.service.ITeamService;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.PageResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    /**
     * 添加大队信息
     * @param team
     * @return
     * @throws Exception
     */
    @RequestMapping(value="", method = RequestMethod.POST)
    public JsonResult addTeam(@RequestBody Team team) throws Exception{
        teamService.addTeam(team);
        return JsonResult.build(StatusCode.SUCCESS);
    }

    /**批量删除大队*/
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public JsonResult deleteDepartment(@RequestBody Map map) {
        List ids =  (List)map.get("ids");
        teamService.deleteTeam(ids);
        return JsonResult.ok("");
    }

    /**
     * 分页查询大队信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/pageQuery", method = RequestMethod.GET)
    public JsonResult queryTeams(Integer pageNum, Integer pageSize){
        PageResult teams = teamService.getTeamForPage(pageNum, pageSize);
        return JsonResult.build(StatusCode.SUCCESS, teams);
    }

    /**
     * 更新大队信息
     * @param team
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public JsonResult updateTeam(@RequestBody Team team){
        teamService.updateTeam(team);
        return JsonResult.build(StatusCode.SUCCESS);
    }
}
