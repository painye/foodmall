package com.yp.foodmall.food.controller;

import com.yp.foodmall.food.entity.Commodity;
import com.yp.foodmall.food.service.impl.ICommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommodityController {
    @Autowired
    ICommodityServiceImpl iCommodityService;

    @PutMapping("app/commodity/addCommodity.do")
    public void addCommodity(Commodity commodity){
        iCommodityService.insertCom(commodity);
    }





}
