package com.cloud.repository;

import com.cloud.entity.Menu;
import com.cloud.entity.MenuJoinType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query(value = "select new com.cloud.entity.MenuJoinType(m, f) from Menu m, FoodType f where m.tid = f.id order by m.id")
    public Page<MenuJoinType> findAllItem(Pageable pageable);
}
