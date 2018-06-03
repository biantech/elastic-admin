package com.common.system.service;

import com.biantech.elastic.admin.entity.ElasticMenu;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Mr.biantech on 2017/8/2.
 * Time:13:59
 * ProjectName:elastic-admin
 */
public interface MenuService {

    int deleteByPrimaryKey(String id);

    int insert(ElasticMenu record) throws Exception;

    ElasticMenu selectByPrimaryKey(String id);

    ElasticMenu selectCode(String code);

    int update(ElasticMenu record);

    int updatePcode(String oldPcode,String newPcode);

    PageInfo<ElasticMenu> listForPage(Integer pageNum, Integer pageSize);

    List<ElasticMenu> getMenu();
    List<ElasticMenu> selectInIds(List<String> ids,List<Integer> wantLevel);

    List<ElasticMenu> getByParentId(String pId);
}
