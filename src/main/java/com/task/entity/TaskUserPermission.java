package com.task.entity;

import org.springframework.dao.DataAccessException;

import java.util.Date;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/10/15
 * @since since
 */
public class TaskUserPermission {
    private String id;
    private String userId;
    private String taskId;
    private int status;
    private Date createTime;
    private Date updateTime;
    private Date receiveTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Override
    public String toString() {
        return "TaskUserPermission{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", receiveTime=" + receiveTime +
                '}';
    }
}
