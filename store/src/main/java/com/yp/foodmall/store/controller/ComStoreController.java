package com.yp.foodmall.store.controller;

import com.yp.foodmall.common.entity.ComStore;
import com.yp.foodmall.store.service.impl.IComStoreServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/com_store")
@Api(tags = "商铺管理货物模块")
public class ComStoreController {
    @Autowired
    private IComStoreServiceImpl iComStoreService;

    @ApiOperation("商铺加货")
    @PutMapping("/insertCom2Store")
    public void insertCom2Store(ComStore comStore){
        iComStoreService.insertComStore(comStore);
    }

    @ApiOperation("商铺删除货物的订购")
    @PostMapping("/deleteComStore")
    public void deleteComStore(int comStoreId){
        iComStoreService.deleteComStore(comStoreId);
    }

    @ApiOperation("修改商铺信息")
    @PostMapping("/updateComStore")
    public void updateComStore(ComStore comStore){
        iComStoreService.updateComStore(comStore);
    }

    @ApiOperation("查询某编号的商铺商品")
    @GetMapping("/selectComStore")
    public ComStore selectComStore(int comStoreId){
        ComStore comStore = iComStoreService.selectComStore(comStoreId);
        return comStore;
    }

    @ApiOperation("查询特定条件下的商铺商品")
    @GetMapping("/selectComStoreList")
    public List<ComStore> selectComStoreList(ComStore comStore){
        List<ComStore> comStores = iComStoreService.selectComStoreList(comStore);
        return comStores;
    }
}
