package com.clou.controller;


import com.clou.entity.Menu;
import com.clou.entity.MenuVO;
import com.clou.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    MenuFeign menuFeign;

    @GetMapping("/create")
    public String create(HttpServletRequest request){
        request.setAttribute("list", menuFeign.findAll());
        return "menu_add";
    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "menu_manage";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return menuFeign.findAll(page,limit);
    }


    @GetMapping("/findById/{id}")
    public String getMenuById(@PathVariable("id") long id, HttpServletRequest request){
        menuFeign.findById(id);
        request.setAttribute("list", menuFeign.findAll());
        request.setAttribute("menu", menuFeign.findById(id));
        return "menu_update";
    }

    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/menu_manage";
    }

    @GetMapping("/menu_manage")
    public String menuManager(){
        return "menu_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        System.out.println("id: " + id);
        menuFeign.deleteById(id);
        return "redirect:/menu/menu_manage";
    }
}
