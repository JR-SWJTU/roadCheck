package com.swjtu.roadCheck.dto;

/**
 * Created by Administrator on 2017/10/21.
 */
public class Accident {

    private Integer id;

    private Double lat;

    private Double lng;

    private int total;  //总的事故数量

    private int propertyLossOnly;   //仅财产损失事故数

    private int slightInjury;    //轻伤事故数

    private int seriousInjury;  //重伤事故数

    private int dead;   //死亡事故数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPropertyLossOnly() {
        return propertyLossOnly;
    }

    public void setPropertyLossOnly(int propertyLossOnly) {
        this.propertyLossOnly = propertyLossOnly;
    }

    public int getSlightInjury() {
        return slightInjury;
    }

    public void setSlightInjury(int slightInjury) {
        this.slightInjury = slightInjury;
    }

    public int getSeriousInjury() {
        return seriousInjury;
    }

    public void setSeriousInjury(int seriousInjury) {
        this.seriousInjury = seriousInjury;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    @Override
    public String toString() {
        return "accident{" +
                "id=" + id +
                ", lat=" + lat +
                ", lng=" + lng +
                ", total=" + total +
                ", propertyLossOnly=" + propertyLossOnly +
                ", slightInjury=" + slightInjury +
                ", seriousInjury=" + seriousInjury +
                ", dead=" + dead +
                '}';
    }
}
