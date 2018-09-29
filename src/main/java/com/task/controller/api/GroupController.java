package com.task.controller.api;

import com.task.controller.BaseController;
import com.task.entity.Group;
import com.task.entity.User;
import com.task.service.IGroupService;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.task.domain.Pager;

/**
 * 用户组 视图控制器
 *
 * @author shenbing
 * @version 2018/2/9
 * @since since
 */
@Controller
@RequestMapping("api/userGroups")
public class GroupController extends BaseController {

    @Autowired
    private IGroupService userGroupService;

    @Autowired
    private UserService userService;

    /**
     * 创建用户组
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Group userGroup(@RequestBody Group userGroup) {
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
    public Pager<User> getUserGroupMembers(@PathVariable("groupId") String groupId, int pageNum, int pageSize) {
         return userService.getPageByGroupId(pageNum,pageSize,groupId);
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
