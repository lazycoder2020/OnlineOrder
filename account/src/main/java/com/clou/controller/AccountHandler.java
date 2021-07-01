package com.clou.controller;

import com.clou.entity.Account;
import com.clou.repository.AdminRepository;
import com.clou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminRepository adminRepository;

    @Value("${server.port}")
    String port;

    @GetMapping("/index")
    @ResponseBody
    public String index(){
        return this.port;
    }

    @PostMapping("/login")
    @ResponseBody
    public Account login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type){
        Account account = null;
        switch (type){
            case "user":
                account = userRepository.findByNameAndPassword(username, password);
                break;
            case "admin":
                account = adminRepository.findByNameAndPassword(username, password);
        }
        return account;
    }
}
