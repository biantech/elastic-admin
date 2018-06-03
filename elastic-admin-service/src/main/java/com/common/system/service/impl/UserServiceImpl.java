package com.common.system.service.impl;

import com.biantech.elastic.admin.entity.ElasticRole;
import com.biantech.elastic.admin.entity.ElasticUser;
import com.biantech.elastic.admin.entity.ElasticUserRole;
import com.biantech.elastic.admin.mapper.ElasticUserMapper;
import com.common.system.service.UserRoleService;
import com.common.system.service.RoleService;
import com.common.system.service.UserService;
import com.biantech.elastic.common.util.MsgCode;
import com.biantech.elastic.common.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mr.biantech on 2017/6/26.
 * Time:13:59
 * ProjectName:elastic-admin
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ElasticUserMapper userMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public Result<Integer> deleteById(Integer userId) {
        Result<Integer> result = new Result<>();
        try {
            userMapper.deleteById(userId);
            result.setStatus(true);
            result.setCode(MsgCode.SUCCESS);
            result.setMsg("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<ElasticUser> getById(Integer userId) {
        Result<ElasticUser> result = new Result<>();
        ElasticUser user = userMapper.selectById(userId);
        if (user != null){
            result.setData(user);
            result.setStatus(true);
            result.setCode(MsgCode.SUCCESS);
            result.setMsg("操作成功");
        }
        return result;
    }

    @Override
    public Result<Integer> update(ElasticUser user) {
        Result<Integer> result = new Result<>();
        try {
            user.setUpdateTime(new Date());
            userMapper.updateByPrimaryKeySelective(user);
            result.setStatus(true);
            result.setCode(MsgCode.SUCCESS);
            result.setMsg("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof DuplicateKeyException){
                result.setMsg("昵称已经存在");
            }
        }
        return result;
    }

    @Override
    public Result<Integer> save(ElasticUser user) {
        Result<Integer> result = new Result<>();
        try {
            userMapper.insert(user);
            result.setStatus(true);
            result.setCode(MsgCode.SUCCESS);
            result.setMsg("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof DuplicateKeyException){
                result.setMsg("账号已经存在");
            }
        }
        return result;
    }

    @Override
    public Result<ElasticUser> getByUserName(String username) {
        Result<ElasticUser> result = new Result<>();
        ElasticUser user = userMapper.getUserByName(username);
        if (user != null){
            result.setData(user);
            result.setStatus(true);
            result.setCode(MsgCode.SUCCESS);
            result.setMsg("操作成功");
        }
        return result;
    }

    @Override
    public PageInfo<ElasticUser> listForPage(Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        List<ElasticUser> userList = userMapper.selectList(null);
        for (ElasticUser u: userList
             ) {
            List<ElasticUserRole> userRoleList = userRoleService.getByUserId(u.getId());

            if (userRoleList != null && userRoleList.size() > 0){
                List<ElasticRole> list = new ArrayList<>();
                for (ElasticUserRole ur:userRoleList
                     ) {
                    Result<ElasticRole> result = roleService.selectById(ur.getRoleId());
                    if (result.isStatus()){
                        list.add(result.getData());
                    }
                }
                u.setRoleList(list);
            }
        }
        return new PageInfo<>(userList);
    }

    @Override
    public int modifyPwd(ElasticUser user) {
        user.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
