package com.task.controller.api;

import com.task.controller.BaseController;
import com.task.domain.Pager;
import com.task.domain.ResponseData;
import com.task.domain.ResponseMessage;
import com.task.domain.SessionAttribute;
import com.task.entity.Task;
import com.task.entity.User;
import com.task.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/24
 * @since since
 */
@Controller
@RequestMapping("api/tasks")
public class TaskController extends BaseController {
    @Autowired
    private ITaskService taskService;

    @ResponseBody
    @RequestMapping(value = "user/list",method = RequestMethod.GET)
    public ResponseData<Task> getTaskByUser(HttpSession session,int page, int limit){
        User user = (User) session.getAttribute(SessionAttribute.USER);
        Pager pages = taskService.selectByUserId(page,limit,user.getId());
        ResponseData responseData = new ResponseData();
        responseData.setCount((int)pages.getTotalRow());
        responseData.setData(pages.getRecords());
        responseData.setCode(0);
        responseData.setMessage(ResponseMessage.SUCCESS);
        responseData.setMsg("");
        return responseData;
    }

    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET)
    public ResponseData<Task> getALL(int page, int limit){
        Pager pages = taskService.selectAll(page,limit);
        ResponseData responseData = new ResponseData();
        responseData.setCount((int)pages.getTotalRow());
        responseData.setData(pages.getRecords());
        responseData.setCode(0);
        responseData.setMessage(ResponseMessage.SUCCESS);
        responseData.setMsg("");
        return responseData;
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResponseData<Task> getTaskList(int page, int limit){
        Pager pages = taskService.selectPending(page,limit);
        ResponseData responseData = new ResponseData();
        responseData.setCount((int)pages.getTotalRow());
        responseData.setData(pages.getRecords());
        responseData.setCode(0);
        responseData.setMessage(ResponseMessage.SUCCESS);
        responseData.setMsg("");
        return responseData;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseData insert(HttpSession session,Task task){
        User user = (User) session.getAttribute(SessionAttribute.USER);
        task.setCreatorId(user.getId());
        taskService.insert(task);
        return ResponseData.success(HttpStatus.OK.value(),ResponseMessage.SUCCESS,null);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseData update(@RequestBody Task task){
        taskService.updateByPrimaryKey(task);
        return ResponseData.success(HttpStatus.OK.value(),ResponseMessage.SUCCESS,null);
    }

    @ResponseBody
    @RequestMapping(value = "complete/{taskId}",method = RequestMethod.POST)
    public ResponseData complete(@PathVariable("taskId") String id){
        taskService.complete(id);
        return ResponseData.success(HttpStatus.OK.value(),ResponseMessage.SUCCESS,null);
    }

    @ResponseBody
    @RequestMapping(value ="{id}",method = RequestMethod.DELETE)
    public ResponseData delete(@PathVariable("id") String id){
        taskService.deleteByPrimaryKey(id);
        return ResponseData.success(HttpStatus.OK.value(),ResponseMessage.SUCCESS,null);
    }

    @ResponseBody
    @RequestMapping(value = "receive/{taskId}",method = RequestMethod.POST)
    public ResponseData receive(HttpSession session, @PathVariable("taskId") String taskId){
        User user = (User) session.getAttribute(SessionAttribute.USER);
        taskService.receive(taskId,user.getId());
        return ResponseData.success(HttpStatus.OK.value(),ResponseMessage.SUCCESS,null);
    }
}
