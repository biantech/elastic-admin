package com.common.system.controller;

import com.biantech.elastic.admin.entity.ElasticMenu;
import com.biantech.elastic.admin.entity.ElasticRoleMenu;
import com.common.system.service.MenuService;
import com.common.system.shiro.ShiroKit;
import com.common.system.shiro.ShiroUser;
import com.biantech.elastic.common.util.MenuComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.biantech on 2017/6/20.
 * Time:17:42
 * ProjectName:elastic-admin
 */
@RestController
public class IndexController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView){
        ShiroUser user = (ShiroUser) ShiroKit.getSubject().getPrincipal();
        modelAndView.setViewName("/system/admin/index");
        List<ElasticRoleMenu> privilegeList = user.getPrivilegeList();
        if (null != privilegeList){
            List<String> ids = new ArrayList<>();
            for (ElasticRoleMenu p : privilegeList){
                if (!ids.contains(p.getMenuId())){
                    ids.add(p.getMenuId());
                }
            }
            List<Integer> wantList = new ArrayList<>();
            //得到一级菜单
            wantList.add(1);
            List<ElasticMenu> menuList = menuService.selectInIds(ids,wantList);
            wantList.clear();
            if (menuList != null){
                //得到二级菜单
                wantList.add(2);
                List<ElasticMenu> secondMenuList = menuService.selectInIds(ids,wantList);
                for (ElasticMenu menu:menuList) {
                    List<ElasticMenu> childList = new ArrayList<>();
                    for (ElasticMenu nu:secondMenuList
                         ) {
                        if (menu.getId().equals(nu.getpId())){
                            childList.add(nu);
                        }
                    }
                    childList.sort(new MenuComparator());
                    menu.setChild(childList);
                }
                menuList.sort(new MenuComparator());
                modelAndView.addObject("menuList",menuList);
            }
        }
        return modelAndView;
    }
}
