package com.cloud.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "t_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private String flavor;
    private int tid;
}
