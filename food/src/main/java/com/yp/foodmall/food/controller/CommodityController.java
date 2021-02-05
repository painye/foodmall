package com.yp.foodmall.food.controller;

import com.yp.foodmall.common.entity.Category;
import com.yp.foodmall.common.entity.Commodity;
import com.yp.foodmall.food.service.impl.ICommodityServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/app/commodity")
@Api(tags = "商品管理")
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
    public void deleteCommodity(int comId){
        iCommodityService.deleteCom(comId);
    }

    @ApiOperation(value = "修改商品基本信息")
    @PostMapping("/updateCommodity.do")
    public void updateCommodity(Commodity com){
        iCommodityService.updateCom(com);
    }

    @ApiOperation(value = "查找某个商品")
    @GetMapping("/findCommodityOneByNumber.do")
    public Commodity findCommodityOneByNumber(int comId){
        Commodity commodity = iCommodityService.selectOneByNUmber(comId);
        return commodity;
    }
    @ApiOperation(value = "")
    @GetMapping("/findCommodityList.do")
    public List<Commodity> findCommodityList(Commodity commodity){
        List<Commodity> commodities = iCommodityService.selectList(commodity);
        return commodities;
    }

    @ApiOperation(value="添加商品种类")
    @PutMapping("/addCate.do")
    public void addCate(Category category){
        iCommodityService.insertCate(category);
    }

    @ApiOperation(value="删除商品种类")
    @DeleteMapping("/deleteCate.do")
    public void deleteCate(int categoryId){
        iCommodityService.deleteCate(categoryId);
    }

    @ApiOperation(value = "修改商品种类")
    @PostMapping("/updateCate.do")
    public void updateCate(Category category){
        iCommodityService.updateCate(category);
    }

}
