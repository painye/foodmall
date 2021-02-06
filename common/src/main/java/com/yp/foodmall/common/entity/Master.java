package com.yp.foodmall.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Master {
    private Integer masterId;
    private String masterName;
    private String masterPassword;
    private String question;
    private String answer;
    private Double profit;
    private Integer deleteEnable;
    private Date updateTime;
    private Date createTime;
}
