package com.task.controller.api;

import com.task.controller.BaseController;
import com.task.domain.ResponseData;
import com.task.domain.ResponseMessage;
import com.task.entity.Task;
import com.task.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/24
 * @since since
 */
@Controller
@RequestMapping("tasks")
public class TaskController extends BaseController {
    @Autowired
    private ITaskService taskService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseData<List<Task>> getAll(String userId){
        return ResponseData.success(HttpStatus.OK.value(), ResponseMessage.SUCCESS,taskService.selectByReceiveTime(userId));
    }

    @ResponseBody
    @RequestMapping(value = "pend",method = RequestMethod.GET)
    public List<Task> getPendind(){
        return taskService.selectPending();
    }
}
