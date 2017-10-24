package com.swjtu.roadCheck.service.impl;

import com.swjtu.roadCheck.entity.Admin;
import com.swjtu.roadCheck.entity.AdminExample;
import com.swjtu.roadCheck.mapper.AdminMapper;
import com.swjtu.roadCheck.service.IAdminService;
import com.swjtu.roadCheck.web.exception.base.AccountNotExistException;
import com.swjtu.roadCheck.web.exception.base.CustomException;
import com.swjtu.roadCheck.web.exception.base.PasswdIncorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Resource
    private AdminMapper adminMapper;

    /**
     * 注册
     *
     * @param admin
     */
    public void register(Admin admin) {

        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andNameEqualTo(admin.getName());
        List<Admin> list = new ArrayList<Admin>();
        list = adminMapper.selectByExample(adminExample);

        //账号存在
        if(list.size() != 0){
            throw new CustomException("账号已经存在");
        }

        adminMapper.insert(admin);
    }

    /**
     * 登录
     *
     * @param admin
     */
    public Admin login(Admin admin) {

        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andNameEqualTo(admin.getName());
        List<Admin> list = new ArrayList<Admin>();
        list = adminMapper.selectByExample(adminExample);

        //账号不存在
        if(list.size() == 0){
            return null;
            //throw new AccountNotExistException();
        }

        //密码不正确
        Admin res = list.get(0);
        if(!res.getPassword().equals(admin.getPassword())){
            return null;
            //throw  new PasswdIncorException();
        }
        return res;
    }
}
