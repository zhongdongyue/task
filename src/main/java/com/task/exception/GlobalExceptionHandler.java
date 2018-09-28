package com.task.exception;


import java.sql.SQLException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.task.domain.ResponseData;
import com.task.domain.ResponseMessage;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author wangchenyang
 * @desc 全局异常处理
 * @date 2018/4/16
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData defaultErrorHandler(Exception exception) throws Exception {
        logger.error(exception.getMessage(), exception);
        return exceptionConvert(exception);
    }

    /**
     * 异常消息处理
     */
    private ResponseData exceptionConvert(Exception e) {
        //业务异常处理
        if (e instanceof BusinessException) {
            BusinessException exc = (BusinessException) e;
            return ResponseData.error(exc.getCode(), exc.getMessage());
        } else if (e instanceof MethodArgumentNotValidException) {
            String message = ((MethodArgumentNotValidException) e).getBindingResult().getFieldError()
                            .getDefaultMessage();
            return ResponseData.error(HttpStatus.BAD_REQUEST.value(), message);
        } else if (e instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> violations = ((ConstraintViolationException) e).getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                return ResponseData.error(HttpStatus.BAD_REQUEST.value(), item.getMessage());
            }
        } else if (e instanceof HttpMessageNotReadableException || e instanceof MissingServletRequestParameterException
                        || e instanceof NumberFormatException || e instanceof TypeMismatchException
                        || e instanceof NullPointerException || e instanceof MyBatisSystemException
                        || e instanceof SQLException) {
            return ResponseData.error(HttpStatus.BAD_REQUEST.value(), ResponseMessage.PARAMS_ERROR);
        }
        return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ResponseMessage.SYSTEM_ERROR);
    }
}
