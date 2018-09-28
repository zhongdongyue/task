package com.task.dao.mapper;

import java.util.List;

import com.task.entity.UserGroupRelation;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/19
 * @since since
 */
@Repository
public interface UserGroupRelationMapper {

    int deleteByPrimaryKey(String id);

    int insert(UserGroupRelation record);

    UserGroupRelation selectByPrimaryKey(String id);

    int updateByPrimaryKey(UserGroupRelation record);

    List<UserGroupRelation> selectAll();

    void deleteByGroupId(@Param("groupId") String groupId);

    UserGroupRelation selectByUserIdAndGroupId(@Param("userId") String userId, @Param("groupId") String groupId);
}
