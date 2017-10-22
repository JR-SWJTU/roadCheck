package com.swjtu.roadCheck.entity;

public class ChenzuoPeopelData {
    private Integer id;

    private String aqqnzt;

    private String ceshiresult;

    private String ceshitype;

    private String ceshizhuangtai;

    private String cheliangxunhao;

    private String duPingLeiXing;

    private String name;

    private String paochuzhuangta;

    private String phonenum;

    private String renyuantype;

    private String sgfsszhuangtai;

    private String shenfentype;

    private String sschengdu;

    private String tuokuishiyong;

    private String xingbie;

    private String yinjiu;

    private String ysxitong;

    private String shigunumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAqqnzt() {
        return aqqnzt;
    }

    public void setAqqnzt(String aqqnzt) {
        this.aqqnzt = aqqnzt == null ? null : aqqnzt.trim();
    }

    public String getCeshiresult() {
        return ceshiresult;
    }

    public void setCeshiresult(String ceshiresult) {
        this.ceshiresult = ceshiresult == null ? null : ceshiresult.trim();
    }

    public String getCeshitype() {
        return ceshitype;
    }

    public void setCeshitype(String ceshitype) {
        this.ceshitype = ceshitype == null ? null : ceshitype.trim();
    }

    public String getCeshizhuangtai() {
        return ceshizhuangtai;
    }

    public void setCeshizhuangtai(String ceshizhuangtai) {
        this.ceshizhuangtai = ceshizhuangtai == null ? null : ceshizhuangtai.trim();
    }

    public String getCheliangxunhao() {
        return cheliangxunhao;
    }

    public void setCheliangxunhao(String cheliangxunhao) {
        this.cheliangxunhao = cheliangxunhao == null ? null : cheliangxunhao.trim();
    }

    public String getDuPingLeiXing() {
        return duPingLeiXing;
    }

