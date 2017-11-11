package com.swjtu.roadCheck.service;

import com.swjtu.roadCheck.entity.Admin;
import com.swjtu.roadCheck.util.PageResult;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
public interface IAdminService {
    /**
     * 注册
     * @param admin
     */
    void register(Admin admin) throws Exception;

    /**
     * 登录
     * @param admin
     */
    Admin login(Admin admin) throws Exception;

    /**
     * 添加一条管理员记录到数据库
     * @param admin 管理员对象
     */
    public void addAdmin( Admin admin) throws Exception;

    /**
     * 删除管理员
     * @param ids 要删除的管理员的id的数组
     */
    public void deleteAdmin(List ids);

    /**
     * 查询一条管理员数据
     * @param id 管理员id
     * @return admin 一条管理员信息
     */
    public Admin getAdminById(Integer id);

    /**
     * 分页查询管理员信息
     * @param pageNum
     * @param pageSize
     * @return  PageResult 管理员信息数组和管理员的总条数
     */
    public PageResult getAdminForPage(Integer pageNum, Integer pageSize) ;

    /**
     * 更新管理员数据
     * @param admin 管理员对象
     */
    public void updateAdmin(Admin admin);
}
