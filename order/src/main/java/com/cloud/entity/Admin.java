package com.cloud.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "t_admin")
@Entity
public class Admin extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
}
