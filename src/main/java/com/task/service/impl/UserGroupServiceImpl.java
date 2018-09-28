package com.task.service.impl;

import java.util.Date;
import java.util.List;

import com.task.dao.mapper.UserGroupMapper;
import com.task.dao.mapper.UserGroupRelationMapper;
import com.task.domain.ResponseCode;
import com.task.entity.User;
import com.task.entity.UserGroup;
import com.task.entity.UserGroupRelation;
import com.task.exception.BusinessException;
import com.task.service.IUserGroupService;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserGroupServiceImpl implements IUserGroupService {

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserGroupRelationMapper userGroupRelationMapper;

    @Override
    public UserGroup create(UserGroup userGroup) {
        userGroup.setCreateTime(new Date());
        userGroupMapper.insert(userGroup);
        return userGroupMapper.selectById(userGroup.getId());
    }

    @Override
    public void delete(String groupId) {
        userGroupRelationMapper.deleteByGroupId(groupId);
        userGroupMapper.delete(groupId);
    }

    @Override
    public void addMember(String groupId, List<String> userIds) {
        for(String userId : userIds) {
            UserGroupRelation userGroupRelation = userGroupRelationMapper.selectByUserIdAndGroupId(userId, groupId);
            if(userGroupRelation == null) {
                userGroupMapper.addUserRelation(groupId, userId);
            } else {
                throw new BusinessException( ResponseCode.USER_GROUP_ADD_REPEAT_USER,"用户被重复添加到用户组");
            }
        }
    }

    @Override
    public void removeMember(String groupId, List<String> userIds) {
        for(String userId : userIds) {
            UserGroupRelation userGroupRelation = userGroupRelationMapper.selectByUserIdAndGroupId(userId, groupId);
            if(userGroupRelation != null) {
                userGroupMapper.deleteUserRelation(groupId, userId);
            } else {
                throw new BusinessException( ResponseCode.USER_REMOVED_FROM_USER_GROUP,"用户已被移除用户组");
            }
        }
    }

    @Override
    public List<User> getMembers(String groupId) {
        return null;
    }

    @Override
    public boolean validateName(String name) {
        return userGroupMapper.selectByName(name) == null;
    }

    @Override
    public UserGroup getById(String id) {
        return userGroupMapper.selectById(id);
    }
}
