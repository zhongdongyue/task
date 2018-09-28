package com.task.service;

import com.task.entity.Task;

import java.util.List;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/16
 * @since since
 */
public interface ITaskService {
    void deleteByPrimaryKey(String id);

    void insert(Task task);

    void updateByPrimaryKey(Task task);

    Task selectByPrimaryKey(String id);

    /**
     * 查询7天内任务
     * @return
     */
    List<Task> selectPending();

    /**
     * 查询20天之内领取的任务
     * @param userId
     * @return
     */
    List<Task> selectByReceiveTime(String userId);

    /**
     * 查询用户下任务
     * @param userId
     * @return
     */
    List<Task> selectByUserId(String userId);

    /**
     * 查询用户当前领取多少任务
     * @param userId
     * @return
     */
    List<Task>selectByDays(String userId);
}
