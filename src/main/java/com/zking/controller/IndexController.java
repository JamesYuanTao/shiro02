package com.zking.controller;

import com.zking.model.SysUser;
import com.zking.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("/goEdit")
    public String goEdit(){
        return "editUser";
    }

    @RequestMapping("/goUpdate")
    public String getSingleForUpdate(Integer userId, HttpSession session){
        SysUser sysUser = sysUserService.selectByPrimaryKey(userId);
        session.setAttribute("u",sysUser);
        return "editUser";
    }


}
