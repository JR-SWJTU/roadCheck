package com.swjtu.roadCheck;

import com.swjtu.roadCheck.dto.Accident;
import com.swjtu.roadCheck.entity.Accidentdata;
import com.swjtu.roadCheck.entity.Team;
import com.swjtu.roadCheck.entity.TeamExample;
import com.swjtu.roadCheck.entityCustom.BlackPointData;
import com.swjtu.roadCheck.mapper.AccidentMapperCustom;
import com.swjtu.roadCheck.mapper.Accidentdata2Mapper;
import com.swjtu.roadCheck.mapper.TeamMapper;
import com.swjtu.roadCheck.util.ExportExcel;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
       // ExportExcel.excelExport(blackPointDatas, titleMap, sheetName,"/src/main/webapp/","BPResult");
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
         Map<String,Object> conditionMap = new HashMap();
        conditionMap.put("areaName","金牛区");
        conditionMap.put("startTime","2017-10-01");
        conditionMap.put("endTime","2017-10-31");
        conditionMap.put("roadType","交叉口");
        conditionMap.put("troEscape","否");
        conditionMap.put("workPlaceRel","否");
        conditionMap.put("yType",false);
        List<Accident> accidentList = accidentMapperCustom.multiConditionQueryAccidentForTime(conditionMap);
//        List<Accident> accidentList = new ArrayList<Accident>();
//        Accident accident = new Accident();
//        accident.setLng(110.23);
//        accident.setLat(110.23);
//        accident.setDayRes("111");
//        accident.setDead(10);
//        accident.setDiMingBeiZhu("222");
//        accident.setPropertyLoss(5);
//        accident.setSlightInjury(null);
//        accident.setSeverInjury(4);
//        accident.setNum(0);
//        accidentList.add(accident);
         Map<String,String> conditionTitleMap = new HashMap();
         Map<String,String> resultTitleMap = new LinkedHashMap<String, String>();
        conditionTitleMap = getTitleHashMap(conditionMap);
        resultTitleMap.put("diMingBeiZhu","地名");
        if((Boolean) conditionMap.get("yType")){
            resultTitleMap.put("num","总的事故数量");
        }else {
            resultTitleMap.put("propertyLoss","仅财损");
            resultTitleMap.put("slightInjury","轻伤");
            resultTitleMap.put("severInjury","重伤");
            resultTitleMap.put("dead","死亡");
        }

//        ExportExcel.excelExport2(accidentList,resultTitleMap,conditionMap,conditionTitleMap,"sheet1","test2");

    }

    public Map<String,String> getTitleHashMap(Map<String,Object> map){
        Map<String,String> titleMap = new HashMap();
        for(Map.Entry<String, Object> key : map.entrySet()){
            if(key.getKey().equals("teamName") && key.getValue() != null){
                titleMap.put("teamName","大队");
            }else if(key.getKey().equals("areaName") && key.getValue() != null){
                titleMap.put("areaName","行政区");
            }else if(key.getKey().equals("startTime") && key.getValue() != null){
                titleMap.put("startTime","开始日期");
            }else if(key.getKey().equals("endTime") && key.getValue() != null){
                titleMap.put("endTime","结束日期");
            }else if(key.getKey().equals("roadType") && key.getValue() != null){
                titleMap.put("roadType","道路类型");
            }else if(key.getKey().equals("troEscape") && key.getValue() != null){
                titleMap.put("troEscape","是否肇事逃逸");
            }else if(key.getKey().equals("workPlaceRel") && key.getValue() != null){
                titleMap.put("workPlaceRel","是否与作业区相关");
            }else if(key.getKey().equals("roadLevel") && key.getValue() != null){
                titleMap.put("roadLevel","道路等级");
            }else if(key.getKey().equals("carCollisionType") && key.getValue() != null){
                titleMap.put("carCollisionType","车辆碰撞类型");
            }else if(key.getKey().equals("isWorkDay") && key.getValue() != null){
                titleMap.put("isWorkDay","是否工作日");
            }else if(key.getKey().equals("carType") && key.getValue() != null){
                titleMap.put("carType","车辆类型");
            }else if(key.getKey().equals("intersectionType") && key.getValue() != null){
                titleMap.put("intersectionType","交叉口类型");
            }else if(key.getKey().equals("weather") && key.getValue() != null){
                titleMap.put("weather","天气");
            }else if(key.getKey().equals("yType") && key.getValue() != null){
                titleMap.put("yType","y轴数据类型");
            }
        }
        return titleMap;
    }

}
