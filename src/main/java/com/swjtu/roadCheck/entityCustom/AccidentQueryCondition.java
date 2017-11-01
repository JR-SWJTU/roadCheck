package com.swjtu.roadCheck.entityCustom;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by Administrator on 2017/10/21.
 */
public class AccidentQueryCondition {

    private String teamName[];    //大队名称

    private String areaName;    //行政区名称

    private String roadType;    //道路类型，交叉口还是路段

//    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String startTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endTime;

    private boolean yType;   //true为以事故数为纵轴，false为以事故严重程度为纵轴

    private String roadLevel;   //道路等级

    private String carCollisionType;    //车辆碰撞类型

    private String weather; //天气

    private String workPlaceRel;    //是否与作业区相关

    private String intersectionType;    //交叉口类型

    private String carType;     //车辆类型

    private String troEscape;   //是否肇事逃逸

    private Integer isWorkDay; //是否工作日

    private int timePrecision;      //时间精度，1为精确到年，2为精确到月，3为精确到日

    private Integer propertyLoss;   //事故严重程度，仅财产损失，null为不选择该条件进行显示，1为选择该条件显示

    private Integer slightInjury;   //事故严重程度，轻伤，null为不选择该条件进行显示，1为选择该条件显示

    private Integer severInjury;    //事故严重，重伤，null为不选择该条件进行显示，1为选择该条件显示

    private Integer dead;   //事故严重程度，死亡，null为不选择该条件进行显示，1为选择该条件显示


    public String[] getTeamName() {
        return teamName;
    }

    public void setTeamName(String[] teamName) {
        this.teamName = teamName;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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

    public Integer getIsWorkDay() {
        return isWorkDay;
    }

    public void setIsWorkDay(Integer isWorkDay) {
        this.isWorkDay = isWorkDay;
    }

    public int getTimePrecision() {
        return timePrecision;
    }

    public void setTimePrecision(int timePrecision) {
        this.timePrecision = timePrecision;
    }

    public Integer getPropertyLoss() {
        return propertyLoss;
    }

    public void setPropertyLoss(Integer propertyLoss) {
        this.propertyLoss = propertyLoss;
    }

    public Integer getSlightInjury() {
        return slightInjury;
    }

    public void setSlightInjury(Integer slightInjury) {
        this.slightInjury = slightInjury;
    }

    public Integer getSeverInjury() {
        return severInjury;
    }

    public void setSeverInjury(Integer severInjury) {
        this.severInjury = severInjury;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }
}
