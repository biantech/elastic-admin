package com.biantech.elastic.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.biantech.elastic.admin.entity.ElasticUser;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ElasticUserMapper extends BaseMapper<ElasticUser> {

    ElasticUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ElasticUser record);

    ElasticUser getUserByName(String username);
}