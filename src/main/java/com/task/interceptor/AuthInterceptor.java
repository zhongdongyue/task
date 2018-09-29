package com.task.interceptor;

import com.task.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangchenyang
 * @desc token鉴权拦截
 * @date 2018/4/18
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Value("${rest.request.enable_auth}")
    private boolean enableAuth;

    /**
     * 鉴权方法
     *
     * @param request request
     * @param resp    resp
     * @param handler handler
     * @return boolean
     * @throws Exception Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse resp, Object handler) throws Exception {
        if (enableAuth) {
            User user = (User) request.getSession().getAttribute("user");
            if(user == null){
                resp.sendRedirect(request.getContextPath()+"/login");
                return false;
            }
        }
        return true;
    }

}
