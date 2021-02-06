package com.yp.foodmall.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commodity {
    private int id;
    private String comNumber;
    private String comName;
    private Category category;
    private String message;
    private Double price;
    private String image;
    private Integer exTime;
    private String taste;
    private String mfrsNumber;
    private String pack;
    private Double weight;
    private Double grade;
    private Date createTime;
    private Date  updateTime;
    private Integer deleteEnable;
}
