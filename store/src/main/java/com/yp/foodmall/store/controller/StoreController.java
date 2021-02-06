package com.yp.foodmall.store.controller;

import com.yp.foodmall.common.entity.Store;
import com.yp.foodmall.store.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "商铺模块的测试")
@RequestMapping("/app/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PutMapping("/addStore.do")
    @ApiOperation("添加商铺")
    public void addStore(Store store){
        storeService.insertStore(store);
    }

    @PostMapping("/deleteStore.do")
    @ApiOperation("删除商铺")
    public void deleteStore(int storeId){
        storeService.deleteStore(storeId);
    }

    @PostMapping("/updateStore.do")
    @ApiOperation("修改商铺信息")
    public void updateStore(Store store){
        storeService.updateStore(store);
    }

    @GetMapping("/selecetStoreById")
    @ApiOperation("编号查找商铺")
    public Store selectStoreById(int storeId){
        Store store = storeService.selectStoreById(storeId);
        return store;
    }

    @GetMapping("/selecrStoreList")
    @ApiOperation("根据业务查找商铺，按评分递减")
    public List<Store> selectStoreList(String management){
        List<Store> stores = storeService.slectStoreList(management);
        return stores;
    }
}
