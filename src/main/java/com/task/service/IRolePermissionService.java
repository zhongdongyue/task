package com.task.service;

import com.task.entity.RolePermission;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/18
 * @since since
 */
public interface IRolePermissionService {

    void deleteByPrimaryKey(String id);

    void insert(RolePermission rolePermission);

    void updateByPrimaryKey(RolePermission rolePermission);

    RolePermission selectByPrimaryKey(String id);
}
