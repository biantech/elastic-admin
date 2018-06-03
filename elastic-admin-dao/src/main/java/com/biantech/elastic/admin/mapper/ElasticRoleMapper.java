package com.biantech.elastic.admin.mapper;

import com.biantech.elastic.admin.entity.ElasticRole;
import com.biantech.elastic.admin.entity.ElasticRoleExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ElasticRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ElasticRole record);

    int insertSelective(ElasticRole record);

    List<ElasticRole> selectByExample(ElasticRoleExample example);

    ElasticRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ElasticRole record);

    int updateByPrimaryKey(ElasticRole record);

    List<ElasticRole> getRoleList();
}