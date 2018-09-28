package com.task.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.task.entity.ApplyPermission;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/28
 * @since since
 */
@Repository
public interface ApplyPermissionMapper {

    int deleteByPrimaryKey(String id);

    int insert(ApplyPermission record);

    ApplyPermission selectByPrimaryKey(String id);

    List<ApplyPermission> selectAll();

    int updateByPrimaryKey(ApplyPermission record);
}
