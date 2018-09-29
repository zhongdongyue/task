package com.task.controller.view;

import com.task.controller.BaseController;
import com.task.domain.ResponseCode;
import com.task.domain.SessionAttribute;
import com.task.entity.Group;
import com.task.entity.User;
import com.task.exception.BusinessException;
import com.task.service.IGroupService;
import com.task.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("group")
public class GroupViewController extends BaseController {

    @Autowired
    IGroupService groupService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "/group/add";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView list() {
        return new ModelAndView("/group/list");
    }
}
