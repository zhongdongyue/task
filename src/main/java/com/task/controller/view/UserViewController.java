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
@RequestMapping("user")
public class UserViewController extends BaseController {

    @Autowired
    IGroupService groupService;

    @Autowired
    UserService userService;

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

    @RequestMapping(value = "adminEdit", method = RequestMethod.GET)
    public ModelAndView adminEdit(HttpSession session, @RequestParam(value = "userId") String userId, ModelMap map) {
        User user = userService.getById(userId);
        if (user == null) {
            throw new BusinessException(404,"用户不存在");
        }
        User loginUser = (User) session.getAttribute(SessionAttribute.USER);
        List<Group> groupList = groupService.selectByUserId(loginUser);
        map.put("groupList", groupList);
        map.put("user", user);
        return new ModelAndView("/user/admin_edit", map);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "groupId") String groupId, ModelMap map) {
        map.put("groupId", groupId);
        return new ModelAndView("/user/list", map);
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
