package com.task.controller.api;

import java.util.List;

import com.task.controller.BaseController;
import com.task.entity.User;
import com.task.entity.UserGroup;
import com.task.service.IUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户组 视图控制器
 *
 * @author shenbing
 * @version 2018/2/9
 * @since since
 */
@Controller
@RequestMapping("userGroups")
public class UserGroupController extends BaseController {

    @Autowired
    private IUserGroupService userGroupService;

    /**
     * 创建用户组
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public UserGroup userGroup(@RequestBody UserGroup userGroup) {
        return userGroupService.create(userGroup);
    }

    /**
     * 删除用户组
     */
    @RequestMapping(value = "{groupId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("groupId") String groupId) {
        userGroupService.delete(groupId);
    }

    /**
     * 获取用户组成员
     */
    @RequestMapping(value = "{groupId}/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserGroupMembers(@PathVariable("groupId") String groupId) {
        return userGroupService.getMembers(groupId);
    }

    /**
     * 添加用户组成员
     */
    @RequestMapping(value = "{groupId}/users", method = RequestMethod.POST)
    @ResponseBody
    public void addMember(@PathVariable("groupId") String groupId,List<String> userIds) {
        userGroupService.addMember(groupId, userIds);
    }

    /**
     * 移除用户组成员
     */
    @RequestMapping(value = "{groupId}/users/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeMember(@PathVariable("groupId") String groupId, @PathVariable("userId") List<String> userIds) {
        userGroupService.removeMember(groupId, userIds);
    }

    /**
     * 校验用户组名称
     * @param name
     * @return
     */
    @RequestMapping(value = "name/validation", method = RequestMethod.GET)
    @ResponseBody
    public Boolean validateName(String name) {
        return userGroupService.validateName(name);
    }

}
