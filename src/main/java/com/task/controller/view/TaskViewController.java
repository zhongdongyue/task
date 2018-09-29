package com.task.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.task.controller.BaseController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("task")
public class TaskViewController extends BaseController {
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView list() {
        return new ModelAndView("/task/list");
    }
}
