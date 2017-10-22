package com.swjtu.roadCheck.dto;

/**
 * Created by Administrator on 2017/10/21.
 */
public class Accident {

    private int num;  //总的事故数量

    private String yanZhongCd;   //事故严重程度

    private String diMingBeiZhu;   //事故发生所在的地名

    private String time;    //时间分析中的时间，最多精确到日

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getYanZhongCd() {
        return yanZhongCd;
    }

    public void setYanZhongCd(String yanZhongCd) {
        this.yanZhongCd = yanZhongCd;
    }

    public String getDiMingBeiZhu() {
        return diMingBeiZhu;
    }

    public void setDiMingBeiZhu(String diMingBeiZhu) {
        this.diMingBeiZhu = diMingBeiZhu;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
