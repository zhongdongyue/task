package com.task.controller.api;

import com.task.domain.ResponseData;
import com.task.domain.ResponseMessage;
import com.task.entity.User;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/30
 * @since since
 */
@Controller
@RequestMapping("api/regist")
public class RegistController {
    @Autowired
    private UserService userService;
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

}
