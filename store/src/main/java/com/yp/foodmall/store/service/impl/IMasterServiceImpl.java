package com.yp.foodmall.store.service.impl;

import com.yp.foodmall.common.entity.Master;
import com.yp.foodmall.store.mapper.IMasterMapper;
import com.yp.foodmall.store.mapper.IStoreMapper;
import com.yp.foodmall.store.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IMasterServiceImpl implements MasterService {
    @Autowired
    private IMasterMapper iMasterService;

    @Override
    public void insertMaster(Master master) {
        Date date=new Date();
        master.setCreateTime(date);
        master.setDeleteEnable(0);
        master.setProfit(0.0);
        iMasterService.insertMaster(master);
    }

    @Override
    public void deleteMaster(int masterId) {
        iMasterService.deleteMaster(masterId);
    }

    @Override
    public void updateMaster(Master master) {
        Date date=new Date();
        master.setUpdateTime(date);
        iMasterService.updateMaster(master);
    }

    @Override
    public Master loginMaster(String masterName, String masterPassword) {
        return iMasterService.selectMasterNamePassword(masterName, masterPassword);
    }

    @Override
    public Master selectMasterById(int masterId) {
        return iMasterService.selectMasterById(masterId);
    }
}
