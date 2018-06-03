package com.common.system.service;

import com.biantech.elastic.admin.entity.ZTreeNode;

import java.util.List;

/**
 * Created by Mr.biantech on 2017/8/7.
 * Time:14:03
 * ProjectName:elastic-admin
 */
public interface ZTreeService {
    List<ZTreeNode> getMenuZTreeNodes();
    String buildZTree( List<ZTreeNode> zTreeNodeList);
}
