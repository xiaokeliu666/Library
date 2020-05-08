package com.xliu.service;

import com.xliu.mapper.OrderMapper;
import com.xliu.pojo.Orders;
import org.springframework.stereotype.Service;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public int addOrder(Orders orders) {
        return orderMapper.addOrder(orders);
    }
}