    public void setDuPingLeiXing(String duPingLeiXing) {
        this.duPingLeiXing = duPingLeiXing == null ? null : duPingLeiXing.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPaochuzhuangta() {
        return paochuzhuangta;
    }

    public void setPaochuzhuangta(String paochuzhuangta) {
        this.paochuzhuangta = paochuzhuangta == null ? null : paochuzhuangta.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public String getRenyuantype() {
        return renyuantype;
    }

    public void setRenyuantype(String renyuantype) {
        this.renyuantype = renyuantype == null ? null : renyuantype.trim();
    }

    public String getSgfsszhuangtai() {
        return sgfsszhuangtai;
    }

    public void setSgfsszhuangtai(String sgfsszhuangtai) {
        this.sgfsszhuangtai = sgfsszhuangtai == null ? null : sgfsszhuangtai.trim();
    }

    public String getShenfentype() {
        return shenfentype;
    }

    public void setShenfentype(String shenfentype) {
        this.shenfentype = shenfentype == null ? null : shenfentype.trim();
    }

    public String getSschengdu() {
        return sschengdu;
    }

    public void setSschengdu(String sschengdu) {
        this.sschengdu = sschengdu == null ? null : sschengdu.trim();
    }

    public String getTuokuishiyong() {
        return tuokuishiyong;
    }

    public void setTuokuishiyong(String tuokuishiyong) {
        this.tuokuishiyong = tuokuishiyong == null ? null : tuokuishiyong.trim();
    }

    public String getXingbie() {
        return xingbie;
    }

    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }

    public String getYinjiu() {
        return yinjiu;
    }

    public void setYinjiu(String yinjiu) {
        this.yinjiu = yinjiu == null ? null : yinjiu.trim();
    }

    public String getYsxitong() {
        return ysxitong;
    }

    public void setYsxitong(String ysxitong) {
        this.ysxitong = ysxitong == null ? null : ysxitong.trim();
    }

    public String getShigunumber() {
        return shigunumber;
    }

    public void setShigunumber(String shigunumber) {
        this.shigunumber = shigunumber == null ? null : shigunumber.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", aqqnzt=").append(aqqnzt);
        sb.append(", ceshiresult=").append(ceshiresult);
        sb.append(", ceshitype=").append(ceshitype);
        sb.append(", ceshizhuangtai=").append(ceshizhuangtai);
        sb.append(", cheliangxunhao=").append(cheliangxunhao);
        sb.append(", duPingLeiXing=").append(duPingLeiXing);
        sb.append(", name=").append(name);
        sb.append(", paochuzhuangta=").append(paochuzhuangta);
        sb.append(", phonenum=").append(phonenum);
        sb.append(", renyuantype=").append(renyuantype);
        sb.append(", sgfsszhuangtai=").append(sgfsszhuangtai);
        sb.append(", shenfentype=").append(shenfentype);
        sb.append(", sschengdu=").append(sschengdu);
        sb.append(", tuokuishiyong=").append(tuokuishiyong);
        sb.append(", xingbie=").append(xingbie);
        sb.append(", yinjiu=").append(yinjiu);
        sb.append(", ysxitong=").append(ysxitong);
        sb.append(", shigunumber=").append(shigunumber);
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
        ChenzuoPeopelData other = (ChenzuoPeopelData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAqqnzt() == null ? other.getAqqnzt() == null : this.getAqqnzt().equals(other.getAqqnzt()))
            && (this.getCeshiresult() == null ? other.getCeshiresult() == null : this.getCeshiresult().equals(other.getCeshiresult()))
            && (this.getCeshitype() == null ? other.getCeshitype() == null : this.getCeshitype().equals(other.getCeshitype()))
            && (this.getCeshizhuangtai() == null ? other.getCeshizhuangtai() == null : this.getCeshizhuangtai().equals(other.getCeshizhuangtai()))
            && (this.getCheliangxunhao() == null ? other.getCheliangxunhao() == null : this.getCheliangxunhao().equals(other.getCheliangxunhao()))
            && (this.getDuPingLeiXing() == null ? other.getDuPingLeiXing() == null : this.getDuPingLeiXing().equals(other.getDuPingLeiXing()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPaochuzhuangta() == null ? other.getPaochuzhuangta() == null : this.getPaochuzhuangta().equals(other.getPaochuzhuangta()))
            && (this.getPhonenum() == null ? other.getPhonenum() == null : this.getPhonenum().equals(other.getPhonenum()))
            && (this.getRenyuantype() == null ? other.getRenyuantype() == null : this.getRenyuantype().equals(other.getRenyuantype()))
            && (this.getSgfsszhuangtai() == null ? other.getSgfsszhuangtai() == null : this.getSgfsszhuangtai().equals(other.getSgfsszhuangtai()))
            && (this.getShenfentype() == null ? other.getShenfentype() == null : this.getShenfentype().equals(other.getShenfentype()))
            && (this.getSschengdu() == null ? other.getSschengdu() == null : this.getSschengdu().equals(other.getSschengdu()))
            && (this.getTuokuishiyong() == null ? other.getTuokuishiyong() == null : this.getTuokuishiyong().equals(other.getTuokuishiyong()))
            && (this.getXingbie() == null ? other.getXingbie() == null : this.getXingbie().equals(other.getXingbie()))
            && (this.getYinjiu() == null ? other.getYinjiu() == null : this.getYinjiu().equals(other.getYinjiu()))
            && (this.getYsxitong() == null ? other.getYsxitong() == null : this.getYsxitong().equals(other.getYsxitong()))
            && (this.getShigunumber() == null ? other.getShigunumber() == null : this.getShigunumber().equals(other.getShigunumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAqqnzt() == null) ? 0 : getAqqnzt().hashCode());
        result = prime * result + ((getCeshiresult() == null) ? 0 : getCeshiresult().hashCode());
        result = prime * result + ((getCeshitype() == null) ? 0 : getCeshitype().hashCode());
        result = prime * result + ((getCeshizhuangtai() == null) ? 0 : getCeshizhuangtai().hashCode());
        result = prime * result + ((getCheliangxunhao() == null) ? 0 : getCheliangxunhao().hashCode());
        result = prime * result + ((getDuPingLeiXing() == null) ? 0 : getDuPingLeiXing().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPaochuzhuangta() == null) ? 0 : getPaochuzhuangta().hashCode());
        result = prime * result + ((getPhonenum() == null) ? 0 : getPhonenum().hashCode());
        result = prime * result + ((getRenyuantype() == null) ? 0 : getRenyuantype().hashCode());
        result = prime * result + ((getSgfsszhuangtai() == null) ? 0 : getSgfsszhuangtai().hashCode());
        result = prime * result + ((getShenfentype() == null) ? 0 : getShenfentype().hashCode());
        result = prime * result + ((getSschengdu() == null) ? 0 : getSschengdu().hashCode());
        result = prime * result + ((getTuokuishiyong() == null) ? 0 : getTuokuishiyong().hashCode());
        result = prime * result + ((getXingbie() == null) ? 0 : getXingbie().hashCode());
        result = prime * result + ((getYinjiu() == null) ? 0 : getYinjiu().hashCode());
        result = prime * result + ((getYsxitong() == null) ? 0 : getYsxitong().hashCode());
        result = prime * result + ((getShigunumber() == null) ? 0 : getShigunumber().hashCode());
        return result;
    }
}