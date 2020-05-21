package com.xliu.service;

import com.xliu.mapper.SubscriptionMapper;
import com.xliu.pojo.Subscriptions;

import java.util.List;

public class SubscriptionServiceImpl implements SubscriptionService {
    private SubscriptionMapper subscriptionMapper;

    public void setSubscriptionMapper(SubscriptionMapper subscriptionMapper) {
        this.subscriptionMapper = subscriptionMapper;
    }

    public int addSubscription(Subscriptions subscriptions) {

        return subscriptionMapper.addSubscription(subscriptions);
    }

    public int delSubscription(String userId, String bookName) {

        return subscriptionMapper.delSubscription(userId, bookName);
    }

    public List<String> querySubscriptionByUser(String userId) {
        return subscriptionMapper.querySubscriptionByUser(userId);
    }

    public List<Subscriptions> queryEmail() {
        return subscriptionMapper.queryEmail();
    }
}
