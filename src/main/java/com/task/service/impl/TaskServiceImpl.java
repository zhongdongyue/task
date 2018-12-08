package com.task.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.task.dao.mapper.TaskUserPermissionMapper;
import com.task.domain.Pager;
import com.task.entity.TaskUserPermission;
import com.task.entity.User;
import com.task.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private TaskUserPermissionMapper taskUserPermissionMapper;

    @Value("${task.count}")
    private int taskCount;

    @Override
    public void deleteByPrimaryKey(String id) {
        taskUserPermissionMapper.deleteByTaskId(id);
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
        if(oldTask==null){
            throw new BusinessException(ResponseCode.TASK_NOT_EXIST,"任务不存在");
        }
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
        List<Task> tasks = sqlPage.getList();
        if(tasks!=null&&!tasks.isEmpty()){
            tasks.forEach((task) -> {
                //获取任务剩余个数
                List<TaskUserPermission> taskUserPermissions = taskUserPermissionMapper.selectByTaskId(task.getId());
                if(null!=taskUserPermissions&&!taskUserPermissions.isEmpty()){
                    task.setRemainderCount(taskCount-taskUserPermissions.size());
                }else {
                    task.setRemainderCount(taskCount);
                }
            });
//            for(Task task:tasks){
//                //获取任务剩余个数
//                List<TaskUserPermission> taskUserPermissions = taskUserPermissionMapper.selectByTaskId(task.getId());
//                if(null!=taskUserPermissions&&!taskUserPermissions.isEmpty()){
//                    task.setRemainderCount(taskCount-taskUserPermissions.size());
//                }else {
//                    task.setRemainderCount(taskCount);
//                }
//            }
        }
        return new Pager<>(sqlPage.getPageNum(), sqlPage.getPageSize(), sqlPage.getTotal(), sqlPage.getList());
    }

    @Override
    public Pager<Task> selectByUserId(int pageNum,int pageSize,String userId) {
        PageInfo<Task> sqlPage = new PageInfo<>(taskMapper.selectByUserId(pageNum,pageSize,userId));
        return new Pager<>(sqlPage.getPageNum(), sqlPage.getPageSize(), sqlPage.getTotal(), sqlPage.getList());
    }

    @Override
    public void complete(String id,String userId) {
        TaskUserPermission taskUserPermission = taskUserPermissionMapper.selectByUserIdAndTaskId(userId,id);
        if(null==taskUserPermission){
            throw new BusinessException(ResponseCode.TASK_NOT_EXIST,"未领取该任务");
        }
        taskUserPermission.setStatus(1);
        taskUserPermission.setUpdateTime(new Date());
        taskUserPermissionMapper.updateByPrimaryKey(taskUserPermission);
    }

    @Override
    public void receive(String id,String userId) {
        User user = userService.getById(userId);
        if(user.getRoleName().equals("general_user")){
            throw new BusinessException(ResponseCode.NOT_TASK_PERMISSION,"无领取任务权限，请先申请");
        }
        Task task = taskMapper.selectByPrimaryKey(id);
        if(null == task){
            throw new BusinessException(ResponseCode.TASK_NOT_EXIST,"任务不存在");
        }
        TaskUserPermission checkTask = taskUserPermissionMapper.selectByUserIdAndTaskId(userId,id);
        if(checkTask!=null){
            throw new BusinessException(ResponseCode.TASK_RECEIVED,"任务已被领取，无法重复领取");
        }
        List<TaskUserPermission> taskUserPermissions = taskUserPermissionMapper.selectByTaskId(id);
        if(taskUserPermissions!=null && taskUserPermissions.size()==taskCount){
            throw new BusinessException(ResponseCode.TASK_RECEIVE_COUNT_OUT,"任务领取个数超出，无法领取");
        }
         TaskUserPermission unTasks= taskUserPermissionMapper.selectUncomplete(userId);
        if(null!=unTasks){
            throw new BusinessException(ResponseCode.TASK_NOT_COMPLETE,"有未完成任务，无法领取");
        }
        List<TaskUserPermission> tasks = taskUserPermissionMapper.selectMinuteByUserId(userId);
        if(null!=tasks&&!tasks.isEmpty()){
            throw new BusinessException(ResponseCode.TASK_APPLY_FREQUENTLY,"20分钟内只能领取一次");
        }
        List<TaskUserPermission> countTasks = taskUserPermissionMapper.selectByDays(userId);
        if(null!=countTasks && !countTasks.isEmpty()){
            throw new BusinessException(ResponseCode.TASK_COUNT_OUT,"每天最多领取10个任务");
        }
        TaskUserPermission taskUserPermission = new TaskUserPermission();
        taskUserPermission.setStatus(0);
        taskUserPermission.setTaskId(id);
        taskUserPermission.setUserId(userId);
        taskUserPermission.setCreateTime(new Date());
        taskUserPermission.setReceiveTime(new Date());
        taskUserPermissionMapper.insert(taskUserPermission);
        if(taskUserPermissions!=null){
            if(taskUserPermissions.size()+1==taskCount){
                task.setStatus(1);
            }
        }
        task.setReceiveTime(new Date());
        taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public Pager<Task> selectAll(int pageNum, int pageSize) {
        PageInfo<Task> sqlPage = new PageInfo<>(taskMapper.selectAll(pageNum,pageSize));
        List<Task> tasks = sqlPage.getList();
        if(tasks!=null&&!tasks.isEmpty()){
            for(Task task:tasks){
                List<String> names = taskUserPermissionMapper.getTaskUserNames(task.getId());
                if(names!=null&&!names.isEmpty()){
                    task.setUserName(StringUtils.join(names,";"));
                }

            }
        }
        return new Pager<>(sqlPage.getPageNum(), sqlPage.getPageSize(), sqlPage.getTotal(), sqlPage.getList());
    }
}
