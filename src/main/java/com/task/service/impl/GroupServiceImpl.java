package com.task.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.task.dao.mapper.GroupMapper;
import com.task.dao.mapper.UserMapper;
import com.task.domain.Pager;
import com.task.domain.ResponseCode;
import com.task.entity.Group;
import com.task.entity.User;
import com.task.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.service.IGroupService;
import com.task.service.UserService;

@Service
@Transactional
public class GroupServiceImpl implements IGroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Group create(Group userGroup) {
        userGroup.setCreateTime(new Date());
        groupMapper.insert(userGroup);
        return groupMapper.selectByPrimaryKey(userGroup.getId());
    }

    @Override
    public void delete(String groupId) {
        Group group = groupMapper.selectByPrimaryKey(groupId);
        if("默认分组".equals(group.getName())){
            throw new BusinessException(3011,"默认分组无法删除");
        }
        List<User> users = userMapper.selectByGroupId(1,1,groupId);
        if(users!=null && !users.isEmpty()){
            throw new BusinessException(ResponseCode.USER_GROUP_CAN_NOT_DELETE,"用户组下存在用户，无法删除");
        }
        groupMapper.deleteByPrimaryKey(groupId);
    }

    @Override
    public boolean validateName(String name) {
        return groupMapper.selectByName(name) == null;
    }

    @Override
    public Group getById(String id) {
        return groupMapper.selectByPrimaryKey(id);
    }

    @Override
    public Group getByName(String name) {
        return groupMapper.selectByName(name);
    }

    @Override
    public List<Group> selectByUserId(User user) {
        if("admin".equals(user.getRoleName())){
            List<Group> groups = groupMapper.selectAll();
            return groups;
        }else {
            List<Group> groups = new ArrayList<>();
            Group group = groupMapper.selectByName(user.getGroupName());
            groups.add(group);
            return groups;
        }
    }

    @Override
    public Pager<Group> selectAllByPage(int pageNum, int pageSize) {
        PageInfo<Group> sqlPage = new PageInfo<>(groupMapper.selectAllByPage(pageNum,pageSize));
        return new Pager<>(sqlPage.getPageNum(), sqlPage.getPageSize(), sqlPage.getTotal(), sqlPage.getList());
    }
}
