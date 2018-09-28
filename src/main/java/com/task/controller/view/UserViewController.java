package com.task.controller.view;

import com.task.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserViewController extends BaseController {
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "/user/add";
    }

    @RequestMapping(value = "cate", method = RequestMethod.GET)
    public String cate() {
        return "/user/cate";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit() {
        return "/user/edit";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "/user/list";
    }

    @RequestMapping(value = "role", method = RequestMethod.GET)
    public String role() {
        return "/user/role";
    }

    @RequestMapping(value = "roleAdd", method = RequestMethod.GET)
    public String roleAdd() {
        return "/user/roleAdd";
    }

    @RequestMapping(value = "rule", method = RequestMethod.GET)
    public String rule() {
        return "/user/rule";
    }
}
