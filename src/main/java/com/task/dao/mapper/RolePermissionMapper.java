package com.task.dao.mapper;

import java.util.List;

import com.task.entity.RolePermission;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(RolePermission record);

    RolePermission selectByPrimaryKey(String id);

    List<RolePermission> selectAll();

    int updateByPrimaryKey(RolePermission record);
}