package com.xliu.mapper;

import com.xliu.pojo.Users;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    Users login(@Param("userId") String id);
}
