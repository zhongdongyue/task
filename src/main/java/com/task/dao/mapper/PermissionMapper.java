package com.task.dao.mapper;

import java.util.List;

import com.task.entity.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Permission record);

    Permission selectByPrimaryKey(String id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);
}