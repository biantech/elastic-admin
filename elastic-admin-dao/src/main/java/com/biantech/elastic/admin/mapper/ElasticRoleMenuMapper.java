package com.biantech.elastic.admin.mapper;

import com.biantech.elastic.admin.entity.ElasticRoleMenu;
import com.biantech.elastic.admin.entity.ElasticRoleMenuExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ElasticRoleMenuMapper {
    int deleteByExample(ElasticRoleMenuExample example);

    int insert(ElasticRoleMenu record);

    int insertSelective(ElasticRoleMenu record);

    List<ElasticRoleMenu> selectByExample(ElasticRoleMenuExample example);

    int updateByExampleSelective(@Param("record") ElasticRoleMenu record, @Param("example") ElasticRoleMenuExample example);

    int updateByExample(@Param("record") ElasticRoleMenu record, @Param("example") ElasticRoleMenuExample example);
}