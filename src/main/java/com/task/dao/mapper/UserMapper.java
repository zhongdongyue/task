package com.task.dao.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.task.entity.User;

@Repository
public interface UserMapper {

    int deleteById(String id);

    int insert(User record);

    User selectById(String id);

    User selectByAccountAndPassword(@Param("username") String account, @Param("password") String password);

    User selectByAccount(@Param("username") String account);

    int updateById(User record);

    void updatePassword(@Param("userId") String userId, @Param("password") String password);

    List<User> selectAll();
}
