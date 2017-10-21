package com.swjtu.roadCheck.entityCustom;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/21.
 */
public class AccidentQueryCondition {

    private String teanName;    //大队名称

    private String areaName;    //行政区名称

    private String roadType;    //道路类型，交叉口还是路段

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private boolean yType;   //true为以事故数为纵轴，false为以事故严重程度为纵轴

    private String roadLevel;   //道路等级

    private String carCollisionType;    //车辆碰撞类型

    private String weather; //天气

    private boolean workPlaceRel;    //是否与作业区相关

    private String intersectionType;    //交叉口类型

    private String carType;     //车辆类型

    private boolean troEscape;   //是否肇事逃逸

    public String getTeanName() {
        return teanName;
    }

    public void setTeanName(String teanName) {
        this.teanName = teanName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isyType() {
        return yType;
    }

    public void setyType(boolean yType) {
        this.yType = yType;
    }

    public String getRoadLevel() {
        return roadLevel;
    }

    public void setRoadLevel(String roadLevel) {
        this.roadLevel = roadLevel;
    }

    public String getCarCollisionType() {
        return carCollisionType;
    }

    public void setCarCollisionType(String carCollisionType) {
        this.carCollisionType = carCollisionType;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWorkPlaceRel() {
        return workPlaceRel;
    }

    public void setWorkPlaceRel(String workPlaceRel) {
        this.workPlaceRel = workPlaceRel;
    }

    public String getIntersectionType() {
        return intersectionType;
    }

    public void setIntersectionType(String intersectionType) {
        this.intersectionType = intersectionType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getTroEscape() {
        return troEscape;
    }

    public void setTroEscape(String troEscape) {
        this.troEscape = troEscape;
    }

    @Override
    public String toString() {
        return "QueryCondition{" +
                "teanName='" + teanName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", roadType='" + roadType + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", yType=" + yType +
                ", roadLevel='" + roadLevel + '\'' +
                ", carCollisionType='" + carCollisionType + '\'' +
                ", weather='" + weather + '\'' +
                ", workPlaceRel='" + workPlaceRel + '\'' +
                ", intersectionType='" + intersectionType + '\'' +
                ", carType='" + carType + '\'' +
                ", troEscape='" + troEscape + '\'' +
                '}';
    }
}
