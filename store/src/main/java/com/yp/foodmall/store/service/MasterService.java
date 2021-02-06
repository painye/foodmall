package com.yp.foodmall.store.service;

import com.yp.foodmall.common.entity.Master;

import java.util.List;

public interface MasterService {
    public void insertMaster(Master master);
    public void deleteMaster(int masterId);
    public void updateMaster(Master master);
    public Master loginMaster(String masterName, String masterPassword);
    public Master selectMasterById(int masterId);
}
