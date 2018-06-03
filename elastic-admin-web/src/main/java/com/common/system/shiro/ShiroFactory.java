package com.common.system.shiro;

import com.biantech.elastic.admin.entity.*;
import com.biantech.elastic.admin.mapper.DepartmentMapper;
import com.biantech.elastic.admin.mapper.ElasticRoleMapper;
import com.biantech.elastic.admin.mapper.ElasticUserMapper;
import com.common.system.service.MenuService;
import com.common.system.service.RoleMenuService;
import com.common.system.service.UserRoleService;
import com.common.system.service.RoleService;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.biantech on 2017/6/20.
 * Time:16:46
 * ProjectName:elastic-admin
 */
@Service
public class ShiroFactory {
    @Autowired
    private ElasticUserMapper userMapper;
    @Autowired
    private ElasticRoleMapper roleMapper;
    @Autowired
    private DepartmentMapper deptMapper;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMenuService privilegeService;
    @Autowired
    private MenuService menuService;

    public ElasticUser user(String username) {
        ElasticUser user = userMapper.getUserByName(username);
        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        return user;
    }
    public ShiroUser shiroUser(ElasticUser user) {
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setId(user.getId());            // 账号id
        shiroUser.setUsername(user.getUsername());// 账号
        shiroUser.setName(user.getName());        // 用户名称
        List<ElasticUserRole> userRoleList = userRoleService.getByUserId(user.getId());
        List<ElasticRole> roleList = new ArrayList<>();
        if (userRoleList != null && userRoleList.size() > 0){
            for (ElasticUserRole r: userRoleList
                 ) {
                ElasticRole role = roleMapper.selectByPrimaryKey(r.getRoleId());
                roleList.add(role);
            }
            shiroUser.setRoleList(roleList);
        }
        shiroUser.setCreateTime(user.getCreateTime());

        if (roleList != null && roleList.size() >0 ){
            //权限菜单值
            List<String> permissionValues = new ArrayList<>();
            List<String> roleValues = new ArrayList<>();
            //角色权限菜单
            List<ElasticRoleMenu> privilegeList = new ArrayList<>();
            for (ElasticRole r:roleList
                    ) {
                roleValues.add(r.getValue());
                List<ElasticRoleMenu> ll = privilegeService.getByRoleId(r.getId());
                privilegeList.addAll(ll);
            }
            shiroUser.setRoleValues(roleValues);

            shiroUser.setPrivilegeList(privilegeList);
            List<String> ids = new ArrayList<>();
            for (ElasticRoleMenu p : privilegeList){
                //去重
                if (!ids.contains(p.getMenuId())){
                    ids.add(p.getMenuId());
                }
            }
            List<ElasticMenu> menuList = menuService.selectInIds(ids,null);

            for (ElasticMenu p:menuList
                    ) {
                permissionValues.add(p.getCode());
            }
            shiroUser.setPermissionValues(permissionValues);
        }
        return shiroUser;
    }
    public SimpleAuthenticationInfo buildAuthenticationInfo(ShiroUser shiroUser, ElasticUser user, String realmName) {
        String credentials = user.getPassword();
        // 密码加盐处理
        String source = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }
}
