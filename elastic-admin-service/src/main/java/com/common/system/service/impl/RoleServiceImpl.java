package com.common.system.service.impl;

import com.biantech.elastic.admin.entity.ElasticRole;
import com.biantech.elastic.admin.entity.ElasticRoleExample;
import com.biantech.elastic.admin.entity.ElasticRoleWrapper;
import com.biantech.elastic.admin.mapper.ElasticRoleMapper;
import com.common.system.service.RoleService;
import com.biantech.elastic.common.util.MsgCode;
import com.biantech.elastic.common.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.biantech on 2017/6/22.
 * Time:14:17
 * ProjectName:elastic-admin
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private ElasticRoleMapper roleMapper;

    @Override
    public PageInfo<ElasticRole> listForPage(Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        List<ElasticRole> roleList = roleMapper.getRoleList();
        return new PageInfo<>(roleList);
    }

    @Override
    public int deleteById(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ElasticRole selectByRoleName(String roleName) {
        ElasticRoleExample roleExample = new ElasticRoleExample();
        ElasticRoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andNameEqualTo(roleName);
        List<ElasticRole> resultData = roleMapper.selectByExample(roleExample);
        if (resultData.size() < 1) {
            return null;
        }
        return resultData.get(0);
    }
    @Override
    public ElasticRole selectByRoleValue(String roleValue) {
        ElasticRoleExample roleExample = new ElasticRoleExample();
        ElasticRoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andValueEqualTo(roleValue);
        List<ElasticRole> resultData = roleMapper.selectByExample(roleExample);
        if (resultData.size() < 1) {
            return null;
        }
        return resultData.get(0);
    }
    @Override
    public Result<Integer> save(ElasticRole role, List<Integer> permissionIds) {
        Result<Integer> result=new Result<>();
        result.setStatus(false);
        result.setCode(MsgCode.FAILED);
        if (selectByRoleName(role.getName()) != null){
            result.setMsg("角色名已存在");
            return result;
        }
        if (selectByRoleValue(role.getValue()) != null){
            result.setMsg("角色值已存在");
            return result;
        }
        roleMapper.insert(role);
        role = selectByRoleName(role.getName());
        return result;
    }

    @Override
    public Result<ElasticRole> selectById(Integer id) {
        Result<ElasticRole> result = new Result<>();
        ElasticRole role = roleMapper.selectByPrimaryKey(id);
        if (role == null){
            result.setStatus(false);
            result.setCode(MsgCode.FAILED);
            result.setMsg("没有该角色");
            return result;
        }
        result.setData(role);
        result.setStatus(true);
        result.setCode(MsgCode.SUCCESS);
        return result ;
    }

    @Override
    public Result<Integer> update(ElasticRole role) {
        Result<Integer> result = new Result<>();
        result.setStatus(false);
        result.setCode(MsgCode.FAILED);
        if (!StringUtils.hasText(role.getName())) {
            result.setMsg("角色名不能为空");
            return result;
        }
        if (!StringUtils.hasText(role.getValue())) {
            result.setMsg("角色值不能为空");
            return result;
        }
        try {
            roleMapper.updateByPrimaryKeySelective(role);
            result.setStatus(true);
            result.setCode(MsgCode.SUCCESS);
            result.setMsg("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(false);
            result.setCode(MsgCode.FAILED);
            result.setMsg("操作失败："+e.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public List<ElasticRoleWrapper> getRoleWrapperList() {
        List<ElasticRole> roleList = roleMapper.getRoleList();
        List<ElasticRoleWrapper> wraps = new ArrayList<>();
        if (roleList != null){
            for (ElasticRole role:roleList
                    ) {
                ElasticRoleWrapper wrapper = new ElasticRoleWrapper();
                wrapper.setId(role.getId());
                wrapper.setStatus(role.getStatus());
                wrapper.setName(role.getName());
                wrapper.setValue(role.getValue());
                wrapper.setTips(role.getTips());
                wrapper.setCreateTime(role.getCreateTime());
                wraps.add(wrapper);
            }
        }
        return wraps;
    }
}
