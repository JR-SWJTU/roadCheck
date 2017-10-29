package com.swjtu.roadCheck.dto;

/**
 * Created by Administrator on 2017/10/21.
 */
public class Accident {

    private int num;  //总的事故数量

    private Integer propertyLoss;   //事故严重程度，仅财产损失，null为不选择该条件进行显示，1为选择该条件显示

    private Integer slightInjury;   //事故严重程度，轻伤，null为不选择该条件进行显示，1为选择该条件显示

    private Integer severInjury;    //事故严重，重伤，null为不选择该条件进行显示，1为选择该条件显示

    private Integer dead;   //事故严重程度，死亡，null为不选择该条件进行显示，1为选择该条件显示

    private String diMingBeiZhu;   //事故发生所在的地名

    private String yearRes;    //时间分析中的时间

    private String monthRes;

    private String dayRes;

    private double lat;

    private double lng;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDiMingBeiZhu() {
        return diMingBeiZhu;
    }

    public void setDiMingBeiZhu(String diMingBeiZhu) {
        this.diMingBeiZhu = diMingBeiZhu;
    }

    public String getYearRes() {
        return yearRes;
    }

    public void setYearRes(String yearRes) {
        this.yearRes = yearRes;
    }

    public String getMonthRes() {
        return monthRes;
    }

    public void setMonthRes(String monthRes) {
        this.monthRes = monthRes;
    }

    public String getDayRes() {
        return dayRes;
    }

    public void setDayRes(String dayRes) {
        this.dayRes = dayRes;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
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
