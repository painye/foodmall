package com.yp.foodmall.food.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private Integer storeId;
    private String storeName;
    private double storeGrade;
    private String license;
    private Master master;
    private Integer phone;
}
