package com.common.system.service;

import com.biantech.elastic.admin.entity.TreeGridNode;

import java.util.List;

/**
 * Created by Mr.biantech on 2017/9/12.
 * Time:17:40
 * ProjectName:elastic-admin
 */
public interface TreeGridService {
    List<TreeGridNode> getMenuTreeGridNodes();
}
