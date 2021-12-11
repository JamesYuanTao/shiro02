package com.zking.service;

import com.zking.model.SysUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
public interface ISysUserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(SysUser record);

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

    List<SysUser> list();
}