package com.task.dao.mapper;

import java.util.List;

import com.task.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    /**
     * 根据名称查询
     * @param userName
     * @return
     */
    User selectByName(String userName);

    /**
     * 查询分组下用户
     * @param pageNum
     * @param pageSize
     * @param groupId
     * @return
     */
    List<User> selectByGroupId(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize,@Param("groupId") String groupId);

    /**
     * 根据用户名和密码查询
     * @param userName
     * @param password
     * @return
     */
    User selectByNameAndPassword(@Param("userName") String userName, @Param("password") String password);


    List<User> selectApplyPage(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
}