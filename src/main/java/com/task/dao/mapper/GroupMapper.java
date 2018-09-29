package com.task.dao.mapper;

import java.util.List;

import com.task.entity.Group;
import org.apache.ibatis.annotations.Param;

public interface GroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(Group record);

    Group selectByPrimaryKey(String id);

    List<Group> selectAll();

    int updateByPrimaryKey(Group record);

    /**
     * 根据名称查询分组
     * @param name
     * @return
     */
    Group selectByName(String name);

    List<Group> selectAllByPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}