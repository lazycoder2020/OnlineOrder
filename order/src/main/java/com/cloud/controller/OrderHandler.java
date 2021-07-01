package com.cloud.controller;

import com.cloud.entity.Order;
import com.cloud.entity.OrderInfo;
import com.cloud.entity.OrderVO;
import com.cloud.repository.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    OrderInfoRepository orderInfoRepository;

    @GetMapping("/index")
    public String index(){
        return "order port: " + this.port;
    }

    @GetMapping("/findAllByUid/{uid}/{page}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit){
        Page<Order> result = orderInfoRepository.findAllByUid(uid, PageRequest.of(page, limit));
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount((int)result.getTotalElements());
        orderVO.setData(result.getContent());
        return orderVO;
    }

    @GetMapping("/findAllByState/{state}/{page}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("page") int page, @PathVariable("limit") int limit){
        Page<Order> result = orderInfoRepository.findAllByState(state, PageRequest.of(page, limit));
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount((int)result.getTotalElements());
        orderVO.setData(result.getContent());
        return orderVO;
    }

    @GetMapping("/findById/{id}")
    public Optional<OrderInfo> findByID(@PathVariable("id") long id){
        Optional<OrderInfo> orderInfo = orderInfoRepository.findById(id);
        return orderInfo;
    }

    @PostMapping("/save")
    public void save(@RequestBody OrderInfo orderInfo){
        orderInfoRepository.save(orderInfo);
    }

    @DeleteMapping("/deleteByUid")
    public void deleteByUid(@RequestParam("uid") long uid){
        orderInfoRepository.deleteByUid(uid);
    }

    @DeleteMapping("/deleteByMid")
    public void deleteByMid(@RequestParam("mid") long mid){
        orderInfoRepository.deleteByMid(mid);
    }

    @PutMapping("/updateState")
    public void updateState(@RequestParam("id") long id, @RequestParam("aid") long aid,@RequestParam("state") long state){
        orderInfoRepository.updateState(id, aid, state);
    }

}
