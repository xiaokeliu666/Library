package com.xliu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Orders {
    private String orderId;
    private int bookId;
    private String userId;
    private Date borrowDate;
    private Date returnDate;
}
