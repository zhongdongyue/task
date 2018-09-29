package com.task.dao.mapper;

import java.util.List;

import com.task.entity.Group;

public interface GroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(Group record);

    Group selectByPrimaryKey(String id);

    List<Group> selectAll();

    int updateByPrimaryKey(Group record);
}