package com.task.dao.mapper;

import java.util.List;

import com.task.entity.Task;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(Task record);

    Task selectByPrimaryKey(String id);

    List<Task> selectAll();

    int updateByPrimaryKey(Task record);

    List<Task> selectPending();

    List<Task> selectByReceiveTime(@Param("userId") String userId);

    List<Task> selectByUserId(@Param("userId") String userId);

    List<Task> selectByDays(@Param("userId") String userId);
}