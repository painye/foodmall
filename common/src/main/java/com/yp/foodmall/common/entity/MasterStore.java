package com.yp.foodmall.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterStore {
    private Integer masterStoreId;
    private Master master;
    private Store store;
    private Date createTime;
    private Date updateTime;
    private Integer deleteEnable;
}


