package com.clou.controller;

import com.clou.entity.User;
import com.clou.entity.UserVO;
import com.clou.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserHandler {

    @Autowired
    UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
//        System.out.println("page: " + page + " limit: " + limit);
        return userFeign.findAll(page-1, limit);
    }

    @GetMapping("/user_manager")
    public String userManager(){
        return "user_manage";
    }

    @PostMapping("/save")
    public String save(User user){
        userFeign.save(user);
        return "redirect:/user/user_manager";
    }

    @GetMapping("/create")
    public String create(){
        return "user_add";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        userFeign.deleteById(id);
        return "redirect:/user/user_manager";
    }

//    @GetMapping("/index")
//    @ResponseBody
//    public String index(){
//        return userFeign.index();
//    }
}
