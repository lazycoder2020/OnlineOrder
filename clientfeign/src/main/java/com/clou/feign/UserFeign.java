package com.clou.feign;

import com.clou.entity.User;
import com.clou.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(value = "user")
public interface UserFeign {
    @GetMapping("/user/findAll/{page}/{limit}")
    public UserVO findAll(@PathVariable("page") int index, @PathVariable("limit") int limit);

    @GetMapping("/user/findById/{id}")
    public Optional<User> findById(@PathVariable("id") long id);

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @PutMapping("/user/update")
    public void update(@RequestBody User user);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @GetMapping("/user/index")
    public String index();

}
