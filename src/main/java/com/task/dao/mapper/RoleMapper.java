package com.task.dao.mapper;


import java.util.List;

import com.task.entity.Role;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role role);

    Role selectByPrimaryKey(String id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role role);

    /**
     * 获取租户用户的角色
     * 
     * @param tenantId 租户ID
     * @param userId 角色ID
     * @return 角色
     */
    Role selectByTenantIdAndUserId(@Param("tenantId") String tenantId, @Param("userId") String userId);

    /**
     * 根据计算机目录ID和用户名获取用户在租户中角色
     * 
     * @param catalogId 计算机目录ID
     * @param account 用户名
     * @return
     */
    Role selectUserRoleByCatalogIdAndUserId(@Param("catalogId") String catalogId, @Param("account") String account);

    /**
     * 根据计算机ID、用户ID、角色名称查询在租户中角色信息
     * 
     * @param machineId
     * @param userId
     * @param roleName
     * @return
     */
    Role selectByMachineIdAndUserIdAndName(@Param("machineId") String machineId, @Param("userId") String userId,
                                           @Param("roleName") String roleName);

    /**
     * 根据名称查询角色
     * 
     * @param roleName 角色名
     * @return 角色
     */
    Role selectByName(String roleName);
}
