package com.yp.foodmall.food.controller;

import com.yp.foodmall.food.entity.Commodity;
import com.yp.foodmall.food.service.impl.ICommodityServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/app/commodity")
@Api(tags = "商品得管理")
public class CommodityController {
    @Autowired
    ICommodityServiceImpl iCommodityService;

    @ApiOperation(value = "添加商品")
    @PutMapping("/addCommodity.do")
    public void addCommodity(Commodity commodity){
        iCommodityService.insertCom(commodity);
    }

    @ApiOperation(value = "下架商品")
    @DeleteMapping("/deleteCommodity.do")
    public void deleteCommodity(String comNUmber){
        iCommodityService.deleteCom(comNUmber);
    }

    @ApiOperation(value = "修改商品基本信息")
    @PostMapping("/updateCommodity.do")
    public void updateCommodity(Commodity com){
        iCommodityService.updateCom(com);
    }

    @ApiOperation(value = "")
    @GetMapping("/findCommodityOneByNumber.do")
    public Commodity findCommodityOneByNumber(String comNumber){
        Commodity commodity = iCommodityService.selectOneByNUmber(comNumber);
        return commodity;
    }

    @GetMapping("/findCommodityList.do")
    public List<Commodity> findCommodityList(Commodity commodity){
        List<Commodity> commodities = iCommodityService.selectList(commodity);
        return commodities;
    }




}
