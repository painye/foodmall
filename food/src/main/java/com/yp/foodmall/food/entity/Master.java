package com.yp.foodmall.food.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Master {
    private Integer masterId;
    private String userName;
    private String password;
    private String question;
    private String answer;
    private Double profit;
}
