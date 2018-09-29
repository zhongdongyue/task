package com.task.controller.view;

import com.task.controller.BaseController;
import com.task.domain.SessionAttribute;
import com.task.entity.Group;
import com.task.entity.User;
import com.task.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class IndexViewController extends BaseController {

    @Autowired
    IGroupService groupService;

    @RequestMapping("")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("index")
    public ModelAndView index(HttpSession session, ModelMap map) {
//        User user = (User) session.getAttribute(SessionAttribute.USER);
//        List<Group> groupList = groupService.selectByUserId(user);
        List<Group> groupList = new ArrayList<>();
        Group group = new Group();
        group.setId("1");
        group.setName("zhon");
        groupList.add(group);
        map.put("groupList", groupList);
        return new ModelAndView("/index", map);
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
