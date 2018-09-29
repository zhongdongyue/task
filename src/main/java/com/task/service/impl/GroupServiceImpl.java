package com.task.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.task.dao.mapper.GroupMapper;
import com.task.entity.Group;
import com.task.entity.User;
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

    @Override
    public Group create(Group userGroup) {
        userGroup.setCreateTime(new Date());
        groupMapper.insert(userGroup);
        return groupMapper.selectByPrimaryKey(userGroup.getId());
    }

    @Override
    public void delete(String groupId) {
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
}
