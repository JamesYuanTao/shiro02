package com.zking.service.impl;

import com.zking.mapper.SysUserMapper;
import com.zking.model.SysUser;
import com.zking.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return sysUserMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Integer userid) {
        return sysUserMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public SysUser selectByUserName(String username) {
        return sysUserMapper.selectByUserName(username);
    }

    @Override
    public Set<String> getRoleByUserName(String userName) {
        return sysUserMapper.getRoleByUserName(userName);
    }

    @Override
    public Set<String> getPermissionByUserName(String username) {
        return sysUserMapper.getPermissionByUserName(username);
    }

    @Override
    public List<SysUser> list() {
        return sysUserMapper.list();
    }
}
