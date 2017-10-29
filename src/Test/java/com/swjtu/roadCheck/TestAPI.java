package com.swjtu.roadCheck;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.entity.*;
import com.swjtu.roadCheck.entityCustom.BlackPointData;
import com.swjtu.roadCheck.mapper.*;
import com.swjtu.roadCheck.util.ExportExcel;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import com.swjtu.roadCheck.web.exception.base.CustomException;

import org.apache.commons.collections.map.HashedMap;
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
        ArrayList<String> teamName = new ArrayList<String>();

//        teamName.add("一大队");
//        teamName.add("二大队");
//        teamName.add("三大队");
//        teamName.add("四大队");
//        map.put("teamName",teamName);

        map.put("roadType","交叉口");
        map.put("areaName","金牛区");
        map.put("startTime","2017-10-01");
        map.put("endTime","2017-10-31");
        accidentdatas = accidentdata2Mapper.queryAccidentdataByCondition2(map);
        System.out.println("============="+accidentdatas.size());
        Map<String,Integer> resultMap = new HashMap<String,Integer>();
        for(Accidentdata accidentdata : accidentdatas){
            if(!resultMap.containsKey(accidentdata.getXianqu()+"+"
                    +accidentdata.getDimingbeizhu()+"+"+accidentdata.getLat()+"+"+accidentdata.getLng())){
                resultMap.put(accidentdata.getXianqu()+"+"
                        +accidentdata.getDimingbeizhu()+"+"+accidentdata.getLat()+"+"+accidentdata.getLng(),0);
            }
            int score = 0;
            if(accidentdata.getYanzhongcd().equals("死亡")){
                score = 10;
            }else if(accidentdata.getYanzhongcd().equals("轻伤")|| accidentdata.getYanzhongcd().equals("重伤")){
                score = 5;
            }else if(accidentdata.getYanzhongcd().equals("仅财损")){
                score = 1;
            }
            int s = (Integer) resultMap.get(accidentdata.getXianqu()+"+"
                    +accidentdata.getDimingbeizhu()+"+"+accidentdata.getLat()+"+"+accidentdata.getLng());
            s+=score;
            resultMap.put(accidentdata.getXianqu()+"+"
                    +accidentdata.getDimingbeizhu()+"+"+accidentdata.getLat()+"+"+accidentdata.getLng(),s);
        }
        System.out.println(resultMap.size());

        List<Map.Entry<String, Integer>> resultList = new ArrayList<Map.Entry<String, Integer>>(resultMap.entrySet());
        Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int topTenPercent = resultList.size() <= 10 ? resultList.size():(int)Math.floor(resultList.size() * 0.1);
        List<BlackPointData> blackPointDatas = new ArrayList<BlackPointData>();
        for(int i = 0;i < topTenPercent;i++){
            Map.Entry entry = resultList.get(i);
            BlackPointData blackPointData = new BlackPointData();
            String str = (String)entry.getKey();
            blackPointData.setBlackPointName(str.split("\\+")[1]);
            blackPointData.setBlackPointRegion(str.split("\\+")[0]);
            blackPointData.setNumber((Integer)entry.getValue());
            blackPointDatas.add(blackPointData);
        }
        for(BlackPointData blackPointData:blackPointDatas){
            System.out.println(blackPointData);
        }

    }


    @Test
    public void testExcelExport(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
        Accidentdata2Mapper accidentdata2Mapper = ctx.getBean(Accidentdata2Mapper.class);
        List<BlackPointData> blackPointDatas = new ArrayList<BlackPointData>();
        List<Accidentdata> accidentdatas = new ArrayList<Accidentdata>();
        Map<String,Object> map = new HashMap<String,Object>();
        ArrayList<String> teamName = new ArrayList<String>();


        map.put("roadType","交叉口");
        map.put("areaName","金牛区");
        map.put("startTime","2017-10-01");
        map.put("endTime","2017-10-31");
        accidentdatas = accidentdata2Mapper.queryAccidentdataByCondition2(map);
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
        String sheetName = "查询结果";
        /**模拟数据结束*/

        System.out.println("start导出");
        long start = System.currentTimeMillis();
        ExportExcel.excelExport(blackPointDatas, titleMap, sheetName,"BPResult");
        long end = System.currentTimeMillis();
        System.out.println("end导出");
        System.out.println("耗时："+(end-start)+"ms");
    }

    @Test
    public void testRoadsOrCrossings(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
        Accidentdata2Mapper accidentdata2Mapper = ctx.getBean(Accidentdata2Mapper.class);

        List<String> roadsList = new ArrayList<String>();
        roadsList = accidentdata2Mapper.quueryOrdinayRoad();
        for (String s  : roadsList){
            System.out.println(s);
        }
    }

    @Test
    public void testExport2(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
         AccidentMapperCustom accidentMapperCustom = ctx.getBean(AccidentMapperCustom.class);
         Map<String,Object> map = new HashMap();
         /*
         "areaName": "金牛区",

    "startTime": "2017-10-01",
    "endTime": "2017-10-31",
    "roadType":"交叉口",
    "troEscape":"否",
    "workPlaceRel":"否",

    "yType": false
          */
         map.put("areaName","金牛区");
         map.put("startTime","2017-10-01");
         map.put("endTime","2017-10-31");
         map.put("roadType","交叉口");
         map.put("troEscape","否");
         map.put("workPlaceRel","否");
         map.put("yType",true);
         List<Accident> accidentList = accidentMapperCustom.multiConditionQueryAccidentForTime(map);
         Map<String,Object> titleMap = new HashMap();
         titleMap.put("teamName","大队");
         titleMap.put("areaName","行政区");
         titleMap.put("startTime","开始日期");
         titleMap.put("endTime","结束日期");
         titleMap.put("roadType","道路类型");
         titleMap.put("troEscape","是否肇事逃逸");
         titleMap.put("workPlaceRel","是否与作业区相关");
         titleMap.put("roadLevel","道路等级");
         titleMap.put("carCollisionType","车辆碰撞类型");
         titleMap.put("isWorkDay","是否工作日");
         titleMap.put("carType","车辆类型");
         titleMap.put("intersectionType","交叉口类型");
         titleMap.put("weather","天气");
         titleMap.put("diMingBeiZhu","地名备注");
         titleMap.put("num","总数");
         List<AccidentDataCollectionByNumber> accidentDataCollectionByNumberList = new ArrayList<AccidentDataCollectionByNumber>();

    }

    class AccidentDataCollectionByNumber{
        private int num;  //总的事故数量

        private String diMingBeiZhu;   //事故发生所在的地名

        private String teamName[];    //大队名称

        private String areaName;    //行政区名称

        private String roadType;    //道路类型，交叉口还是路段

        //    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date startTime;

        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date endTime;

        private String roadLevel;   //道路等级

        private String carCollisionType;    //车辆碰撞类型

        private String weather; //天气

        private String workPlaceRel;    //是否与作业区相关

        private String intersectionType;    //交叉口类型

        private String carType;     //车辆类型

        private String troEscape;   //是否肇事逃逸

        private Integer isWorkDay; //是否工作日

    }

}
