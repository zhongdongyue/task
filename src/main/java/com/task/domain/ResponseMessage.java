package com.task.domain;

/**
 * @author wangchenyang
 * @desc 自定义异常信息
 * @date 2018/4/16
 */
public interface ResponseMessage {

    /**
     * Http请求返回信息
     */
    String SUCCESS = "成功";

    String FAIL = "失败";

    String PARAMS_ERROR = "请求参数错误";

    String SYSTEM_ERROR = "系统异常";




    interface Health {
        String NOT_FOUND = "任务不存在";
    }

}
