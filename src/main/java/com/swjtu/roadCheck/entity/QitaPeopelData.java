package com.swjtu.roadCheck.entity;

public class QitaPeopelData {
    private Integer id;

    private String aqsbsyzhuangtai;

    private String ceshiresult;

    private String ceshitype;

    private String ceshizhuangtai;

    private String cheliangxunhao;

    private String duPingLeiXing;

    private String name;

    private String phonenum;

    private String renyuantype;

    private String sgfsosition;

    private String sgfsqxingwei;

    private String sgfssxingwei;

    private String sgfsszhuangtai;

    private String shenfentype;

    private String sschengdu;

    private String xingbie;

    private String yinjiu;

    private String shigunumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAqsbsyzhuangtai() {
        return aqsbsyzhuangtai;
    }

    public void setAqsbsyzhuangtai(String aqsbsyzhuangtai) {
        this.aqsbsyzhuangtai = aqsbsyzhuangtai == null ? null : aqsbsyzhuangtai.trim();
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

    public String getSgfsosition() {
        return sgfsosition;
    }

    public void setSgfsosition(String sgfsosition) {
        this.sgfsosition = sgfsosition == null ? null : sgfsosition.trim();
    }

    public String getSgfsqxingwei() {
        return sgfsqxingwei;
    }

    public void setSgfsqxingwei(String sgfsqxingwei) {
        this.sgfsqxingwei = sgfsqxingwei == null ? null : sgfsqxingwei.trim();
    }

    public String getSgfssxingwei() {
        return sgfssxingwei;
    }

    public void setSgfssxingwei(String sgfssxingwei) {
        this.sgfssxingwei = sgfssxingwei == null ? null : sgfssxingwei.trim();
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
        sb.append(", aqsbsyzhuangtai=").append(aqsbsyzhuangtai);
        sb.append(", ceshiresult=").append(ceshiresult);
        sb.append(", ceshitype=").append(ceshitype);
        sb.append(", ceshizhuangtai=").append(ceshizhuangtai);
        sb.append(", cheliangxunhao=").append(cheliangxunhao);
        sb.append(", duPingLeiXing=").append(duPingLeiXing);
        sb.append(", name=").append(name);
        sb.append(", phonenum=").append(phonenum);
        sb.append(", renyuantype=").append(renyuantype);
        sb.append(", sgfsosition=").append(sgfsosition);
        sb.append(", sgfsqxingwei=").append(sgfsqxingwei);
        sb.append(", sgfssxingwei=").append(sgfssxingwei);
        sb.append(", sgfsszhuangtai=").append(sgfsszhuangtai);
        sb.append(", shenfentype=").append(shenfentype);
        sb.append(", sschengdu=").append(sschengdu);
        sb.append(", xingbie=").append(xingbie);
        sb.append(", yinjiu=").append(yinjiu);
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
        QitaPeopelData other = (QitaPeopelData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAqsbsyzhuangtai() == null ? other.getAqsbsyzhuangtai() == null : this.getAqsbsyzhuangtai().equals(other.getAqsbsyzhuangtai()))
            && (this.getCeshiresult() == null ? other.getCeshiresult() == null : this.getCeshiresult().equals(other.getCeshiresult()))
            && (this.getCeshitype() == null ? other.getCeshitype() == null : this.getCeshitype().equals(other.getCeshitype()))
            && (this.getCeshizhuangtai() == null ? other.getCeshizhuangtai() == null : this.getCeshizhuangtai().equals(other.getCeshizhuangtai()))
            && (this.getCheliangxunhao() == null ? other.getCheliangxunhao() == null : this.getCheliangxunhao().equals(other.getCheliangxunhao()))
            && (this.getDuPingLeiXing() == null ? other.getDuPingLeiXing() == null : this.getDuPingLeiXing().equals(other.getDuPingLeiXing()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhonenum() == null ? other.getPhonenum() == null : this.getPhonenum().equals(other.getPhonenum()))
            && (this.getRenyuantype() == null ? other.getRenyuantype() == null : this.getRenyuantype().equals(other.getRenyuantype()))
            && (this.getSgfsosition() == null ? other.getSgfsosition() == null : this.getSgfsosition().equals(other.getSgfsosition()))
            && (this.getSgfsqxingwei() == null ? other.getSgfsqxingwei() == null : this.getSgfsqxingwei().equals(other.getSgfsqxingwei()))
            && (this.getSgfssxingwei() == null ? other.getSgfssxingwei() == null : this.getSgfssxingwei().equals(other.getSgfssxingwei()))
            && (this.getSgfsszhuangtai() == null ? other.getSgfsszhuangtai() == null : this.getSgfsszhuangtai().equals(other.getSgfsszhuangtai()))
            && (this.getShenfentype() == null ? other.getShenfentype() == null : this.getShenfentype().equals(other.getShenfentype()))
            && (this.getSschengdu() == null ? other.getSschengdu() == null : this.getSschengdu().equals(other.getSschengdu()))
            && (this.getXingbie() == null ? other.getXingbie() == null : this.getXingbie().equals(other.getXingbie()))
            && (this.getYinjiu() == null ? other.getYinjiu() == null : this.getYinjiu().equals(other.getYinjiu()))
            && (this.getShigunumber() == null ? other.getShigunumber() == null : this.getShigunumber().equals(other.getShigunumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAqsbsyzhuangtai() == null) ? 0 : getAqsbsyzhuangtai().hashCode());
        result = prime * result + ((getCeshiresult() == null) ? 0 : getCeshiresult().hashCode());
        result = prime * result + ((getCeshitype() == null) ? 0 : getCeshitype().hashCode());
        result = prime * result + ((getCeshizhuangtai() == null) ? 0 : getCeshizhuangtai().hashCode());
        result = prime * result + ((getCheliangxunhao() == null) ? 0 : getCheliangxunhao().hashCode());
        result = prime * result + ((getDuPingLeiXing() == null) ? 0 : getDuPingLeiXing().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhonenum() == null) ? 0 : getPhonenum().hashCode());
        result = prime * result + ((getRenyuantype() == null) ? 0 : getRenyuantype().hashCode());
        result = prime * result + ((getSgfsosition() == null) ? 0 : getSgfsosition().hashCode());
        result = prime * result + ((getSgfsqxingwei() == null) ? 0 : getSgfsqxingwei().hashCode());
        result = prime * result + ((getSgfssxingwei() == null) ? 0 : getSgfssxingwei().hashCode());
        result = prime * result + ((getSgfsszhuangtai() == null) ? 0 : getSgfsszhuangtai().hashCode());
        result = prime * result + ((getShenfentype() == null) ? 0 : getShenfentype().hashCode());
        result = prime * result + ((getSschengdu() == null) ? 0 : getSschengdu().hashCode());
        result = prime * result + ((getXingbie() == null) ? 0 : getXingbie().hashCode());
        result = prime * result + ((getYinjiu() == null) ? 0 : getYinjiu().hashCode());
        result = prime * result + ((getShigunumber() == null) ? 0 : getShigunumber().hashCode());
        return result;
    }
}