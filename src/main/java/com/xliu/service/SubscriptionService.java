package com.xliu.service;

import com.xliu.pojo.Subscriptions;

import java.util.List;

public interface SubscriptionService {
    //    添加订阅
    int addSubscription(Subscriptions subscriptions);
    //    取消订阅
    int delSubscription(String userId, String bookName);

    List<String> querySubscriptionByUser(String userId);

    List<Subscriptions> queryEmail();

}
