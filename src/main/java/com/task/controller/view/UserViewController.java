package com.task.controller.view;

import com.task.controller.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserViewController extends BaseController {
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
