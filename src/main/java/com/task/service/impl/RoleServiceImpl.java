package com.task.service.impl;

import com.task.dao.mapper.RoleMapper;
import com.task.entity.Role;
import com.task.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAll() {
        List<Role> roles = roleMapper.selectAll();
        return roles;
    }
}
