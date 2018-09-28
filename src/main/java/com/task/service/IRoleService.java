package com.task.service;

import java.util.List;

import com.task.entity.Role;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/1/30
 * @since since
 */
public interface IRoleService {
    /**
     * 获取所有的角色
     * @return
     */
    List<Role> getAll();
}
