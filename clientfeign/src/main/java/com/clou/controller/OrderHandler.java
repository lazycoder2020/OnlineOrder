package com.clou.controller;

import com.clou.entity.*;
import com.clou.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") long mid, HttpSession session){
        Account user = (Account) session.getAttribute("user");
        OrderInfo info = new OrderInfo();
        info.setAid(1);
        info.setDate(new Date());
        info.setUid(user.getId());
        info.setMid(mid);
        info.setState(0);
        System.out.println("info: " + info);
        orderFeign.save(info);
        return "redirect:/account/redirect/order";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVO findAllByUid(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session){
        Account user = (Account) session.getAttribute("user");
        return orderFeign.findAllByUid(user.getId(), page, limit);
    }

    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderVO findAllByState(@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println("page " + page + "limit " + limit);
        return orderFeign.findAllByState(0, page-1, limit);
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public Optional<OrderInfo> findByID(@PathVariable("id") long id){
        return orderFeign.findByID(id);
    }

    @GetMapping("/updateState/{id}/{state}")
    public String updateState(@PathVariable("id") long id, @PathVariable("state") int state, HttpSession session){
        Account admin = (Account) session.getAttribute("admin");
        orderFeign.updateState(id, admin.getId(), state);
        return "redirect:/account/redirect/order_handler";
    }

}
