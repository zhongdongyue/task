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
     * 查询用户下任务
     * @param userId
     * @return
     */
    Pager<Task> selectByUserId(int pageNum,int pageSize,String userId);

    /**
     * 查询所有任务
     * @param pageNum
     * @param pageSize
     * @return
     */
    Pager<Task> selectAll(int pageNum,int pageSize);

    /**
     * 完成任务
     * @param id
     * @param userId
     */
    void complete(String id,String userId);

    /**
     * 领取任务
     * @param id
     * @param userId
     */
    void receive(String id,String userId);
}
