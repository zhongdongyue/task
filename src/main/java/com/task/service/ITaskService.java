package com.task.service;

import java.util.List;

import com.task.domain.Pager;
import com.task.entity.Task;

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
     * 查询7天内可以领取的任务
     * @return
     */
    Pager<Task> selectPending(int pageNum, int size);

    /**
     * 查询用户20分钟之内领取的任务
     * @param userId
     * @return
     */
    List<Task> selectMinuteByUserId(String userId);

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

    /**
     * 完成任务
     * @param id
     */
    void complete(String id);

    /**
     * 申请任务
     * @param id
     * @param userId
     */
    void receive(String id,String userId);
}
