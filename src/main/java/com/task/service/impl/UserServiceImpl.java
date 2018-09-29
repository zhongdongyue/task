package com.task.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.task.dao.mapper.GroupMapper;
import com.task.domain.MD5Util;
import com.task.domain.Pager;
import com.task.entity.Group;
import com.task.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.dao.mapper.RoleMapper;
import com.task.dao.mapper.UserMapper;
import com.task.domain.ResponseCode;
import com.task.entity.User;
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
    private GroupMapper groupMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User getById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }


    @Override
    public User getByName(String username) {
        User user = userMapper.selectByName(username);
        return user;
    }

    @Override
    public User getByAccountAndPwd(String userName, String password) {
//        password = MD5Util.encode(password,null);
        return userMapper.selectByNameAndPassword(userName, password);
    }

    @Override
    public Pager<User> getPageByGroupId(int pageNum, int pageSize, String groupId) {
        PageInfo<User> sqlPage = new PageInfo<>(userMapper.selectByGroupId(pageNum,pageSize,groupId));
        return new Pager<>(sqlPage.getPageNum(), sqlPage.getPageSize(), sqlPage.getTotal(), sqlPage.getList());
    }

    @Override
    public void updatePassword(String userName, String oldPwd, String password) {
        User accountUser = getByAccountAndPwd(userName, oldPwd);
        if (accountUser == null) {
            throw new BusinessException(ResponseCode.OLD_PASSWORD_ERROR,"旧密码有误");
        }
    }


    /**
     * 创建单个用户
     * @param user
     */
    @Override
    public void create(User user) {
        User userByAccount = userMapper.selectByName(user.getUsername());
        if (userByAccount != null) {
            throw new BusinessException(ResponseCode.USER_ACCOUNT_IN_USE,"用户帐号已被使用：" + user.getUsername());
        }
        Group group = groupMapper.selectByName("默认分组");
        Role role = roleMapper.selectByName("general_user");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setGroupId(group.getId());
        user.setRoleId(role.getId());
        user.setStatus(0);
        user.setPassword(MD5Util.encode(user.getPassword(),null));
        userMapper.insert(user);
    }

    @Override
    public User update(User user) {
        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKey(user);
        return user;
    }

    @Override
    public void delete(List<String> userIds) {
        for (String userId : userIds) {
            this.delete(userId);
        }
    }


    @Override
    public void delete(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

}
