package com.common.system.service.impl;

import com.biantech.elastic.department.entity.OperationLog;
import com.biantech.elastic.admin.mapper.OperationLogMapper;
import com.common.system.service.OperationLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author biantech
 * @since 2017-09-14
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {
	
}
