package com.swjtu.roadCheck.dto;

/**
 * Created by Administrator on 2017/11/9.
 */
public class AdminInfo {
    private Integer adminId;

    private String name;

    private String password;

    private Integer teamId;

    private String teamName;

    private Byte issuper;   //管理员权限，true为超级管理员，false为一般管理员，超级管理员可以新添加一般管理员

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Byte getIssuper() {
        return issuper;
    }

    public void setIssuper(Byte issuper) {
        this.issuper = issuper;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
