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

    @ApiOperation("查询某编号的商铺商品")
    @GetMapping("/selectComStore.do")
    public ComStore selectComStore(int comStoreId){
        ComStore comStore = iComStoreService.selectComStore(comStoreId);
        return comStore;
    }

    @ApiOperation("查询特定条件下的商铺商品")
    @GetMapping("/selectComStoreList.do")
    public List<ComStore> selectComStoreList(ComStore comStore){
        List<ComStore> comStores = iComStoreService.selectComStoreList(comStore);
        return comStores;
    }

    @GetMapping("/selectComStoreCS.do")
    @ApiOperation("检索具体商品")
    public ComStore selectComStoreCS(int commodityId, int storeId){
        ComStore comStore = iComStoreService.selectComStoreCS(commodityId, storeId);
        return comStore;
    }

    @ApiOperation("查询某id的商铺商品")
    @GetMapping("/selectComStoreByComId.do")
    public List<ComStore> selectComStoreByComId(int comId){
        List<ComStore> comStores = iComStoreService.selectComStoreByComId(comId);
        return comStores;
    }
}
