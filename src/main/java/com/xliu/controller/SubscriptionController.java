package com.xliu.controller;

import com.xliu.pojo.Subscriptions;
import com.xliu.service.BookService;
import com.xliu.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SubscriptionController {
    @Autowired
    @Qualifier("SubscriptionServiceImpl")
    private SubscriptionService subscriptionService;

    @RequestMapping("/subscribe")
    public String addSubscribe(ServletRequest request, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String bookName = request.getParameter("name");
        String email = (String) session.getAttribute("email");
        subscriptionService.addSubscription(new Subscriptions(userId,bookName,email));
        return "redirect:book/allBook";
    }

    @RequestMapping("/unsubscribe")
    public String unSubscribe(ServletRequest request, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String bookName = request.getParameter("name");
        subscriptionService.delSubscription(userId,bookName);
        return "redirect:book/allBook";
    }
}
