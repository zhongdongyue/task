package com.task.controller.api;

import java.util.List;

import com.task.entity.User;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理 视图控制器
 *
 * @author shenbing
 * @version 2018/1/22
 * @since since
 */
@Controller
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据ID获取用户
     *
     * @param id 用户ID
     * @return 用户
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    /**
     * 创建用户
     *
     * @param user 用户信息
     * @return 创建后的用户
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void create(@RequestBody User user) {
        userService.create(user);
    }


    /**
     * 修改用户
     *
     * @param user 用户信息
     * @return 修改后的用户信息
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "{id}/password", method = RequestMethod.PUT)
    @ResponseBody
    public void updatePassword(@PathVariable("id") String userId, String oldPwd,String password) {
        userService.updatePassword(userId, oldPwd, password);
    }

    /**
     * 批量删除用户
     *
     * @param userIds 用户ID
     */
    @RequestMapping(value = "{userIds}")
    @ResponseBody
    public void delete(@PathVariable("userIds") List<String> userIds) {
        userService.delete(userIds);
    }

    /**
     * 校验帐号是否可用
     *
     * @param userName 用户帐号
     * @return 帐号校验结果
     */
    @RequestMapping(value = "username/validation", method = RequestMethod.GET)
    @ResponseBody
    public Boolean validateAccount(String userName) {
        User user = userService.getByName(userName);
        if(user == null){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

}
