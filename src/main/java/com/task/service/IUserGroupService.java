package com.task.service;

import com.task.entity.User;
import com.task.entity.UserGroup;

import java.util.List;


/**
 * 用户组 业务类
 */
public interface IUserGroupService {

    /**
     * 创建佳用户组
     * @param userGroup 用户组
     * @return  创建后的用户组
     */
    UserGroup create(UserGroup userGroup);

    /**
     * 批量删除用户组
     * @param groupId  用户组ID
     */
    void delete(String groupId);


    /**
     * 添加用户组成员
     * @param groupId   用户组ID
     * @param userId    用户ID
     */
    void addMember(String groupId, List<String> userId);

    /**
     * 移除用户组成员
     * @param groupId   用户组ID
     * @param userId    用户ID
     */
    void removeMember(String groupId, List<String> userId);

    /**
     * 获取用户组成员
     * @param groupId   用户组ID
     * @return  用户列表
     */
    List<User> getMembers(String groupId);

    /**
     * 校验用户组名称是否可用
     * @param name  用户组名称
     * @return  true：名称可用
     */
    boolean validateName(String name);

    /**
     * 根据ID获取用户组
     * @param id    用户组ID
     * @return  用户组
     */
    UserGroup getById(String id);
}
