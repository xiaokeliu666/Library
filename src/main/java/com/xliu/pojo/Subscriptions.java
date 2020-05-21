package com.xliu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subscriptions {
    private String userId;
    private String bookName;
    private String email;


}
