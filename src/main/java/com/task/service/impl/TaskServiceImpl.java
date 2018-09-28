package com.task.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.dao.mapper.TaskMapper;
import com.task.domain.ResponseCode;
import com.task.entity.Task;
import com.task.exception.BusinessException;
import com.task.service.ITaskService;

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

    @Override
    public void complete(String id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        if(null==task){
            throw new BusinessException(ResponseCode.TASK_NOT_EXIST,"任务不存在");
        }
        task.setState(8);
        task.setUpdateTime(new Date());
        taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public void apply(String id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        if(null == task){
            throw new BusinessException(ResponseCode.TASK_NOT_EXIST,"任务不存在");
        }
        if (task.getState()==1){
            throw new BusinessException(ResponseCode.TASK_APPLIED,"任务已被申请，请尝试刷新页面");
        }
        //TODO 用户ID
        List<Task> unCompleteTasks = taskMapper.selectUncomplete("1");
        if(null!=unCompleteTasks||!unCompleteTasks.isEmpty()){
            throw new BusinessException(ResponseCode.TASK_NOT_COMPLETE,"有未完成任务，无法申请");
        }
        //TODO 用户ID
        List<Task> tasks = taskMapper.selectByReceiveTime("1");
        if(null!=tasks||!tasks.isEmpty()){
            throw new BusinessException(ResponseCode.TASK_APPLY_FREQUENTLY,"20分钟内只能申请一次");
        }
        //TODO 用户ID
        List<Task> countTasks = taskMapper.selectByDays("1");
        if(null!=countTasks||!countTasks.isEmpty()){
            throw new BusinessException(ResponseCode.TASK_COUNT_OUT,"每天最多申请10个任务");
        }
        task.setState(1);
        taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public void approve(String id, int state) {
        Task task = taskMapper.selectByPrimaryKey(id);
        if(null == task){
            throw new BusinessException(ResponseCode.TASK_NOT_EXIST,"任务不存在");
        }
        if(task.getState() == 2){
            throw new BusinessException(ResponseCode.TASK_REFUSE,"任务申请已被拒绝，无法操作");
        }
        if(state==2){
            task.setState(0);
            task.setReceiveUserId(null);
            task.setReceiveTime(null);
            taskMapper.updateByPrimaryKey(task);
        }
        if(state == 1){
            task.setState(8);
            taskMapper.updateByPrimaryKey(task);
        }
    }
}
