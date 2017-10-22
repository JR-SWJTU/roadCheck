package com.swjtu.roadCheck.entity;

public class Cardata {
    private Integer id;

    private Integer xunhao;

    private String carnumber;

    private String vin;

    private String chepaihao;

    private String guobie;

    private String nianfen;

    private String pingpai;

    private String cartype;

    private String leixing;

    private String cheneinum;

    private String tesuzuoyong;

    private String xingshifangxing;

    private String xingwei;

    private String jiechudian;

    private String sunhuaibuwei;

    private String sunhuaschengdu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXunhao() {
        return xunhao;
    }

    public void setXunhao(Integer xunhao) {
        this.xunhao = xunhao;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber == null ? null : carnumber.trim();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public String getChepaihao() {
        return chepaihao;
    }

    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao == null ? null : chepaihao.trim();
    }

    public String getGuobie() {
        return guobie;
    }

    public void setGuobie(String guobie) {
        this.guobie = guobie == null ? null : guobie.trim();
    }

    public String getNianfen() {
        return nianfen;
    }

    public void setNianfen(String nianfen) {
        this.nianfen = nianfen == null ? null : nianfen.trim();
    }

    public String getPingpai() {
        return pingpai;
    }

    public void setPingpai(String pingpai) {
        this.pingpai = pingpai == null ? null : pingpai.trim();
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing == null ? null : leixing.trim();
    }

    public String getCheneinum() {
        return cheneinum;
    }

    public void setCheneinum(String cheneinum) {
        this.cheneinum = cheneinum == null ? null : cheneinum.trim();
    }

    public String getTesuzuoyong() {
        return tesuzuoyong;
    }

    public void setTesuzuoyong(String tesuzuoyong) {
        this.tesuzuoyong = tesuzuoyong == null ? null : tesuzuoyong.trim();
    }

    public String getXingshifangxing() {
        return xingshifangxing;
    }

    public void setXingshifangxing(String xingshifangxing) {
        this.xingshifangxing = xingshifangxing == null ? null : xingshifangxing.trim();
    }

    public String getXingwei() {
        return xingwei;
    }

    public void setXingwei(String xingwei) {
        this.xingwei = xingwei == null ? null : xingwei.trim();
    }

    public String getJiechudian() {
        return jiechudian;
    }

    public void setJiechudian(String jiechudian) {
        this.jiechudian = jiechudian == null ? null : jiechudian.trim();
    }

    public String getSunhuaibuwei() {
        return sunhuaibuwei;
    }

    public void setSunhuaibuwei(String sunhuaibuwei) {
        this.sunhuaibuwei = sunhuaibuwei == null ? null : sunhuaibuwei.trim();
    }

    public String getSunhuaschengdu() {
        return sunhuaschengdu;
    }

    public void setSunhuaschengdu(String sunhuaschengdu) {
        this.sunhuaschengdu = sunhuaschengdu == null ? null : sunhuaschengdu.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", xunhao=").append(xunhao);
        sb.append(", carnumber=").append(carnumber);
        sb.append(", vin=").append(vin);
        sb.append(", chepaihao=").append(chepaihao);
        sb.append(", guobie=").append(guobie);
        sb.append(", nianfen=").append(nianfen);
        sb.append(", pingpai=").append(pingpai);
        sb.append(", cartype=").append(cartype);
        sb.append(", leixing=").append(leixing);
        sb.append(", cheneinum=").append(cheneinum);
        sb.append(", tesuzuoyong=").append(tesuzuoyong);
        sb.append(", xingshifangxing=").append(xingshifangxing);
        sb.append(", xingwei=").append(xingwei);
        sb.append(", jiechudian=").append(jiechudian);
        sb.append(", sunhuaibuwei=").append(sunhuaibuwei);
        sb.append(", sunhuaschengdu=").append(sunhuaschengdu);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Cardata other = (Cardata) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getXunhao() == null ? other.getXunhao() == null : this.getXunhao().equals(other.getXunhao()))
            && (this.getCarnumber() == null ? other.getCarnumber() == null : this.getCarnumber().equals(other.getCarnumber()))
            && (this.getVin() == null ? other.getVin() == null : this.getVin().equals(other.getVin()))
            && (this.getChepaihao() == null ? other.getChepaihao() == null : this.getChepaihao().equals(other.getChepaihao()))
            && (this.getGuobie() == null ? other.getGuobie() == null : this.getGuobie().equals(other.getGuobie()))
            && (this.getNianfen() == null ? other.getNianfen() == null : this.getNianfen().equals(other.getNianfen()))
            && (this.getPingpai() == null ? other.getPingpai() == null : this.getPingpai().equals(other.getPingpai()))
            && (this.getCartype() == null ? other.getCartype() == null : this.getCartype().equals(other.getCartype()))
            && (this.getLeixing() == null ? other.getLeixing() == null : this.getLeixing().equals(other.getLeixing()))
            && (this.getCheneinum() == null ? other.getCheneinum() == null : this.getCheneinum().equals(other.getCheneinum()))
            && (this.getTesuzuoyong() == null ? other.getTesuzuoyong() == null : this.getTesuzuoyong().equals(other.getTesuzuoyong()))
            && (this.getXingshifangxing() == null ? other.getXingshifangxing() == null : this.getXingshifangxing().equals(other.getXingshifangxing()))
            && (this.getXingwei() == null ? other.getXingwei() == null : this.getXingwei().equals(other.getXingwei()))
            && (this.getJiechudian() == null ? other.getJiechudian() == null : this.getJiechudian().equals(other.getJiechudian()))
            && (this.getSunhuaibuwei() == null ? other.getSunhuaibuwei() == null : this.getSunhuaibuwei().equals(other.getSunhuaibuwei()))
            && (this.getSunhuaschengdu() == null ? other.getSunhuaschengdu() == null : this.getSunhuaschengdu().equals(other.getSunhuaschengdu()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getXunhao() == null) ? 0 : getXunhao().hashCode());
        result = prime * result + ((getCarnumber() == null) ? 0 : getCarnumber().hashCode());
        result = prime * result + ((getVin() == null) ? 0 : getVin().hashCode());
        result = prime * result + ((getChepaihao() == null) ? 0 : getChepaihao().hashCode());
        result = prime * result + ((getGuobie() == null) ? 0 : getGuobie().hashCode());
        result = prime * result + ((getNianfen() == null) ? 0 : getNianfen().hashCode());
        result = prime * result + ((getPingpai() == null) ? 0 : getPingpai().hashCode());
        result = prime * result + ((getCartype() == null) ? 0 : getCartype().hashCode());
        result = prime * result + ((getLeixing() == null) ? 0 : getLeixing().hashCode());
        result = prime * result + ((getCheneinum() == null) ? 0 : getCheneinum().hashCode());
        result = prime * result + ((getTesuzuoyong() == null) ? 0 : getTesuzuoyong().hashCode());
        result = prime * result + ((getXingshifangxing() == null) ? 0 : getXingshifangxing().hashCode());
        result = prime * result + ((getXingwei() == null) ? 0 : getXingwei().hashCode());
        result = prime * result + ((getJiechudian() == null) ? 0 : getJiechudian().hashCode());
        result = prime * result + ((getSunhuaibuwei() == null) ? 0 : getSunhuaibuwei().hashCode());
        result = prime * result + ((getSunhuaschengdu() == null) ? 0 : getSunhuaschengdu().hashCode());
        return result;
    }
}