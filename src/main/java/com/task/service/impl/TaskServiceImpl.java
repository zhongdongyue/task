package com.task.service.impl;

import java.util.Date;
import java.util.List;

import com.task.dao.mapper.TaskMapper;
import com.task.domain.ResponseCode;
import com.task.entity.Task;
import com.task.exception.BusinessException;
import com.task.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/16
 * @since since
 */
@Service
@Transactional
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public void deleteByPrimaryKey(String id) {
        taskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(Task task) {
        task.setCreateTime(new Date());
        taskMapper.insert(task);
    }

    @Override
    public void updateByPrimaryKey(Task task) {
        task.setUpdateTime(new Date());
        taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public Task selectByPrimaryKey(String id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        if(task==null){
            throw new BusinessException(ResponseCode.TASK_NOT_EXIST,"任务不存在");
        }
        return task;
    }

    @Override
    public List<Task> selectPending() {
        List<Task> tasks = taskMapper.selectPending();
        return tasks;
    }

    @Override
    public List<Task> selectByReceiveTime(String userId) {
        List<Task> tasks = taskMapper.selectByReceiveTime(userId);
        return tasks;
    }

    @Override
    public List<Task> selectByUserId(String userId) {
        List<Task> tasks = taskMapper.selectByUserId(userId);
        return tasks;
    }

    @Override
    public List<Task> selectByDays(String userId) {
        List<Task> tasks = taskMapper.selectByDays(userId);
        return tasks;
    }
}
