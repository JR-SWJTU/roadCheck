package com.swjtu.roadCheck.entity;

import java.util.Date;

public class Accidencecollectiondata {
    private Integer id;

    private Date riqi;

    private Integer isupload;

    private Integer adminId;

    private String teamName;

    private String shigunumber;

    private String place;

    private String accidencenumber;

    private String environmentnumber;

    private String carnumber;

    private String peopelnumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRiqi() {
        return riqi;
    }

    public void setRiqi(Date riqi) {
        this.riqi = riqi;
    }

    public Integer getIsupload() {
        return isupload;
    }

    public void setIsupload(Integer isupload) {
        this.isupload = isupload;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getShigunumber() {
        return shigunumber;
    }

    public void setShigunumber(String shigunumber) {
        this.shigunumber = shigunumber == null ? null : shigunumber.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getAccidencenumber() {
        return accidencenumber;
    }

    public void setAccidencenumber(String accidencenumber) {
        this.accidencenumber = accidencenumber == null ? null : accidencenumber.trim();
    }

    public String getEnvironmentnumber() {
        return environmentnumber;
    }

    public void setEnvironmentnumber(String environmentnumber) {
        this.environmentnumber = environmentnumber == null ? null : environmentnumber.trim();
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber == null ? null : carnumber.trim();
    }

    public String getPeopelnumber() {
        return peopelnumber;
    }

    public void setPeopelnumber(String peopelnumber) {
        this.peopelnumber = peopelnumber == null ? null : peopelnumber.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", riqi=").append(riqi);
        sb.append(", isupload=").append(isupload);
        sb.append(", adminId=").append(adminId);
        sb.append(", teamName=").append(teamName);
        sb.append(", shigunumber=").append(shigunumber);
        sb.append(", place=").append(place);
        sb.append(", accidencenumber=").append(accidencenumber);
        sb.append(", environmentnumber=").append(environmentnumber);
        sb.append(", carnumber=").append(carnumber);
        sb.append(", peopelnumber=").append(peopelnumber);
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
        Accidencecollectiondata other = (Accidencecollectiondata) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRiqi() == null ? other.getRiqi() == null : this.getRiqi().equals(other.getRiqi()))
            && (this.getIsupload() == null ? other.getIsupload() == null : this.getIsupload().equals(other.getIsupload()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getTeamName() == null ? other.getTeamName() == null : this.getTeamName().equals(other.getTeamName()))
            && (this.getShigunumber() == null ? other.getShigunumber() == null : this.getShigunumber().equals(other.getShigunumber()))
            && (this.getPlace() == null ? other.getPlace() == null : this.getPlace().equals(other.getPlace()))
            && (this.getAccidencenumber() == null ? other.getAccidencenumber() == null : this.getAccidencenumber().equals(other.getAccidencenumber()))
            && (this.getEnvironmentnumber() == null ? other.getEnvironmentnumber() == null : this.getEnvironmentnumber().equals(other.getEnvironmentnumber()))
            && (this.getCarnumber() == null ? other.getCarnumber() == null : this.getCarnumber().equals(other.getCarnumber()))
            && (this.getPeopelnumber() == null ? other.getPeopelnumber() == null : this.getPeopelnumber().equals(other.getPeopelnumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRiqi() == null) ? 0 : getRiqi().hashCode());
        result = prime * result + ((getIsupload() == null) ? 0 : getIsupload().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getTeamName() == null) ? 0 : getTeamName().hashCode());
        result = prime * result + ((getShigunumber() == null) ? 0 : getShigunumber().hashCode());
        result = prime * result + ((getPlace() == null) ? 0 : getPlace().hashCode());
        result = prime * result + ((getAccidencenumber() == null) ? 0 : getAccidencenumber().hashCode());
        result = prime * result + ((getEnvironmentnumber() == null) ? 0 : getEnvironmentnumber().hashCode());
        result = prime * result + ((getCarnumber() == null) ? 0 : getCarnumber().hashCode());
        result = prime * result + ((getPeopelnumber() == null) ? 0 : getPeopelnumber().hashCode());
        return result;
    }
}