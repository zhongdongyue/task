package com.task.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.task.entity.UserGroupRelation;

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
