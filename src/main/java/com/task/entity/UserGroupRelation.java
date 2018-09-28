package com.task.entity;

public class UserGroupRelation {
    private String id;

    private String userId;

    private String userGroupId;

    public UserGroupRelation() {
    }

    public UserGroupRelation(String userId, String userGroupId) {
        this.userId = userId;
        this.userGroupId = userGroupId;
    }

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

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", userGroupId=").append(userGroupId);
        sb.append("]");
        return sb.toString();
    }
}