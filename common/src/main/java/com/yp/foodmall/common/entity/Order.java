package com.yp.foodmall.common.entity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private User user;
    private ComStore comStore;
    private Double price;
    private Integer count;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Integer delete_enable;
}
