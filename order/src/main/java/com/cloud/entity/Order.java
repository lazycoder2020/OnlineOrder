package com.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private OrderInfo orderInfo;
    private User user;
    private Admin admin;
    private Menu menu;
}
