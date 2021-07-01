package com.cloud.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_type")
public class FoodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
