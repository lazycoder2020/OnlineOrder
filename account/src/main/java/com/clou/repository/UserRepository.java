package com.clou.repository;

import com.clou.entity.Account;
import com.clou.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from t_user where username = ?1 and password = ?2", nativeQuery = true)
    User findByNameAndPassword(String username, String password);
}
