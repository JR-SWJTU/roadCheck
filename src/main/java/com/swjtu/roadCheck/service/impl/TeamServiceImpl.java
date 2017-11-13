package com.swjtu.roadCheck.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swjtu.roadCheck.entity.Admin;
import com.swjtu.roadCheck.entity.AdminExample;
import com.swjtu.roadCheck.entity.Team;
import com.swjtu.roadCheck.entity.TeamExample;
import com.swjtu.roadCheck.mapper.AdminMapper;
import com.swjtu.roadCheck.mapper.TeamMapper;
import com.swjtu.roadCheck.service.ITeamService;
import com.swjtu.roadCheck.util.PageResult;
import com.swjtu.roadCheck.web.exception.base.CustomException;
import com.swjtu.roadCheck.web.exception.base.ReqParmIncorException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by windows on 2017/10/20.
 */
@Service
public class TeamServiceImpl implements ITeamService {
    @Resource
    private TeamMapper teamMapper;

    public List<Team> getAllTeams() {
        TeamExample teamExample = new TeamExample();
        teamExample.setDistinct(true);
        List<Team> teamList = new ArrayList<Team>();
        teamList = teamMapper.selectByExample(teamExample);
        return teamList;
    }

    /**
     * 添加一条大队记录到数据库
     *
     * @param team 大队对象
     */
    public void addTeam(Team team) throws Exception {
        if(team.getTeamName() == null)
            throw new ReqParmIncorException();

        TeamExample teamExample = new TeamExample();
        teamExample.createCriteria().andTeamNameEqualTo(team.getTeamName());
        if(teamMapper.selectByExample(teamExample).size() != 0){
            throw new CustomException("该大队已经存在");
        }else {
            teamMapper.insert(team);
        }
    }

    /**
     * 删除大队
     *
     * @param ids 要删除的大队的id的数组
     */
    public void deleteTeam(List ids) {
        for(int i = 0 ;  i < ids.size(); i++){
            if(!(ids.get(i) instanceof Long || ids.get(i) instanceof Integer))
                throw new ReqParmIncorException("参数非整型数据");
            teamMapper.deleteByPrimaryKey( (Integer) ids.get(i));
        }
    }

    /**
     * 查询一条大队数据
     *
     * @param id 大队id
     * @return team 一条大队信息
     */
    public Team getTeamById(Integer id) {
        return teamMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询大队信息
     *
     * @param pageNum
     * @param pageSize
     * @return PageResult 大队信息数组和大队的总条数
     */
    public PageResult getTeamForPage(Integer pageNum, Integer pageSize) {
        if(pageNum == null || pageSize == null)
            throw  new CustomException("参数缺失");
        PageHelper.startPage(pageNum, pageSize);
        TeamExample teamExample = new TeamExample();
        List<Team> teams = teamMapper.selectByExample(teamExample);
        PageInfo<Team> pageInfo = new PageInfo<Team>(teams);
        PageResult pageResult = new PageResult();
        pageResult.setRows(teams);
        pageResult.setTotal(pageInfo.getTotal());
        return pageResult;
    }

    /**
     * 更新大队数据
     *
     * @param team 大队对象
     */
    public void updateTeam(Team team) {

        TeamExample teamExample = new TeamExample();
        teamExample.createCriteria().andTeamNameEqualTo(team.getTeamName());
        if(teamMapper.selectByExample(teamExample).size() != 0){
            throw new CustomException("该大队名称已经存在");
        }

        teamMapper.updateByPrimaryKey(team);

    }
}
