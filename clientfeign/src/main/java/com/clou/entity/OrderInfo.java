package com.clou.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderInfo {

    private long id;
    private long uid;
    private long mid;
    private long aid;
    private Date date;
    private int state;

}
