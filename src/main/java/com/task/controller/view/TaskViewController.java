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

    @RequestMapping(value = "mylist", method = RequestMethod.GET)
    public ModelAndView myList() {
        return new ModelAndView("/task/mylist");
    }

    @RequestMapping(value = "manager", method = RequestMethod.GET)
    public ModelAndView manager() {
        return new ModelAndView("/task/manager");
    }
}
