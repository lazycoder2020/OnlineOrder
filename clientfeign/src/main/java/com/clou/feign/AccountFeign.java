package com.clou.feign;

import com.clou.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "account")
public interface AccountFeign {

    @PostMapping("/account/login")
    public Account login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type);


}
