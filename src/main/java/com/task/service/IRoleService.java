package com.task.service;

import com.task.entity.Role;

import java.util.List;

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
