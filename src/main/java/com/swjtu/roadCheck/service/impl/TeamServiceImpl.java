package com.swjtu.roadCheck.service.impl;

import com.swjtu.roadCheck.entity.Team;
import com.swjtu.roadCheck.entity.TeamExample;
import com.swjtu.roadCheck.mapper.TeamMapper;
import com.swjtu.roadCheck.service.ITeamService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
