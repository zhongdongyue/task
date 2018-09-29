package com.task.service;


import com.task.domain.Pager;
import com.task.entity.Group;
import com.task.entity.User;

import java.util.List;


/**
 * 用户组 业务类
 */
public interface IGroupService {

    /**
     * 创建用户组
     * @param userGroup 用户组
     * @return  创建后的用户组
     */
    Group create(Group userGroup);

    /**
     * 批量删除用户组
     * @param groupId  用户组ID
     */
    void delete(String groupId);


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
    Group getById(String id);

    /**
     * 根据名称获取用户组信息
     * @param name 组名
     * @return
     */
    Group getByName(String name);

    /**
     * 查询用户可看到的分组
     * @param user
     * @return
     */
    List<Group> selectByUserId(User user);

    Pager<Group> selectAllByPage(int pageNum, int pageSize);
}
