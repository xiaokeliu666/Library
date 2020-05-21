package com.xliu.mapper;

import com.xliu.pojo.Subscriptions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubscriptionMapper {
//    添加订阅
    int addSubscription(Subscriptions subscriptions);
//    取消订阅
    int delSubscription(@Param("userId") String userId, @Param("bookName")String bookName);
//    查询订阅
    List<String> querySubscriptionByUser(String userId);

    List<Subscriptions> queryEmail();
}
