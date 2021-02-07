package com.yp.foodmall.common.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComStore {
    private Integer comStoreId;
    private Commodity commodity;
    private Store store;
    private Double salePrice;
    private Integer stock;
    private Integer sales;
    private Date createTime;
    private Date updateTime;
    private Integer deleteEnable;
}
