package com.common.system.controller;

import com.biantech.elastic.admin.entity.ElasticRoleMenu;
import com.common.system.service.RoleMenuService;
import com.biantech.elastic.common.util.MsgCode;
import com.biantech.elastic.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Mr.biantech on 2017/8/7.
 * Time:15:24
 * ProjectName:elastic-admin
 */
@Controller
@RequestMapping(value = "privilege")
public class PrivilegeController {
    @Autowired
    private RoleMenuService privilegeService;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public @ResponseBody
    Result save(@RequestParam(required = true) Integer roleId, String[] permissions){
        Result result = new Result();
        System.out.println("roleId="+roleId);
        System.out.println("permission:"+permissions);
        privilegeService.deleteByRoleId(roleId);
        if (null != permissions){
            for (String id:permissions) {
                ElasticRoleMenu p = new ElasticRoleMenu();
                p.setRoleId(roleId);
                p.setMenuId(id);
                p.setCreateTime(new Date());
                privilegeService.add(p);
            }
        }
        result.setStatus(true);
        result.setMsg("操作成功");
        result.setCode(MsgCode.SUCCESS);
        return result;
    }

}
