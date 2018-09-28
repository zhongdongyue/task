package com.task.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dao.mapper.ApplyPermissionMapper;
import com.task.entity.ApplyPermission;
import com.task.service.IApplyPermissionService;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/28
 * @since since
 */
@Service
public class ApplyPermissionServiceImpl implements IApplyPermissionService {

    @Autowired
    private ApplyPermissionMapper applyPermissionMapper;

    @Override
    public void insert(ApplyPermission applyPermission) {
        applyPermission.setCreateTime(new Date());
        applyPermission.setUpdateTime(new Date());
        applyPermissionMapper.insert(applyPermission);
    }

    @Override
    public void delete(String id) {
        applyPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ApplyPermission applyPermission) {
        applyPermission.setUpdateTime(new Date());
        applyPermissionMapper.updateByPrimaryKey(applyPermission);
    }

    @Override
    public List<ApplyPermission> selectAll() {
        return applyPermissionMapper.selectAll();
    }
}
