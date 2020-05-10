package com.xliu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.util.Date;
@Data
@AllArgsConstructor
public class Orders {
    private String orderId;
    private String bookName;
    private String userId;
    private Date borrowDate;
    private Date returnDate;
    private String status;
}
