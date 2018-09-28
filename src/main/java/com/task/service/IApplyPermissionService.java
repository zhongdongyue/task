package com.task.service;

import java.util.List;

import com.task.entity.ApplyPermission;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/28
 * @since since
 */
public interface IApplyPermissionService {

    void insert(ApplyPermission applyPermission);

    void delete(String id);

    void update(ApplyPermission applyPermission);

    List<ApplyPermission> selectAll();
}
