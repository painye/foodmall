package com.yp.foodmall.store.controller;

import com.yp.foodmall.common.entity.MasterStore;
import com.yp.foodmall.store.service.MasterStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/store/masterStore")
@Api(tags = "商铺与掌柜")
public class MasterStoreController {
    @Autowired
    private MasterStoreService masterStoreService;

    @ApiOperation("添加掌柜与店铺的记录")
    @PutMapping("/addMasterStore.do")
    public void addMasterStore(MasterStore masterStore){
        masterStoreService.insertMasterStore(masterStore);
    }

    @ApiOperation("删除掌柜的店铺关系")
    @PostMapping("/deleteMasterStore.do")
    public void deleteMasterStore(int masterStoreId){
        masterStoreService.deleteMasterStore(masterStoreId);
    }

    @ApiOperation("修改掌柜与店铺的关系")
    @PostMapping("/updateMasterStore.do")
    public void updateMasterStore(MasterStore ms){
        masterStoreService.updateMasterStore(ms);
    }

    @ApiOperation("根据id查找关系")
    @GetMapping("/selectMasterStore.do")
    public MasterStore selectMasterStore(int msId){
        MasterStore masterStore = masterStoreService.selectMasterStore(msId);
        return masterStore;
    }

    @ApiOperation("更据掌柜id查找关系")
    @GetMapping("/selectMasterStoreList.do")
    public List<MasterStore> selectMasterStoreList(int masterId){
        List<MasterStore> masterStores = masterStoreService.selectMSList(masterId);
        return masterStores;
    }
}
