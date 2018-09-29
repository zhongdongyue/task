package com.task.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.task.controller.BaseController;
import com.task.domain.SessionAttribute;
import com.task.entity.Permission;
import com.task.entity.User;
import com.task.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 权限管理 视图控制器
 *
 * @author hull
 * @version 2018/2/8
 * @since since
 */
@Controller
@RequestMapping("api")
public class PermissionController extends BaseController {

    @Autowired
    private IPermissionService permissionService;

//    @RequestMapping(value = "/permissions/{code}", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Permission> getPermission(HttpServletRequest request, @PathVariable("code") String code) {
//        User user = (User) request.getSession().getAttribute(SessionAttribute.USER);
//        return permissionService.getByUserAndModuleCode(user, code);
//    }
}
