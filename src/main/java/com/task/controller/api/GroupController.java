package com.task.controller.api;

import com.task.controller.BaseController;
import com.task.domain.ResponseData;
import com.task.domain.ResponseMessage;
import com.task.entity.Group;
import com.task.entity.User;
import com.task.service.IGroupService;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseData<Group> userGroup(@RequestBody Group userGroup) {
        return ResponseData.success(HttpStatus.OK.value(),ResponseMessage.SUCCESS,userGroupService.create(userGroup));
    }

    /**
     * 删除用户组
     */
    @RequestMapping(value = "{groupId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseData delete(@PathVariable("groupId") String groupId) {
        userGroupService.delete(groupId);
        return ResponseData.success(HttpStatus.OK.value(),ResponseMessage.SUCCESS,null);
    }

    /**
     * 获取用户组成员
     */
    @RequestMapping(value = "{groupId}/users", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<User> getUserGroupMembers(@PathVariable("groupId") String groupId, int page, int limit) {
         Pager pages = userService.getPageByGroupId(page,limit,groupId);
         ResponseData responseData = new ResponseData();
         responseData.setCount((int)pages.getTotalRow());
         responseData.setData(pages.getRecords());
         responseData.setCode(0);
         responseData.setMessage(ResponseMessage.SUCCESS);
         responseData.setMsg("");
         return responseData;
    }


    /**
     * 校验用户组名称
     * @param name
     * @return
     */
    @RequestMapping(value = "name/validation", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData validateName(String name) {
        return ResponseData.success(HttpStatus.OK.value(),ResponseMessage.SUCCESS,userGroupService.validateName(name));
    }

    /**
     * 分页查询所有用户组
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseData<Group> getAll(int page, int limit){
        Pager pages = userGroupService.selectAllByPage(page,limit);
        ResponseData responseData = new ResponseData();
        responseData.setCount((int)pages.getTotalRow());
        responseData.setData(pages.getRecords());
        responseData.setCode(0);
        responseData.setMessage(ResponseMessage.SUCCESS);
        responseData.setMsg("");
        return responseData;
    }

}
