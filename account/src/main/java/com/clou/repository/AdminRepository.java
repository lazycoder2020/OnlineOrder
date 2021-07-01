package com.clou.repository;

import com.clou.entity.Account;
import com.clou.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query(value = "select * from t_admin where username = ?1 and password = ?2", nativeQuery = true)
    Admin findByNameAndPassword(String username, String password);
}
