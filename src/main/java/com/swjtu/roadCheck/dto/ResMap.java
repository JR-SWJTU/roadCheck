package com.swjtu.roadCheck.dto;

/**
 * Created by Administrator on 2017/10/24.
 */
public class ResMap {
    private int num;  //总的事故数量

    private String keyRes;   //num对应的键

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getKeyRes() {
        return keyRes;
    }

    public void setKeyRes(String keyRes) {
        this.keyRes = keyRes;
    }
}
