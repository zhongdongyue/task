package com.task.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.task.domain.ResponseCode;
import com.task.domain.SessionAttribute;
import com.task.entity.User;
import com.task.exception.BusinessException;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("api")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录验证用户名和密码
     * 
     * @param session 请求缓存
     * @param username 用户名
     * @param password 密码
     * @return 登录用户
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpSession session, String username, String password) {
//        User user = userService.getByAccount(username);
//        if (user == null) {
//            throw new BusinessException(ResponseCode.USERNAME_OR_PASSWORD_ERROR,"登录用户不存在:" + username);
//        }
//        user = userService.getByAccountAndPwd(username, password);
//        if (user == null) {
//            throw new BusinessException(ResponseCode.USERNAME_OR_PASSWORD_ERROR,"用户名或密码不正确");
//        }
//        session.setAttribute(SessionAttribute.USER, user);
//        session.setAttribute(SessionAttribute.USER_ID, user.getId());
//        session.setAttribute(SessionAttribute.USER_NAME, user.getName());
        return "{\"result\":\"ok\"}";
    }

    /**
     * 退出登录
     * 
     * @param session
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute(SessionAttribute.USER);
        return "redirect:/login";
    }
}
