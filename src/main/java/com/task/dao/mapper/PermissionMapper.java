package com.task.dao.mapper;

import java.util.List;

import com.task.entity.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper {
    /**
     * 根据ID删除功能
     * @param id 功能ID
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 添加功能
     * @param record
     * @return
     */
    int insert(Permission record);

    /**
     * 根据功能ID查询功能
     * @param id 功能ID
     * @return
     */
    Permission selectByPrimaryKey(String id);

    /**
     * 查询所有的功能
     * @return
     */
    List<Permission> selectAll();

    /**
     * 更新功能列表
     * @param record
     * @return
     */
    int updateByPrimaryKey(Permission record);

    /**
     *根据角色ID和模块code查询功能
     * @param roleName 角色名称
     * @param permissionModuleCode 模块code
     * @return 模块权限列表
     */
    List<Permission> selectByNameAndCode(String roleName, String permissionModuleCode);
}