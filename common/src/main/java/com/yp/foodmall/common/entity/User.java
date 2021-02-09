package com.yp.foodmall.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userImage;
    private Double money;
    private String moneyPassword;
    private String userAddress;
    private Date createTime;
    private Integer deleteEnable;
}
