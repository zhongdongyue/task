package com.task.dao.mapper;

import java.util.List;

import com.task.entity.Task;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(Task record);

    Task selectByPrimaryKey(String id);

    List<Task> selectAll(@Param("pageNum") int pageNum, @Param("pageSize")int pageSize );

    int updateByPrimaryKey(Task record);

    /**
     * 查询7天内可以领取的任务
     * @return
     */
    List<Task> selectPending(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

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
    List<Task> selectByUserId(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize,@Param("userId") String userId);

    /**
     * 查询用户当天领取多少任务
     * @param userId
     * @return
     */
    List<Task>selectByDays(String userId);

    /**
     * 查看用户未完成任务
     * @param id
     */
    Task selectUncomplete(String id);

}