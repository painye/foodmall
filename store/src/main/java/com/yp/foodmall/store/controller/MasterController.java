package com.yp.foodmall.store.controller;

import com.yp.foodmall.common.entity.Master;
import com.yp.foodmall.store.service.MasterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "掌柜模块")
@RequestMapping("/app/master")
public class MasterController {
    @Autowired
    private MasterService masterService;

    @PutMapping("/addMaster.do")
    @ApiOperation("注册掌柜")
    public void addMaster(Master master){
        masterService.insertMaster(master);
    }

    @PostMapping("/deleteMaster.do")
    @ApiOperation("注销掌柜")
    public void deleteMaster(int masterId){
        masterService.deleteMaster(masterId);
    }

    @PostMapping("/updateMaster.do")
    @ApiOperation("更新掌柜信息")
    public void updateMaster(Master master){
        masterService.updateMaster(master);
    }

    @GetMapping("/loginMaster.do")
    @ApiOperation("查找id下的某个掌柜")
    public Master loginMaster(String masterName, String masterPassword){
        Master master = masterService.loginMaster(masterName, masterPassword);
        return master;
    }

    @GetMapping("/selectMasterById.do")
    @ApiOperation("查找id下的某个掌柜")
    public Master selectMasterById(int masterId){
        Master master = masterService.selectMasterById(masterId);
        return master;
    }
}
