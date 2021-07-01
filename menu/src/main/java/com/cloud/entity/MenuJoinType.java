package com.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuJoinType {
    private Menu menu;
    private FoodType foodType;
}
