package com.task.service;

import com.task.entity.User;

import java.util.List;


/**
 * 用户管理 业务类
 *
 * @author shenbing
 * @version 2018/1/22
 * @since since
 */
public interface UserService {

    /**
     * 根据用户ID获取用户
     *
     * @param id 用户ID
     * @return 用户
     */
    User getById(String id);


    /**
     * 创建用户, 并绑定到指定的组织上
     *
     * @param user 用户信息
     * @return 创建后的用户
     */
    void create(User user);

    /**
     * 修改用户
     *
     * @param user 用户信息
     * @return 修改后的用户信息
     */
    User update(User user);

    /**
     * 删除用户
     *
     * @param id 用户ID
     */
    void delete(String id);

    /**
     * 删除用户
     *
     * @param userIds 用户ID集合
     */
    void delete(List<String> userIds);

    /**
     * 根据帐号获取用户信息
     *
     * @param account 用户帐号
     * @return 用户信息
     */
    User getByAccount(String account);

    /**
     * 根据用户帐号和密码获取用户
     *
     * @param account 帐号
     * @param password 密码
     * @return 用户信息
     */
    User getByAccountAndPwd(String account, String password);

    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> getAll();

    /**
     * 修改用户密码
     *
     * @param userId
     * @param oldPwd
     * @param password
     */
    void updatePassword(String userId, String oldPwd, String password);

    /**
     * 校验帐号是否可用
     * @param account   帐号
     * @return  true：帐号可被使用
     */
    boolean validateAccount(String account);
}
