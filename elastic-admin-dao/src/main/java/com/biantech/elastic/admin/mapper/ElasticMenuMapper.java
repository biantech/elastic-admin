package com.biantech.elastic.admin.mapper;

import com.biantech.elastic.admin.entity.ElasticMenu;
import com.biantech.elastic.admin.entity.ElasticMenuExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ElasticMenuMapper {
    int deleteByExample(ElasticMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(ElasticMenu record);

    int insertSelective(ElasticMenu record);

    List<ElasticMenu> selectByExample(ElasticMenuExample example);

    ElasticMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ElasticMenu record, @Param("example") ElasticMenuExample example);

    int updateByExample(@Param("record") ElasticMenu record, @Param("example") ElasticMenuExample example);

    int updateByPrimaryKeySelective(ElasticMenu record);

    int updateByPrimaryKey(ElasticMenu record);

    int updatePcode(@Param("oldPcode") String oldPcode,@Param("newPcode") String newPcode);
}