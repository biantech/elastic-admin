package com.common.system.service.impl;

import com.biantech.elastic.admin.entity.ElasticRoleMenu;
import com.biantech.elastic.admin.entity.ElasticRoleMenuExample;
import com.biantech.elastic.admin.mapper.ElasticRoleMenuMapper;
import com.common.system.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr.biantech on 2017/8/7.
 * Time:11:51
 * ProjectName:elastic-admin
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private ElasticRoleMenuMapper privilegeMapper;

    @Override
    public int add(ElasticRoleMenu privilege) {
        return privilegeMapper.insert(privilege);
    }

    @Override
    public int delete(ElasticRoleMenu privilege) {
        ElasticRoleMenuExample example = new ElasticRoleMenuExample();
        ElasticRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(privilege.getRoleId());
        criteria.andMenuIdEqualTo(privilege.getMenuId());
        return privilegeMapper.deleteByExample(example);
    }

    @Override
    public List<ElasticRoleMenu> getByRoleId(Integer roleId) {
        ElasticRoleMenuExample example = new ElasticRoleMenuExample();
        ElasticRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return privilegeMapper.selectByExample(example);
    }

    @Override
    public int deleteByRoleId(Integer roleId) {
        ElasticRoleMenuExample example = new ElasticRoleMenuExample();
        ElasticRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return privilegeMapper.deleteByExample(example);
    }
}
