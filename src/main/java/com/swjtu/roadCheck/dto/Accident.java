package com.swjtu.roadCheck.dto;

/**
 * Created by Administrator on 2017/10/21.
 */
public class Accident {

    private int num;  //总的事故数量

    private String keyRes;   //num对应的键

    private String diMingBeiZhu;   //事故发生所在的地名

    private String yearRes;    //时间分析中的时间

    private String monthRes;

    private String dayRes;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getkeyRes() {
        return keyRes;
    }

    public void setkeyRes(String keyRes) {
        this.keyRes = keyRes;
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
}
