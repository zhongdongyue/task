package com.task.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.task.entity.UserGroup;

@Repository
public interface UserGroupMapper {
    int delete(String id);

    int insert(UserGroup record);

    UserGroup selectById(String id);

    List<UserGroup> selectAll();

    /**
     * 添加组织成员关系
     */
    void addUserRelation(@Param("groupId") String groupId, @Param("userId") String userId);

    /**
     * 删除组织成员关系
     */
    void deleteUserRelation(@Param("groupId") String groupId, @Param("userId") String userId);

    /**
     * 根据用户 ID获取所有绑定的分组
     * @param userId    用户ID
     * @return  用户组列表
     */
    List<UserGroup> selectByUserId(@Param("userId") String userId);

    UserGroup selectByName(String name);
}
