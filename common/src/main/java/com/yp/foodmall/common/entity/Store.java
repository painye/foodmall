package com.yp.foodmall.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date createTime;
    private Integer deleteEnable;
}
