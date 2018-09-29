package com.task.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author wangchenyang
 * @desc 统一信息返回类
 * @date 2018/4/16
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    private String msg;

    /**
     * 返回数据
     */
    private T data;

    private int count;


    public ResponseData() {
        super();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ResponseData{" + "code=" + code + ", message='" + message + '\'' + ", data=" + data + '}';
    }

    /**
     * 返回错误信息
     *
     * @param code    错误码
     * @param message 错误信息
     * @return RestResponse
     */
    public static <T> ResponseData<T> error(Integer code, String message) {
        ResponseData<T> response = new ResponseData<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    /**
     * 返回自定义信息、对象
     *
     * @param code    结果码
     * @param message 信息
     * @param obj     对象
     * @return RestResponse
     */
    public static <T> ResponseData<T> success(Integer code, String message, T obj) {
        ResponseData<T> response = new ResponseData<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(obj);
        return response;
    }

    /**
     * 返回自定义信息、对象
     *
     * @param code    结果码
     * @param message 信息
     * @param obj     对象
     * @return RestResponse
     */
    public static <T> ResponseData<T> success(Integer code, String message, T obj,int count) {
        ResponseData<T> response = new ResponseData<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(obj);
        response.setCount(count);
        return response;
    }

}
