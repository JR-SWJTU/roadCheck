package com.swjtu.roadCheck.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swjtu.roadCheck.dto.AdminInfo;
import com.swjtu.roadCheck.entity.Admin;
import com.swjtu.roadCheck.entity.AdminExample;
import com.swjtu.roadCheck.mapper.AdminMapper;
import com.swjtu.roadCheck.mapper.AdminMapperCustom;
import com.swjtu.roadCheck.service.IAdminService;
import com.swjtu.roadCheck.util.PageResult;
import com.swjtu.roadCheck.web.exception.base.AccountNotExistException;
import com.swjtu.roadCheck.web.exception.base.CustomException;
import com.swjtu.roadCheck.web.exception.base.PasswdIncorException;
import com.swjtu.roadCheck.web.exception.base.ReqParmIncorException;
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
    @Resource
    private AdminMapperCustom adminMapperCustom;

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
    public Admin login(Admin admin)  throws Exception{

        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andNameEqualTo(admin.getName());
        List<Admin> list = new ArrayList<Admin>();
        list = adminMapper.selectByExample(adminExample);

        //账号不存在
        if(list.size() == 0){
            throw new CustomException("账号不存在");
        }

        //密码不正确
        Admin res = list.get(0);
        if(!res.getPassword().equals(admin.getPassword())){
            throw  new PasswdIncorException();
        }
        return res;
    }

    /**
     * 添加一条管理员记录到数据库
     *
     * @param admin 管理员对象
     */
    public void addAdmin(Admin admin) throws Exception{
        if(admin.getName() == null || admin.getPassword() ==null || admin.getIssuper() == null || admin.getTeamId() == null)
            throw new ReqParmIncorException();

        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andNameEqualTo(admin.getName());
        if(adminMapper.selectByExample(adminExample).size() != 0){
            throw new CustomException("该用户名已经存在");
        }else {
            adminMapper.insert(admin);
        }
    }

    /**
     * 删除管理员
     *
     * @param ids 要删除的管理员的id的数组
     */
    public void deleteAdmin(List ids) {
        for(int i = 0 ;  i < ids.size(); i++){
            if(!(ids.get(i) instanceof Long || ids.get(i) instanceof Integer))
                throw new ReqParmIncorException("参数非整型数据");
            adminMapper.deleteByPrimaryKey( (Integer) ids.get(i));
        }
    }

    /**
     * 查询一条管理员数据
     *
     * @param id 管理员id
     * @return admin 一条管理员信息
     */
    public Admin getAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询管理员信息
     *
     * @param pageNum
     * @param pageSize
     * @return PageResult 管理员信息数组和管理员的总条数
     */
    public PageResult getAdminForPage(Integer pageNum, Integer pageSize) {
        if(pageNum == null || pageSize == null)
            throw  new CustomException("参数缺失");
        PageHelper.startPage(pageNum, pageSize);
        List<AdminInfo> admins = adminMapperCustom.queryAdmin();
        PageInfo<AdminInfo> pageInfo = new PageInfo<AdminInfo>(admins);
        PageResult pageResult = new PageResult();
        pageResult.setRows(admins);
        pageResult.setTotal(pageInfo.getTotal());
        return pageResult;
    }

    /**
     * 更新管理员数据
     *
     * @param admin 管理员对象
     */
    public void updateAdmin(Admin admin) throws Exception{

        if(admin.getAdminId() == null)
            throw new ReqParmIncorException();

        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andNameEqualTo(admin.getName());
        List<Admin> list = new ArrayList<Admin>();
        list = adminMapper.selectByExample(adminExample);

        //账号存在
        if(list.size() != 0){
            throw new CustomException("用户名已经存在");
        }

        adminMapper.updateByPrimaryKey(admin);
    }


}
