package com.zking.shiro;

import com.zking.model.SysUser;
import com.zking.service.ISysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private ISysUserService sysUserService;
    //权限角色验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名
        String username = principalCollection.getPrimaryPrincipal().toString();
        //获取用户角色
        Set<String> role = sysUserService.getRoleByUserName(username);
        //获取用户权限
        Set<String> permissions = sysUserService.getPermissionByUserName(username);
        //保存用户信息
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //设置用户角色信息
        info.setRoles(role);
        //设置用户权限
        info.setStringPermissions(permissions);
        return info;
    }
    //用户身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String username=authenticationToken.getPrincipal().toString();
        //获取该用户的所有信息
        SysUser sysUser = null;
        try {
            sysUser = sysUserService.selectByUserName(username);
            //保存账号密码
            SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(
                    sysUser.getUsername(),sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getSalt()),this.getName()
            );
            return info;
        } catch (Exception e) {
            return null;
        }
//        if(null==sysUser){
//            return null;
//        }
    }
}
