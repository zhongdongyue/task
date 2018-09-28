package com.task.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

/**
 * CLASS_NAME
 *
 * @author shenbing
 * @version 2018/1/19
 * @since since
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String MAIN_VIEW = "/index";


    /**
     * 根据填充视图返回主视图
     *
     * @param view 填充视图
     * @param title 标签的国际化编码
     * @param model 数据
     * @return 完整的视图
     */
    public ModelAndView view(String view, String title, Map<String, Object> model) {
            model.put("title", title);
            model.put("content", view);
            return new ModelAndView(MAIN_VIEW, model);
    }

}
