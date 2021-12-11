package com.zking.controller;

import com.zking.mapper.SysUserMapper;
import com.zking.model.SysUser;
import com.zking.service.ISysUserService;
import com.zking.util.PasswordHelper;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ISysUserService sysUserService;
    @RequestMapping("userList")
    @RequiresRoles(value = "管理员")
    public String userList(HttpSession session){
        List<SysUser> users = sysUserService.list();
        session.setAttribute("users",users);
        return "userList";
    }

    /**
     * 增加用户
     * @param sysUser
     * @return
     */
    @RequestMapping("add")
    public String add(SysUser sysUser){
        //获取盐
        String salt = PasswordHelper.createSalt();
        //将盐给用户
        sysUser.setSalt(salt);
        //获取加密后的密码
        String credentials = PasswordHelper.createCredentials(sysUser.getPassword(), salt);
        //将加密后的密码给用户
        sysUser.setPassword(credentials);
        //增加用户
        int insert = sysUserService.insert(sysUser);
        if(insert>0){
            return "redirect:userList";
        }else{
            return "editUser";
        }
    }

    /**
     * 删除
     * @param userid 要删除的用户的编号
     * @return
     */
    @RequestMapping("del")
    public String del(Integer userid){
        int i = sysUserService.deleteByPrimaryKey(userid);
        return "redirect:userList";
    }

    /**
     * 修改密码
     * @param sysUser
     * @param session
     * @return
     */
    @RequestMapping("changePassword")
    public String changePassword(SysUser sysUser,HttpSession session){
        String userPassword = session.getAttribute("userPassword").toString();
        System.out.println(userPassword);
        return null;
    }
}
