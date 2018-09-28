package com.task.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.dao.mapper.RoleMapper;
import com.task.dao.mapper.UserGroupMapper;
import com.task.dao.mapper.UserGroupRelationMapper;
import com.task.dao.mapper.UserMapper;
import com.task.domain.ResponseCode;
import com.task.entity.User;
import com.task.entity.UserGroup;
import com.task.entity.UserGroupRelation;
import com.task.exception.BusinessException;
import com.task.service.UserService;


/**
 * CLASS_NAME
 *
 * @author shenbing
 * @version 2018/1/22
 * @since since
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserGroupRelationMapper userGroupRelationMapper;

    private static final String USER_NODE_TYPE = "user";

    private static final String ORG_NODE_TYPE = "org";

    private static final String GROUP_NODE_TYPE = "group";

    private static final String USER_ICON = "icon-newuser";

    private static final String ORG_ICON = "icon-orggroup";

    private static final String GROUP_ICON = "icon-usergroup";

    @Override
    public User getById(String id) {
        return userMapper.selectById(id);
    }


    @Override
    public User getByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    @Override
    public User getByAccountAndPwd(String account, String password) {
        return userMapper.selectByAccountAndPassword(account, password);
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }

    @Override
    public void updatePassword(String userId, String oldPwd, String password) {
        User user = getById(userId);
        User accountUser = getByAccountAndPwd(user.getUsername(), oldPwd);
        if (accountUser == null) {
            throw new BusinessException(ResponseCode.OLD_PASSWORD_ERROR,"旧密码有误");
        }
    }


    @Override
    public boolean validateAccount(String account) {
        return getByAccount(account) == null;
    }



    @Override
    public void create(User user) {

    }

    /**
     * 创建单个用户
     * @param user
     */
    private void createUser(User user) {
        User userByAccount = userMapper.selectByAccount(user.getUsername());
        if (userByAccount != null) {
            throw new BusinessException(ResponseCode.USER_ACCOUNT_IN_USE,"用户帐号已被使用：" + user.getUsername());
        }
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
        UserGroupRelation userGroupRelation = new UserGroupRelation();
        userGroupRelation.setUserId(user.getId());
        userGroupRelation.setUserGroupId("1");
        userGroupRelationMapper.insert(userGroupRelation);
    }

    @Override
    public User update(User user) {
        User userById = userMapper.selectById(user.getId());
        userById.setUpdateTime(new Date());
        userMapper.updateById(userById);
        return userMapper.selectById(user.getId());
    }

    @Override
    public void delete(List<String> userIds) {
        for (String userId : userIds) {
            this.delete(userId);
        }
    }


    @Override
    public void delete(String id) {

        // 解除用户组成员关系
        List<UserGroup> userGroups = userGroupMapper.selectByUserId(id);
        for (UserGroup userGroup : userGroups) {
            userGroupMapper.deleteUserRelation(userGroup.getId(), id);
        }
        userMapper.deleteById(id);
    }

    /**
     * 判断用户是否已经存在
     *
     * @param existsGroupMembers 用户组成员
     * @param user 用户信息
     * @return true：用户存在用户组成员中
     * @since 1.0.0
     */
    private boolean existsGroupMembers(List<User> existsGroupMembers, User user) {
        for (User item : existsGroupMembers) {
            if (item.getId().equals(user.getId())) {
                return true;
            }
        }
        return false;
    }
}
