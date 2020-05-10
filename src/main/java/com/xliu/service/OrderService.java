package com.xliu.service;

import com.xliu.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface OrderService {
    void addOrder(Orders orders);
}
