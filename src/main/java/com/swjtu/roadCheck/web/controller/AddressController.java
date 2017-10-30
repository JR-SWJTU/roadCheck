package com.swjtu.roadCheck.web.controller;


import com.swjtu.roadCheck.entity.*;
import com.swjtu.roadCheck.mapper.*;
import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/address")
@ResponseBody
public class AddressController {

    @Resource
    private AddressMapper addressMapper;
    @Resource
    private AccidencecollectiondataMapper accidencecollectiondataMapper;
    @Resource
    private AccidentdataMapper accidentdataMapper;
    @Resource
    private EmdataMapper emdataMapper;
    @Resource
    private CardataMapper cardataMapper;
    @Resource
    private DriverPeoPelDataMapper driverPeoPelDataMapper;
    @Resource
    private ChenzuoPeopelDataMapper chenzuoPeopelDataMapper;
    @Resource
    private QitaPeopelDataMapper qitaPeopelDataMapper;
    @Resource
    private TeamMapper teamMapper;

    @RequestMapping(value = "/genre", method = RequestMethod.GET)
    public JsonResult start(){
        String[] name = {"一段","二段","三段","四段","五段","六段","七段","八段","九段","十段"};
        String[] shiguType ={"非碰撞,翻车,坠落,火灾,爆炸,淹没,其它非碰撞",
                "撞人、撞机动车或其他非固定物,机动车,行人,摩托车,电动车,自行车,动物,其它非固定物",
                "碰撞固定物,防撞墩/桶,护栏,桥梁栏杆,路缘石,隔离墩,信号灯杆,路灯杆,标志牌柱,树木,其它固定物"};
        String[] carShiguType = {"追尾碰撞","正面碰撞","侧面碰撞","直角碰撞","刮擦","其它"};
        String[] severity = {"仅财损","轻伤","重伤","死亡","未知"};
        String[] intersection = {"非交叉口","十字","T形","Y形","环岛","多路交叉口","立交","其它"};
        double lngIncreament = 0.005f;
        double latIncreament = 0.01f;
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().getAllCriteria();
        List<Address> addressList = new ArrayList<Address>();
        for (int i = 1 ; i <= 10; i++) {
            Address address = new Address();
            address = addressMapper.selectByPrimaryKey(i);
            addressList.add(address);
            System.out.println("addresslist size"+addressList.size());
        }

        /*
        * 开始生成路段数据
        *
        * */
        Accidentdata accidentdata = new Accidentdata();
        Emdata emdata = new Emdata();
        Cardata cardata = new Cardata();
        DriverPeoPelData driverPeoPelData = new DriverPeoPelData();
        ChenzuoPeopelData chenzuoPeopelData = new ChenzuoPeopelData();
        QitaPeopelData qitaPeopelData = new QitaPeopelData();

        accidentdata = accidentdataMapper.selectByPrimaryKey(1);
        emdata = emdataMapper.selectByPrimaryKey(1);
        cardata = cardataMapper.selectByPrimaryKey(1);
        chenzuoPeopelData = chenzuoPeopelDataMapper.selectByPrimaryKey(1);
        driverPeoPelData = driverPeoPelDataMapper.selectByPrimaryKey(1);
        qitaPeopelData = qitaPeopelDataMapper.selectByPrimaryKey(1);

        System.out.println(accidentdata.toString());
        System.out.println(cardata.toString());
        System.out.println(emdata.toString());
        System.out.println(chenzuoPeopelData.toString());
        System.out.println(driverPeoPelData.toString());
        System.out.println(qitaPeopelData.toString());

        int index = 1;
        for (int i = 0 ; i < 10 ;i++) {
            int mm = 1;
            for (int j = 0;j<100;j++) {//每个地点100条数据
                index++;
                Address address = new Address();
                address = addressList.get(i);//获取一个位置
                //address.setName(address.getName()+name[j%10]);//设置新名称
                String placeName = address.getName()+name[j%10];//详细名称
                int teamId = (int)(Math.random()*5+1);//大队编号
                Team team = new Team();
                team = teamMapper.selectByPrimaryKey(teamId);

                int time  = (int)(Math.random()*12);//随机生成时间变化 12个月的
                /*
                * 生成新事故Id
                * */
                String sgId = "";
                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");


                /*
                * 生成新事故数据
                * */
                System.out.println("time-----------------:"+time);
                Accidencecollectiondata accidencecollectiondata = new Accidencecollectiondata();
                date.setTime(date.getTime()-(((teamId*address.getId())%20)*24*60*60*1000));//新时间
                date.setMonth(time);
                sgId = "SG"+simpleDateFormat.format(date)+(int)(Math.random()*10)+(int)(Math.random()*10);//两位随机码
                String name1 = placeName;
               // String name1 = ;
                accidencecollectiondata.setPlace(name1.replace(",","")+"交叉口");
                accidencecollectiondata.setRiqi(date);//设置日期12个月的数据
                accidencecollectiondata.setAccidencenumber(sgId);
                accidencecollectiondata.setShigunumber(sgId);
                accidencecollectiondata.setEnvironmentnumber(sgId);
                accidencecollectiondata.setCarnumber(sgId);
                accidencecollectiondata.setPeopelnumber(sgId);
                accidencecollectiondata.setAdminId((int)(Math.random()*3+1));
                accidencecollectiondata.setTeamName(team.getTeamName());
                accidencecollectiondataMapper.insert(accidencecollectiondata);

                /*
                * 事故信息
                *
                * */
                mm = mm==1?-1:1;//控制变化方向
                //设置经纬度
                accidentdata.setRiqi(date);
                accidentdata.setAccidencnumber(sgId);
                accidentdata.setLat(address.getLat()+mm*latIncreament);
                accidentdata.setLng(address.getLng()+mm*lngIncreament);
                //设置行政区
                placeName = address.getName()+name[j%10]+"交叉口";//详细名称
                String[] administrativeDivision = placeName.split(",");//获取行政区
                accidentdata.setCity(administrativeDivision[0]);//城市
                accidentdata.setXianqu(administrativeDivision[1]);//县区
                accidentdata.setDimingbeizhu(administrativeDivision[2]);//详细地名
                //设置事故类型
                int shiguTypeId = (int)(Math.random()*3);
                String[] shigu = shiguType[shiguTypeId].split(",");
                accidentdata.setShigu(shigu[0]);//一级事故
                String type2 = shigu[(int)(Math.random()*(shigu.length-1)+1)];
                accidentdata.setShigutype(type2);//二级事故
                if(type2.equals("机动车")){
                    accidentdata.setCarcollisiontype(carShiguType[(int)(Math.random()*(carShiguType.length-2))]);
                }else {
                    accidentdata.setCarcollisiontype("其它");
                }
                //设置严重程度
                accidentdata.setYanzhongcd(severity[(int)(Math.random()*severity.length)]);
                accidentdata.setDienums(""+(int)(Math.random()*1.25));//死亡人数
                accidentdata.setDrivernums((int)(Math.random()*2+1)+"");
                accidentdata.setCarnum((int)(Math.random()*3+1)+"");
                accidentdata.setSsnums(""+(int)(Math.random()*1.5));
                accidentdata.setId(index);
                accidentdataMapper.insert(accidentdata);

                /*
                * 环境信息
                *
                * */
                emdata.setId(index);
                emdata.setEmnumber(sgId);
                int ii = (int)(Math.random()*(intersection.length-1)+1);
                emdata.setJcktype(intersection[ii]);
                emdataMapper.insert(emdata);

                /*
                * 车辆信息
                * */

                cardata.setId(index);
                cardata.setCarnumber(sgId);
                cardataMapper.insert(cardata);

                /*
                * 人员信息
                * */
                driverPeoPelData.setId(index);
                driverPeoPelData.setShigunumber(sgId);
                driverPeoPelDataMapper.insert(driverPeoPelData);

                chenzuoPeopelData.setId(index);
                chenzuoPeopelData.setShigunumber(sgId);
                chenzuoPeopelDataMapper.insert(chenzuoPeopelData);

                qitaPeopelData.setId(index);
                qitaPeopelData.setShigunumber(sgId);
                qitaPeopelDataMapper.insert(qitaPeopelData);
            }
        }

        /*
        * 开始生成交叉口数据
        *
        * */

        for (int i = 0 ; i < 10 ;i++) {
            int mm = -1;
            for (int j = 0;j<100;j++) {
                index++;
                Address address = new Address();
                address = addressList.get(i);//获取一个位置
                //address.setName(address.getName()+name[j%10]);//设置新名称
                String placeName = address.getName()+name[j%10];//详细名称
                int teamId = (int)(Math.random()*5+1);//大队编号
                Team team = new Team();
                team = teamMapper.selectByPrimaryKey(teamId);

                int time  = (int)(Math.random()*12);//随机生成时间变化 12个月的
                /*
                * 生成新事故Id
                * */
                String sgId = "";
                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");


                /*
                * 生成新事故数据
                * */
                System.out.println("time-----------------:"+time);
                Accidencecollectiondata accidencecollectiondata = new Accidencecollectiondata();
                date.setTime(date.getTime()-(((teamId*address.getId())%20)*24*60*60*1000));//新时间
                date.setMonth(time);
                sgId = "SG"+simpleDateFormat.format(date)+(int)(Math.random()*10)+(int)(Math.random()*10);
                String name1 = placeName;
                // String name1 = ;
                accidencecollectiondata.setPlace(name1.replace(",","")+"交叉口");
                accidencecollectiondata.setRiqi(date);//设置日期12个月的数据
                accidencecollectiondata.setAccidencenumber(sgId);
                accidencecollectiondata.setShigunumber(sgId);
                accidencecollectiondata.setEnvironmentnumber(sgId);
                accidencecollectiondata.setCarnumber(sgId);
                accidencecollectiondata.setPeopelnumber(sgId);
                accidencecollectiondata.setAdminId((int)(Math.random()*3+1));
                accidencecollectiondata.setTeamName(team.getTeamName());
                accidencecollectiondataMapper.insert(accidencecollectiondata);

                /*
                * 事故信息
                *
                * */
                mm = mm==1?-1:1;//控制变化方向
                //设置经纬度
                accidentdata.setRiqi(date);
                accidentdata.setAccidencnumber(sgId);
                accidentdata.setLat(address.getLat()+mm*latIncreament);
                accidentdata.setLng(address.getLng()+mm*lngIncreament);
                //设置行政区
                placeName = address.getName()+name[j%10]+"交叉口";//详细名称
                String[] administrativeDivision = placeName.split(",");//获取行政区
                accidentdata.setCity(administrativeDivision[0]);//城市
                accidentdata.setXianqu(administrativeDivision[1]);//县区
                accidentdata.setDimingbeizhu(administrativeDivision[2]);//详细地名
                //设置事故类型
                int shiguTypeId = (int)(Math.random()*3);
                String[] shigu = shiguType[shiguTypeId].split(",");
                accidentdata.setShigu(shigu[0]);//一级事故
                String type2 = shigu[(int)(Math.random()*(shigu.length-1)+1)];
                accidentdata.setShigutype(type2);//二级事故
                if(type2.equals("机动车")){
                    accidentdata.setCarcollisiontype(carShiguType[(int)(Math.random()*(carShiguType.length-2))]);
                }else {
                    accidentdata.setCarcollisiontype("其它");
                }
                //设置严重程度
                accidentdata.setYanzhongcd(severity[(int)(Math.random()*severity.length)]);
                accidentdata.setDienums(""+(int)(Math.random()*1.25));//死亡人数
                accidentdata.setDrivernums((int)(Math.random()*2+1)+"");
                accidentdata.setCarnum((int)(Math.random()*3+1)+"");
                accidentdata.setSsnums(""+(int)(Math.random()*1.5));
                accidentdata.setId(index);
                accidentdataMapper.insert(accidentdata);

                /*
                * 环境信息
                *
                * */
                emdata.setId(index);
                emdata.setEmnumber(sgId);
                emdata.setJcktype("交叉口");
                emdataMapper.insert(emdata);

                /*
                * 车辆信息
                * */

                cardata.setId(index);
                cardata.setCarnumber(sgId);
                cardataMapper.insert(cardata);

                /*
                * 人员信息
                * */
                driverPeoPelData.setId(index);
                driverPeoPelData.setShigunumber(sgId);
                driverPeoPelDataMapper.insert(driverPeoPelData);

                chenzuoPeopelData.setId(index);
                chenzuoPeopelData.setShigunumber(sgId);
                chenzuoPeopelDataMapper.insert(chenzuoPeopelData);

                qitaPeopelData.setId(index);
                qitaPeopelData.setShigunumber(sgId);
                qitaPeopelDataMapper.insert(qitaPeopelData);
            }
        }

        // System.out.println("addresslist size"+addressList.size());
        return JsonResult.build(StatusCode.SUCCESS);
    }

}
