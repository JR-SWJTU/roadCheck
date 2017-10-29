package com.swjtu.roadCheck.entityCustom;

/**
 * Created by windows on 2017/10/29.
 */
public class BlackPointDataForWeb {
    /**
     * 黑点名字（路段名或交叉口名）
     */
    private String blackPointName;

    /**
     * 黑点所在行政区
     */
    private String blackPointRegion;

    /**
     *当量事故数
     */
    private Integer number;

    /**
     * 经度
     */
    private double lat;

    /**
     * 纬度
     */
    private double lng;

    public String getBlackPointName() {
        return blackPointName;
    }

    public void setBlackPointName(String blackPointName) {
        this.blackPointName = blackPointName;
    }

    public String getBlackPointRegion() {
        return blackPointRegion;
    }

    public void setBlackPointRegion(String blackPointRegion) {
        this.blackPointRegion = blackPointRegion;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
}
