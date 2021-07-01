package com.clou.entity;

import lombok.Data;

@Data
public class Admin extends Account{

    private long id;
    private String username;
    private String password;
}
