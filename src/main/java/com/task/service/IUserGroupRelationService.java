package com.task.service;

import com.task.entity.UserGroupRelation;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/20
 * @since since
 */

public interface IUserGroupRelationService {

    void deleteByPrimaryKey(String id);

    void insert(UserGroupRelation userGroupRelation);

    void updateByPrimaryKey(UserGroupRelation userGroupRelation);

    UserGroupRelation selectByPrimaryKey(String id);
}
