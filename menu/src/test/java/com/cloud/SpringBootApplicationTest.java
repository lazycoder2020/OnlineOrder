package com.cloud;

import com.cloud.entity.Menu;
import com.cloud.entity.MenuJoinType;
import com.cloud.repository.MenuRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MenuApplication.class)
public class SpringBootApplicationTest {

    @Autowired
    MenuRepository repository;

    @Test
    public void test(){
        System.out.println("hello world");
    }

    @Test
    public void jpaTest(){
//        Optional<Menu> menu = repository.findById((long) 1);
//        System.out.println(menu);

        Page<MenuJoinType> list = repository.findAllItem(PageRequest.of(1,10));
        System.out.println(list.getContent());
    }
}
