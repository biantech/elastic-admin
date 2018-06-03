package com.common.system.service;

import com.biantech.elastic.admin.entity.ElasticUser;
import com.biantech.elastic.common.util.Result;
import com.github.pagehelper.PageInfo;

/**
 * Created by Mr.biantech on 2017/6/26.
 * Time:13:57
 * ProjectName:elastic-admin
 */
public interface UserService {
    Result<Integer> deleteById(Integer userId);
    Result<ElasticUser> getById(Integer userId);
    Result<Integer> update(ElasticUser user);
    Result<Integer> save(ElasticUser user);
    Result<ElasticUser> getByUserName(String username);
    PageInfo<ElasticUser> listForPage(Integer pageNum, Integer pageSize);

    int modifyPwd(ElasticUser user);

}
