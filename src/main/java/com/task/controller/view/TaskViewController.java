package com.task.controller.view;

import com.task.domain.ResponseCode;
import com.task.entity.Task;
import com.task.exception.BusinessException;
import com.task.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.task.controller.BaseController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("task")
public class TaskViewController extends BaseController {
    @Autowired
    private ITaskService taskService;

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

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add() {
        return new ModelAndView("/task/add");
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value = "taskId") String taskId, ModelMap map) {
        Task task = taskService.selectByPrimaryKey(taskId);
        if(task == null){
            throw new BusinessException(ResponseCode.TASK_NOT_EXIST,"任务不存在");
        }
        map.put("task",task);
        return new ModelAndView("/task/edit");
    }
}
