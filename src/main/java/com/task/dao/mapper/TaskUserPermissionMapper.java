package com.task.dao.mapper;

import com.task.entity.TaskUserPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/10/16
 * @since since
 */
public interface TaskUserPermissionMapper {

    int deleteByPrimaryKey(String id);

    int insert(TaskUserPermission record);

    int updateByPrimaryKey(TaskUserPermission record);

    List<TaskUserPermission> selectByTaskId(String taskId);

    TaskUserPermission selectByUserIdAndTaskId(@Param("userId") String userId, @Param("taskId") String taskId);

    /**
     * 查看用户未完成任务
     * @param id
     */
    TaskUserPermission selectUncomplete(String id);

    /**
     * 查询用户20分钟之内领取的任务
     * @param userId
     * @return
     */
    List<TaskUserPermission> selectMinuteByUserId(String userId);

    /**
     * 查询用户当天领取多少任务
     * @param userId
     * @return
     */
    List<TaskUserPermission>selectByDays(String userId);

    void deleteByTaskId(@Param("taskId") String taskId);

    /**
     * 获取领取任务的用户名称集合
     * @param taskId
     * @return
     */
    List<String> getTaskUserNames(@Param("taskId") String taskId);
}
