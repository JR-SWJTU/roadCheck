package com.swjtu.roadCheck.service;

import com.swjtu.roadCheck.entity.Admin;

/**
 * Created by Administrator on 2017/10/18.
 */
public interface IAdminService {
    /**
     * 注册
     * @param admin
     */
    void register(Admin admin);

    /**
     * 登录
     * @param admin
     */
    Admin login(Admin admin);
}
