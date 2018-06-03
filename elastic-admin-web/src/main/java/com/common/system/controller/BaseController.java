package com.common.system.controller;

import com.common.system.shiro.ShiroKit;
import com.common.system.shiro.ShiroUser;
import com.biantech.elastic.common.util.Result;

/**
 * Created by Mr.biantech on 2017/6/20.
 * Time:16:14
 * ProjectName:elastic-admin
 */
public class BaseController {
    protected static String REDIRECT = "redirect:";
    protected static String FORWARD = "forward:";

    protected ShiroUser getUser(){
        return (ShiroUser)ShiroKit.getSubject().getPrincipal();
    }

    protected Result buildResult(boolean status,int code,String msg,Object o){
        Result result = new Result();
        result.setMsg(msg);
        result.setStatus(status);
        result.setCode(code);
        result.setData(o);
        return result;
    }
}
