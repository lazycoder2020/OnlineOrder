package com.clou.controller;

import com.clou.entity.Account;
import com.clou.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class AccountHandler {

    @Autowired
    AccountFeign accountFeign;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loing(@RequestParam("username") String username, @RequestParam("password") String password,
                        @RequestParam("type") String type, HttpSession session){
        Account account = accountFeign.login(username, password, type);
        System.out.println("account is: " + account);
        String target = null;
        if (account == null){
            target = "login";
        }else {
            switch (type){
                case "user":
                    session.setAttribute("user", account);
                    target = "redirect:/account/user/index";
                    break;
                case "admin":
                    session.setAttribute("admin", account);
                    target = "redirect:/account/admin/main";
                    break;
            }
        }
        return target;
    }

    @GetMapping("/account/user/index")
    public String userInex(){
        return "index";
    }

    @GetMapping("/account/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @GetMapping("/account/admin/main")
    public String adminMain(){
        return "main";
    }

    @RequestMapping("account/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }
}
