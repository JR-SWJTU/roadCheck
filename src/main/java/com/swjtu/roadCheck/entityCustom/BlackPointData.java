package com.swjtu.roadCheck.entityCustom;

/**
 * Created by windows on 2017/10/21.
 */
public class BlackPointData {
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

    public String getBlackPointName() {
        return blackPointName;
    }

    public void setBlackPointName(String blackPointName) {
        this.blackPointName = blackPointName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBlackPointRegion() {
        return blackPointRegion;
    }

    public void setBlackPointRegion(String blackPointRegion) {
        this.blackPointRegion = blackPointRegion;
    }

    @Override
    public String toString() {
        return "BlackPointData{" +
                "blackPointName='" + blackPointName + '\'' +
                ", blackPointRegion='" + blackPointRegion + '\'' +
                ", number=" + number +
                '}';
    }
}
