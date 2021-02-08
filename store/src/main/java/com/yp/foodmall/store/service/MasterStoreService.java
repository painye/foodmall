package com.yp.foodmall.store.service;

import com.yp.foodmall.common.entity.MasterStore;

import java.util.List;

public interface MasterStoreService {
    public void insertMasterStore(MasterStore ms);
    public void deleteMasterStore(int msId);
    public void updateMasterStore(MasterStore ms);
    public MasterStore selectMasterStore(int msId);
    public List<MasterStore> selectMSList(int masterId);
}
