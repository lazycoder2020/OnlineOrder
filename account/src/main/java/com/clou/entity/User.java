package com.clou.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "t_user")
@Entity
public class User extends Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    @Column(name = "registerdate")
    private Date registerDate;
    private String address;
}
