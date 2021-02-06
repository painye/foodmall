package com.yp.foodmall.common.entity;

import io.swagger.models.auth.In;
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
    private Double storeGrade;
    private String license;
    private String phone;
    private Date createTime;
    private String management;
    private Integer deleteEnable;
    private Date updateTime;
}
