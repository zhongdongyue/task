package com.task.dao.mapper;

import java.util.List;

import com.task.entity.Task;

public interface TaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(Task record);

    Task selectByPrimaryKey(String id);

    List<Task> selectAll();

    int updateByPrimaryKey(Task record);
}