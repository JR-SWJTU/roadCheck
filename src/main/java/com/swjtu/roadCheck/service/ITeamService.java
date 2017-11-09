package com.swjtu.roadCheck.service;

import com.swjtu.roadCheck.entity.Team;
import com.swjtu.roadCheck.util.PageResult;

import java.util.List;

/**
 * Created by windows on 2017/10/20.
 */
public interface ITeamService {

    List<Team> getAllTeams();

    /**
     * 添加一条大队记录到数据库
     * @param team 大队对象
     */
    public void addTeam( Team team) throws Exception;

    /**
     * 删除大队
     * @param ids 要删除的大队的id的数组
     */
    public void deleteTeam(List ids);

    /**
     * 查询一条大队数据
     * @param id 大队id
     * @return team 一条大队信息
     */
    public Team getTeamById(Integer id);

    /**
     * 分页查询大队信息
     * @param pageNum
     * @param pageSize
     * @return  PageResult 大队信息数组和大队的总条数
     */
    public PageResult getTeamForPage(Integer pageNum, Integer pageSize) ;

    /**
     * 更新大队数据
     * @param team 大队对象
     */
    public void updateTeam(Team team);
}
