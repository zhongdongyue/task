package com.task.service.impl;

import com.task.dao.mapper.RolePermissionMapper;
import com.task.entity.RolePermission;
import com.task.service.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/18
 * @since since
 */
@Service
@Transactional
public class RolePermissionServiceImpl implements IRolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public void deleteByPrimaryKey(String id) {
        rolePermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(RolePermission rolePermission) {
        rolePermissionMapper.insert(rolePermission);
    }

    @Override
    public void updateByPrimaryKey(RolePermission rolePermission) {
        rolePermissionMapper.updateByPrimaryKey(rolePermission);
    }

    @Override
    public RolePermission selectByPrimaryKey(String id) {
        return rolePermissionMapper.selectByPrimaryKey(id);
    }
}
