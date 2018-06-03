package com.biantech.elastic.admin.mapper;

import com.biantech.elastic.department.entity.DepartmentModel;
import com.biantech.elastic.department.entity.DepartmentModelExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DepartmentMapper {
    int deleteByExample(DepartmentModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentModel record);

    int insertSelective(DepartmentModel record);

    List<DepartmentModel> selectByExample(DepartmentModelExample example);

    DepartmentModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DepartmentModel record, @Param("example") DepartmentModelExample example);

    int updateByExample(@Param("record") DepartmentModel record, @Param("example") DepartmentModelExample example);

    int updateByPrimaryKeySelective(DepartmentModel record);

    int updateByPrimaryKey(DepartmentModel record);
}