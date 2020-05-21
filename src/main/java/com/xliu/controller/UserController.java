package com.xliu.controller;

import com.xliu.pojo.Users;
import com.xliu.service.BookService;
import com.xliu.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

//    跳转至登录页面
    @RequestMapping("/jumplogin")
    public String login() {
        return "user/login";
    }

//    登录验证
    @RequestMapping("/login")
    public String validation(String userId, String password, HttpSession session) {
        if(userService.login(userId).getPassword().equals(password)) {
            session.setAttribute("userId",userId);
            session.setAttribute("email",userService.login(userId).getEmail());
            session.setAttribute("role",userService.login(userId).getRole());
            return "redirect:/book/allBook";
        }
            return "user/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userId");
        return "user/login";
    }
}
