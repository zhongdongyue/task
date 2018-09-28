package com.task.exception;

/**
 * @author wcy
 * @desc 业务异常类
 * @date 2018/4/16
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 164431398245776951L;

    private int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
