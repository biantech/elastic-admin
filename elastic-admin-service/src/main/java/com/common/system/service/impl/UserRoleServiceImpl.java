package com.common.system.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.biantech.elastic.admin.entity.ElasticUserRole;
import com.biantech.elastic.admin.mapper.ElasticUserRoleMapper;
import com.common.system.service.UserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author biantech
 * @since 2017-09-11
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<ElasticUserRoleMapper, ElasticUserRole> implements UserRoleService {
    @Override
    public boolean deleteByUserId(Integer userId) {
        return delete(new Wrapper<ElasticUserRole>() {
            @Override
            public String getSqlSegment() {
                return "where user_id="+userId;
            }
        });
    }

    @Override
    public List<ElasticUserRole> getByUserId(Integer userId) {
        return selectList(new Wrapper<ElasticUserRole>() {
            @Override
            public String getSqlSegment() {
                return "where user_id="+userId;
            }
        });
    }
}
