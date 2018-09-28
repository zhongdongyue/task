package com.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dao.mapper.UserGroupRelationMapper;
import com.task.entity.UserGroupRelation;
import com.task.service.IUserGroupRelationService;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/21
 * @since since
 */
@Service
public class UserGroupRelationServiceImpl implements IUserGroupRelationService {
    @Autowired
    private UserGroupRelationMapper userGroupRelationMapper;
    @Override
    public void deleteByPrimaryKey(String id) {
        userGroupRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(UserGroupRelation userGroupRelation) {
        userGroupRelationMapper.insert(userGroupRelation);
    }

    @Override
    public void updateByPrimaryKey(UserGroupRelation userGroupRelation) {
        userGroupRelationMapper.updateByPrimaryKey(userGroupRelation);
    }

    @Override
    public UserGroupRelation selectByPrimaryKey(String id) {
        return userGroupRelationMapper.selectByPrimaryKey(id);
    }
}
