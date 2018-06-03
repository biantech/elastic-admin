package com.common.system.service;

import com.biantech.elastic.admin.entity.ElasticUserRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author biantech
 * @since 2017-09-11
 */
public interface UserRoleService extends IService<ElasticUserRole> {
	boolean deleteByUserId(Integer userId);
    List<ElasticUserRole> getByUserId(Integer userId);
}
