package com.xliu.service;

import com.xliu.pojo.Users;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    Users login(@Param("userId") String id);
}
