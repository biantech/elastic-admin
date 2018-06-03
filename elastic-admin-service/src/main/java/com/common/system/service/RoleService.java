package com.common.system.service;

import com.biantech.elastic.admin.entity.ElasticRole;
import com.biantech.elastic.admin.entity.ElasticRoleWrapper;
import com.biantech.elastic.common.util.Result;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Mr.biantech on 2017/6/22.
 * Time:14:15
 * ProjectName:elastic-admin
 */
public interface RoleService {

    PageInfo<ElasticRole> listForPage(Integer pageNum, Integer pageSize);

    int deleteById(Integer id);

    Result<ElasticRole> selectById(Integer id);

    ElasticRole selectByRoleName(String roleName);

    ElasticRole selectByRoleValue(String roleValue);

    Result<Integer> save(ElasticRole role, List<Integer> permissionIds);
    Result<Integer> update(ElasticRole role);

    List<ElasticRoleWrapper> getRoleWrapperList();
}
