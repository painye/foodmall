package com.yp.foodmall.store.controller;

import com.yp.foodmall.common.entity.ComStore;
import com.yp.foodmall.store.service.impl.IComStoreServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apiguardian.api.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "管理模块")
@RestController
@RequestMapping("/app/store/manage")
public class ManagerController {
    @Autowired
    private IComStoreServiceImpl iComStoreService;

    @ApiOperation("进货")
    @PostMapping("/stockUp.do")
    public void stockUp(int commodityId, int storeId, int count){
        iComStoreService.updateStock(commodityId, storeId, count);
    }

    @ApiOperation("商铺加货")
    @PutMapping("/insertCom2Store.do")
    public void insertCom2Store(ComStore comStore){
        iComStoreService.insertComStore(comStore);
    }

    @ApiOperation("商铺删除货物的订购")
    @PostMapping("/deleteComStore.do")
    public void deleteComStore(int comStoreId){
        iComStoreService.deleteComStore(comStoreId);
    }

    @ApiOperation("修改商铺信息")
    @PostMapping("/updateComStore.do")
    public void updateComStore(@RequestBody ComStore comStore){
        System.out.println(comStore);
        iComStoreService.updateComStore(comStore);
    }
}
