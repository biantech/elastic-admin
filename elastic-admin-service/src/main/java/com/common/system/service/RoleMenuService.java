package com.common.system.service;

import com.biantech.elastic.admin.entity.ElasticRoleMenu;

import java.util.List;

/**
 * Created by Mr.biantech on 2017/8/7.
 * Time:11:49
 * ProjectName:elastic-admin
 */
public interface RoleMenuService {
    int add(ElasticRoleMenu privilege);
    int delete(ElasticRoleMenu privilege);
    int deleteByRoleId(Integer roleId);
    List<ElasticRoleMenu> getByRoleId(Integer roleId);
}
