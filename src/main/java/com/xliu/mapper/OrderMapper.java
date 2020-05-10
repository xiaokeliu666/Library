package com.xliu.mapper;

import com.xliu.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface OrderMapper {
    int addOrder(Orders orders);
}
