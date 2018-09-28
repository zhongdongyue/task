package com.task.controller.view;

import com.task.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class IndexViewController extends BaseController {
    @RequestMapping("")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/reg")
    public String reg() {
        return "/reg";
    }

}
