package com.swjtu.roadCheck;

import com.swjtu.roadCheck.entity.*;
import com.swjtu.roadCheck.entityCustom.BlackPointData;
import com.swjtu.roadCheck.mapper.Accidentdata2Mapper;
import com.swjtu.roadCheck.mapper.AccidentdataMapper;
import com.swjtu.roadCheck.mapper.AdminMapper;
import com.swjtu.roadCheck.mapper.TeamMapper;
import com.swjtu.roadCheck.util.ExportExcel;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import com.swjtu.roadCheck.web.exception.base.CustomException;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.search.aggregations.metrics.percentiles.hdr.InternalHDRPercentileRanks;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by windows on 2017/10/19.
 */
public class TestAPI {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TestAPI.class);


    @Test
    public void testSelectTeam() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
        TeamMapper teamMapper = ctx.getBean(TeamMapper.class);
        LOGGER.info("测试");
        TeamExample teamExample = new TeamExample();
        teamExample.setDistinct(true);
        List<Team> teamList = new ArrayList<Team>();
        teamList = teamMapper.selectByExample(teamExample);
        for(Team team : teamList){
            System.out.println(team);
        }
    }

    @Test
    public void testConvertTime() {
        String data = "1507532025824";
        long time = Long.parseLong(data);
        if (time > 1) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time);
            System.out.println(calendar.get(Calendar.YEAR));
        }
    }

    @Test
    public void testGetAllRegions(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
        Accidentdata2Mapper accidentdata2Mapper = ctx.getBean(Accidentdata2Mapper.class);

        List<String> accidentdataList = new ArrayList<String>();
        accidentdataList = accidentdata2Mapper.getRegionList();
        for (String s  : accidentdataList){
            System.out.println(s);
        }
    }

    @Test
    public void testQuery(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
        Accidentdata2Mapper accidentdata2Mapper = ctx.getBean(Accidentdata2Mapper.class);
        List<Accidentdata> accidentdatas = new ArrayList<Accidentdata>();
        Map<String,Object> map = new HashMap<String,Object>();
        ArrayList<String> teams = new ArrayList<String>();
        ArrayList<String> regions = new ArrayList<String>();
        regions.add("金牛区");
        regions.add("青羊区");
        regions.add("郫都区");
        teams.add("一大队");
        teams.add("二大队");
        map.put("teams",teams);
        map.put("jckType","非交叉口");
        map.put("regions",regions);
        map.put("startDate","2017-01-01");
        map.put("endDate","2017-10-30");
        accidentdatas = accidentdata2Mapper.queryAccidentdataByCondition1(map);
        Map<String,Integer> resultMap = new HashMap<String,Integer>();
        for(Accidentdata accidentdata : accidentdatas){
            if(!resultMap.containsKey(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu())){
                resultMap.put(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu(),0);
            }
            int score = 0;
            if(accidentdata.getYanzhongcd().equals("死亡")){
                score = 10;
            }else if(accidentdata.getYanzhongcd().equals("轻伤")|| accidentdata.getYanzhongcd().equals("重伤")){
                score = 5;
            }else if(accidentdata.getYanzhongcd().equals("仅财损")){
                score = 1;
            }
            int s = (Integer) resultMap.get(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu());
            s+=score;
            resultMap.put(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu(),s);
        }

        List<Map.Entry<String, Integer>> resultList = new ArrayList<Map.Entry<String, Integer>>(resultMap.entrySet());
        Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(int i = 0;i < resultList.size();i++){
            System.out.println(resultList.get(i));
        }

        Iterator it = resultMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println((String)entry.getKey() + entry.getValue());
        }
    }

    @Test
    public void testExcelExport(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
        Accidentdata2Mapper accidentdata2Mapper = ctx.getBean(Accidentdata2Mapper.class);
        List<BlackPointData> blackPointDatas = new ArrayList<BlackPointData>();
        List<Accidentdata> accidentdatas = new ArrayList<Accidentdata>();
        Map<String,Object> map = new HashMap<String,Object>();
        ArrayList<String> teams = new ArrayList<String>();
        ArrayList<String> regions = new ArrayList<String>();
        regions.add("金牛区");
        regions.add("青羊区");
        regions.add("郫都区");
        teams.add("一大队");
        teams.add("二大队");
        map.put("teams",teams);
        map.put("jckType","非交叉口");
        map.put("regions",regions);
        map.put("startDate","2017-01-01");
        map.put("endDate","2017-10-30");
        accidentdatas = accidentdata2Mapper.queryAccidentdataByCondition1(map);
        Map<String,Integer> resultMap = new HashMap<String,Integer>();
        for(Accidentdata accidentdata : accidentdatas){
            if(!resultMap.containsKey(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu())){
                resultMap.put(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu(),0);
            }
            int score = 0;
            if(accidentdata.getYanzhongcd().equals("死亡")){
                score = 10;
            }else if(accidentdata.getYanzhongcd().equals("轻伤")|| accidentdata.getYanzhongcd().equals("重伤")){
                score = 5;
            }else if(accidentdata.getYanzhongcd().equals("仅财损")){
                score = 1;
            }
            int s = (Integer) resultMap.get(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu());
            s+=score;
            resultMap.put(accidentdata.getXianqu()+"+"+accidentdata.getDimingbeizhu(),s);
        }

        List<Map.Entry<String, Integer>> resultList = new ArrayList<Map.Entry<String, Integer>>(resultMap.entrySet());
        Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(int i = 0;i < resultList.size();i++){
            Map.Entry entry = resultList.get(i);
            BlackPointData blackPointData = new BlackPointData();
            String str = (String)entry.getKey();
            blackPointData.setBlackPointName(str.split("\\+")[1]);
            blackPointData.setBlackPointRegion(str.split("\\+")[0]);
            blackPointData.setNumber((Integer)entry.getValue());
            blackPointDatas.add(blackPointData);
        }

        Map<String,String> titleMap = new LinkedHashMap<String,String>();
        titleMap.put("blackPointRegion", "行政区");
        titleMap.put("blackPointName", "备注");
        titleMap.put("number", "当量");
        String sheetName = "信息导出";
        /**模拟数据结束*/

        System.out.println("start导出");
        long start = System.currentTimeMillis();
        ExportExcel.excelExport(blackPointDatas, titleMap, sheetName,"BPResult");
        long end = System.currentTimeMillis();
        System.out.println("end导出");
        System.out.println("耗时："+(end-start)+"ms");
    }

}
