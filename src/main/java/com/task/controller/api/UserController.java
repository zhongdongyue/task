package com.task.controller.api;

import java.util.ArrayList;
import java.util.List;

import com.task.domain.*;
import com.task.domain.SessionAttribute;
import com.task.entity.User;
import com.task.exception.BusinessException;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    public ResponseData create(@RequestBody User user) {
        userService.create(user);
        return ResponseData.success(HttpStatus.OK.value(), ResponseMessage.SUCCESS,null);
    }


    /**
     * 修改用户
     *
     * @param user 用户信息
     * @return 修改后的用户信息
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseData<User> update(@RequestBody User user) {
        return ResponseData.success(HttpStatus.OK.value(),ResponseMessage.SUCCESS,userService.update(user));
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
    @RequestMapping(value = "{userIds}",method = RequestMethod.POST)
    @ResponseBody
    public void deleteBath(@PathVariable("userIds") List<String> userIds) {
        userService.delete(userIds);
    }

    @RequestMapping(value = "{userId}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseData delete(@PathVariable("userId") String userId){
        userService.delete(userId);
        return ResponseData.success(HttpStatus.OK.value(), ResponseMessage.SUCCESS,null);
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

    /**
     * 获取申请权限列表
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "applys")
    public ResponseData<User> getApplyUser(int page,int limit){
        Pager pages = userService.getAapplyPage(page,limit);
        ResponseData responseData = new ResponseData();
        responseData.setCount((int)pages.getTotalRow());
        responseData.setData(pages.getRecords());
        responseData.setCode(0);
        responseData.setMessage(ResponseMessage.SUCCESS);
        responseData.setMsg("");
        return responseData;
    }


    @ResponseBody
    @RequestMapping(value = "apply/pass/{id}",method = RequestMethod.POST)
    public ResponseData applyPass(@PathVariable("id") String userId){
        userService.applyPass(userId);
        return ResponseData.success(HttpStatus.OK.value(), ResponseMessage.SUCCESS,null);
    }
    @ResponseBody
    @RequestMapping(value = "apply/refuse/{id}",method = RequestMethod.POST)
    public ResponseData applyRefuse(@PathVariable("id") String userId){
        userService.applyRefuse(userId);
        return ResponseData.success(HttpStatus.OK.value(), ResponseMessage.SUCCESS,null);
    }

    /**
     * 用户申请权限
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "receive")
    public ResponseData<User> getReceiveUser(HttpSession session,int page, int limit){
        User user = (User) session.getAttribute(SessionAttribute.USER);
        user = userService.getById(user.getId());
        if(user == null){
            throw new BusinessException(ResponseCode.USER_NOT_EXIT,"用户不存在");
        }
        List<User> users = new ArrayList<>();
        users.add(user);
        ResponseData responseData = new ResponseData();
        responseData.setCount(1);
        responseData.setData(users);
        responseData.setCode(0);
        responseData.setMessage(ResponseMessage.SUCCESS);
        responseData.setMsg("");
        return responseData;
    }


    /**
     * 用户申请权限
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "receive/{id}",method = RequestMethod.POST)
    public ResponseData<User> getReceiveUser(@PathVariable("id") String id){
        User user = userService.getById(id);
        if(user == null){
            throw new BusinessException(ResponseCode.USER_NOT_EXIT,"用户不存在");
        }
        user.setStatus(1);
        userService.update(user);
        return ResponseData.success(HttpStatus.OK.value(), ResponseMessage.SUCCESS,null);
    }
}
