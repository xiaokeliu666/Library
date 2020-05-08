package com.xliu.service;

import com.xliu.controller.UserController;
import com.xliu.mapper.UserMapper;
import com.xliu.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Users login(@Param("userId") String id) {
        return userMapper.login(id);
    }
}
