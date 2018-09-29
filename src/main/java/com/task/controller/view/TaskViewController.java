package com.task.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.task.controller.BaseController;

@Controller
@RequestMapping("task")
public class TaskViewController extends BaseController {
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "/task/list";
    }
}
