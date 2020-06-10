package com.xliu.controller;

import com.xliu.pojo.Books;
import com.xliu.pojo.Orders;
import com.xliu.service.OrderService;
import com.xliu.util.IDGenerator;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    @Qualifier("OrderServiceImpl")
    private OrderService orderService;

    @RequestMapping("/order/orderBook/{name}")
    public String order(@PathVariable String name, Model model, HttpSession session) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String start = sdf.format(date);
        c.setTime(date);
        c.add(Calendar.MONTH,3);
        String end = sdf.format(c.getTime());
        String userId = (String) session.getAttribute("userId");
        model.addAttribute("order",IDGenerator.getId());
        model.addAttribute("name",name);
        model.addAttribute("user",userId);
        model.addAttribute("start",start);
        model.addAttribute("end",end);
        return "order/orderBook";
    }
//    @ResponseBody
    @RequestMapping("order/confirm")
    public String confirm(ServletRequest request) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
        String orderId = request.getParameter("orderId");
        String bookName = request.getParameter("bookName");
        String userId = request.getParameter("userId");
        Date borrowDate = sdf.parse(request.getParameter("borrowDate"));
        Date returnDate = sdf.parse(request.getParameter("returnDate"));
        orderService.addOrder(new Orders(orderId,bookName,userId,borrowDate,returnDate,"processing"));
//        System.out.println(request.getParameter("borrowDate"));
//        System.out.println(borrowDate);
        return "redirect:/book/allBook";

    }
}
