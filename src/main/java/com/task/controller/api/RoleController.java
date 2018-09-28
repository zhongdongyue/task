package com.task.controller.api;

import java.util.List;

import com.task.entity.Role;
import com.task.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllRoles(){
        List<Role> roles = roleService.getAll();
        return roles;
    }
}
