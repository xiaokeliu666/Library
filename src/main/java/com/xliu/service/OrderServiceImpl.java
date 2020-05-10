package com.xliu.service;

import com.xliu.mapper.BookMapper;
import com.xliu.mapper.OrderMapper;
import com.xliu.pojo.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.Date;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Transactional
    public void addOrder(Orders orders) {
        System.out.println("=================");
        System.out.println("bookName:"+orders.getBookName());
        System.out.println("=================");
        System.out.println("执行减少：");
        bookMapper.decBookByName("MySQL");
        System.out.println("=================");

        orderMapper.addOrder(orders);
        return;
    }
}
