package com.cloud.controller;

import com.cloud.entity.Menu;
import com.cloud.entity.FoodType;
import com.cloud.entity.MenuJoinType;
import com.cloud.entity.MenuVO;
import com.cloud.repository.MenuRepository;
import com.cloud.repository.FoodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    FoodTypeRepository typeRepository;

    @GetMapping("/findAll/{page}/{limit}")
    public MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){

        Page<MenuJoinType> result = menuRepository.findAllItem(PageRequest.of(page-1,limit));
        MenuVO menuVO = new MenuVO();
        menuVO.setCode(0);
        menuVO.setMsg("");
        menuVO.setCount((int) result.getTotalElements());
        menuVO.setData(result.getContent());
        return menuVO;
    }

    @GetMapping("/findAll")
    public List<FoodType> findAll(){
        return typeRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuRepository.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Optional<Menu> index(@PathVariable("id") long id){
        return menuRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.save(menu);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") long id){
        menuRepository.deleteById(id);
    }

}
