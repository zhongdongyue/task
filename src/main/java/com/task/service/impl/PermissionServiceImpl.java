package com.task.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.dao.mapper.PermissionMapper;
import com.task.entity.Permission;
import com.task.entity.User;
import com.task.service.IPermissionService;


/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/2/7
 * @since since
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
//
//    @Autowired
//    private PermissionMapper permissionMapper;
//
//    @Override
//    public List<Permission> getByUserAndModuleCode(User user, String permissionCode) {
//        List<Permission> permissions = new ArrayList<>();
//        List<Permission> sysAdminPermissions = permissionMapper.selectByNameAndCode(user.getSysRole(),permissionCode);
//        permissions.addAll(sysAdminPermissions);
//        permissions = permissions.stream().distinct().collect(Collectors.toList());
//        return permissions;
//    }
}
