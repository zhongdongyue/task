package com.task.entity;

import java.util.Date;

/**
 * CLASS_NAME
 *
 * @author hull
 * @version 2018/9/28
 * @since since
 */
public class ApplyPermission {
    private String id;
    private String permissionName;
    private String applyUserId;
    private int state;
    private String description;
    private String approverUserId;
    private Date createTime;
    private Date updateTime;
    private String userGroup;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApproverUserId() {
        return approverUserId;
    }

    public void setApproverUserId(String approverUserId) {
        this.approverUserId = approverUserId;
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

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    @Override
    public String toString() {
        return "ApplyPermission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", applyUserId='" + applyUserId + '\'' +
                ", state=" + state +
                ", description='" + description + '\'' +
                ", approverUserId='" + approverUserId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userGroup='" + userGroup + '\'' +
                '}';
    }
}
