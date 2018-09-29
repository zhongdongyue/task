package com.task.domain;

/**
 * 自定义响应码
 *
 * @author SHEN
 * @version 2017/6/5
 * @since since
 */
public class ResponseCode {

    public static final int DEFAULT_FAILURE = 0;

    public static final int DEFAULT_SUCCESS = 1;

    /** TDCM REST 资源池服务异常 */
    public static final int TDCM_REST_EXCEPTION = 3;

    // ResponseCode >= 2000 通用异常码

    /** 非法的请求参数 */
    public static final int INVALID_REQUEST_PARAMS = 2000;

    /** 非法的LDAP ID参数 */
    public static final int INVALID_ID_PARAM = 2001;

    /** 请求参数存在遗漏 */
    public static final int LOST_REQUEST_PARAMS = 2005;
    /** 对象已存在 */
    public static final int OBJECT_ALREADY_EXISTS = 2007;

    public static final int TASK_NOT_EXIST = 3000;

    /** 任务已被申请 */
    public static final int TASK_APPLIED = 3001;

    /** 任务已被拒绝*/
    public static final int TASK_REFUSE = 3002;

    /** 任务申请频繁*/
    public static final int TASK_APPLY_FREQUENTLY = 3003;

    /** 任务申请频繁*/
    public static final int TASK_COUNT_OUT = 3004;

    /** 任务申请频繁*/
    public static final int TASK_NOT_COMPLETE = 3005;

    /** 任务申请频繁*/
    public static final int NOT_TASK_PERMISSION = 3006;

    /**用户名或密码不正确*/
    public static final  int USERNAME_OR_PASSWORD_ERROR = 3100;
    /**用户已被添加到用户组*/
    public static final int USER_GROUP_ADD_REPEAT_USER = 3200;
    /**用户已移除用户组*/
    public static final int USER_REMOVED_FROM_USER_GROUP =3300;
    /**用户名已被使用*/
    public static final int USER_ACCOUNT_IN_USE =3400;
    /**旧密码错误*/
    public static final int OLD_PASSWORD_ERROR =3500;
    /**用户尚未登录*/
    public static final int UNAUTHENTICATED =3600;

}
