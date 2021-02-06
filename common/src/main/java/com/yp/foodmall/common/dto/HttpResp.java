package com.yp.foodmall.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResp {
    private int id;
    private String msg;
    private Object results;
    private LocalDateTime times;
}
