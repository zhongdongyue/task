package com.task.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.task.domain.Pager;
import com.task.entity.User;
import com.task.service.UserService;
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

    @Autowired
    private UserService userService;

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
        Task oldTask = taskMapper.selectByPrimaryKey(task.getId());
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
    public Pager<Task> selectPending(int pageNum, int pageSize) {
        PageInfo<Task> sqlPage = new PageInfo<>(taskMapper.selectPending(pageNum,pageSize));
        return new Pager<>(sqlPage.getPageNum(), sqlPage.getPageSize(), sqlPage.getTotal(), sqlPage.getList());
    }

    @Override
    public List<Task> selectMinuteByUserId(String userId) {
        List<Task> tasks = taskMapper.selectMinuteByUserId(userId);
        return tasks;
    }

    @Override
    public Pager<Task> selectByUserId(int pageNum,int pageSize,String userId) {
        PageInfo<Task> sqlPage = new PageInfo<>(taskMapper.selectByUserId(pageNum,pageSize,userId));
        return new Pager<>(sqlPage.getPageNum(), sqlPage.getPageSize(), sqlPage.getTotal(), sqlPage.getList());
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
        task.setStatus(3);
        task.setUpdateTime(new Date());
        taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public void receive(String id,String userId) {
        User user = userService.getById(userId);
        if(user.equals("general_user")){
            throw new BusinessException(ResponseCode.NOT_TASK_PERMISSION,"无领取任务权限，请先申请");
        }
        Task task = taskMapper.selectByPrimaryKey(id);
        if(null == task){
            throw new BusinessException(ResponseCode.TASK_NOT_EXIST,"任务不存在");
        }
        if (task.getStatus()==1){
            throw new BusinessException(ResponseCode.TASK_APPLIED,"任务已被领取，请尝试刷新页面");
        }
         Task unTasks= taskMapper.selectUncomplete(userId);
        if(null!=unTasks){
            throw new BusinessException(ResponseCode.TASK_NOT_COMPLETE,"有未完成任务，无法领取");
        }
        List<Task> tasks = taskMapper.selectMinuteByUserId(userId);
        if(null!=tasks&&!tasks.isEmpty()){
            throw new BusinessException(ResponseCode.TASK_APPLY_FREQUENTLY,"20分钟内只能领取一次");
        }
        List<Task> countTasks = taskMapper.selectByDays(userId);
        if(null!=countTasks && !countTasks.isEmpty()){
            throw new BusinessException(ResponseCode.TASK_COUNT_OUT,"每天最多领取10个任务");
        }
        task.setStatus(1);
        task.setUserId(userId);
        task.setReceiveTime(new Date());
        taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public Pager<Task> selectAll(int pageNum, int pageSize) {
        PageInfo<Task> sqlPage = new PageInfo<>(taskMapper.selectAll(pageNum,pageSize));
        return new Pager<>(sqlPage.getPageNum(), sqlPage.getPageSize(), sqlPage.getTotal(), sqlPage.getList());
    }
}
