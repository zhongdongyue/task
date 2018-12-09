package com.task.service;

import java.util.List;

import com.task.domain.Pager;
import com.task.entity.User;


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
     * @param username 用户帐号
     * @return 用户信息
     */
    User getByName(String username);

    /**
     * 根据用户帐号和密码获取用户
     *
     * @param account 帐号
     * @param password 密码
     * @return 用户信息
     */
    User getByAccountAndPwd(String account, String password);

    /**
     * 修改用户密码
     *
     * @param userName
     * @param oldPwd
     * @param password
     */
    void updatePassword(String userName, String oldPwd, String password,String phone);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param groupId
     * @return
     */
    Pager<User> getPageByGroupId(int pageNum, int pageSize, String groupId);

    /**
     * 获取申请领取权限的列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    Pager<User> getAapplyPage(int pageNum,int pageSize);

    void applyPass(String userId);

    void applyRefuse(String userId);

    /**
     * 根据搜索内容查找搜索用户
     * @param pageNum
     * @param pageSize
     * @param content
     * @return
     */
    Pager<User> searchApplyUserByContent(int pageNum,int pageSize,String content);
}
