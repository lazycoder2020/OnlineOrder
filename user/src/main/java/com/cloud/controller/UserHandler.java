package com.cloud.controller;

import com.cloud.entity.User;
import com.cloud.entity.UserVO;
import com.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    UserRepository userRepository;

    @Value("${server.port}")
    String port;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/findAll/{page}/{limit}")
    public UserVO findAll(@PathVariable("page") int index, @PathVariable("limit") int limit){
        Page<User> userPage = userRepository.findAll(PageRequest.of(index,limit));
        UserVO userVO= new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount((int)userPage.getTotalElements());
        userVO.setData(userPage.getContent());
        return userVO;
    }

    @GetMapping("/findById/{id}")
    public Optional<User> findById(@PathVariable("id") long id){
        return userRepository.findById(id);
    }


    @PostMapping("/save")
    public void save(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        userRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }

}
