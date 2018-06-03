package com.common.system.shiro;

import com.biantech.elastic.admin.entity.ElasticRoleMenu;
import com.biantech.elastic.admin.entity.ElasticRole;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by biantech on 2017/6/20.
 * Time:16:54
 * ProjectName:elastic-admin
 */
public class ShiroUser implements Serializable{
    private static final long serialVersionUID = -4661753370573516137L;

    private Integer id;          // 主键ID
    private String username;      // 账号
    private String name;         // 姓名
    private Integer deptId;      // 部门id
    private String deptName;        // 部门名称
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //角色集
    private List<ElasticRole> roleList;

    List<ElasticRoleMenu> privilegeList;
    //菜单权限值
    List<String> permissionValues = new ArrayList<>();
    //角色值
    List<String> roleValues = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public List<ElasticRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<ElasticRole> roleList) {
        this.roleList = roleList;
    }

    public List<ElasticRoleMenu> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<ElasticRoleMenu> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public List<String> getPermissionValues() {
        return permissionValues;
    }

    public void setPermissionValues(List<String> permissionValues) {
        this.permissionValues = permissionValues;
    }

    public List<String> getRoleValues() {
        return roleValues;
    }

    public void setRoleValues(List<String> roleValues) {
        this.roleValues = roleValues;
    }
}