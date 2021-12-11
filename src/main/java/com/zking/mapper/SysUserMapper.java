package com.zking.mapper;

import com.zking.model.SysUser;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysUser record);

    /**
     * 根据用户名获取个人信息
     * @param username  用户名
     * @return
     */
    public SysUser selectByUserName(String username);

    /**
     * 根据用户名获取角色
     * @param userName
     * @return
     */
    public Set<String> getRoleByUserName(String userName);

    /**
     * 根据用户名获取权限信息
     * @param username
     * @return
     */
    public Set<String> getPermissionByUserName(String username);

    /**
     * 查看所有用户
     * @return
     */
    List<SysUser> list();
}