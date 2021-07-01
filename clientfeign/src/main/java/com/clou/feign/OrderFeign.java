package com.clou.feign;

import com.clou.entity.OrderInfo;
import com.clou.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(value = "order")
public interface OrderFeign {

    @GetMapping("/order/findAllByUid/{uid}/{page}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit);

    @GetMapping("/order/findAllByState/{state}/{page}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("page") int page, @PathVariable("limit") int limit);

    @GetMapping("/order/findById/{id}")
    public Optional<OrderInfo> findByID(@PathVariable("id") long id);

    @PostMapping("/order/save")
    public void save(@RequestBody OrderInfo orderInfo);

    @DeleteMapping("/order/deleteByUid")
    public void deleteByUid(@RequestParam("uid") long uid);

    @DeleteMapping("/order/deleteByMid")
    public void deleteByMid(@RequestParam("mid") long mid);

    @PutMapping("/order/updateState")
    public void updateState(@RequestParam("id") long id, @RequestParam("aid") long aid,@RequestParam("state") long state);

}
