package com.yp.foodmall.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    //格式转换，讲数据转换为json格式
    @JsonFormat(timezone = "GTM+8", pattern = "yyyy-MM-DD hh:mm:ss")
    private Date createTime;
    private Date updateTime;
    private Integer delete_enable;
}
