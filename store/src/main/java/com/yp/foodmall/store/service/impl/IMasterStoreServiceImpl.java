package com.yp.foodmall.store.service.impl;

import com.yp.foodmall.common.entity.MasterStore;
import com.yp.foodmall.store.mapper.IMasterStoreMapper;
import com.yp.foodmall.store.service.MasterStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IMasterStoreServiceImpl implements MasterStoreService {
    @Autowired
    private IMasterStoreMapper iMasterStoreMapper;

    @Override
    public void insertMasterStore(MasterStore ms) {
        Date date=new Date();
        ms.setCreateTime(date);
        ms.setDeleteEnable(0);
        iMasterStoreMapper.insertMasterStore(ms);
    }

    @Override
    public void deleteMasterStore(int msId) {
        iMasterStoreMapper.deleteMasterStore(msId);
    }

    @Override
    public void updateMasterStore(MasterStore ms) {
        Date date=new Date();
        ms.setUpdateTime(date);
        iMasterStoreMapper.updateMasterStore(ms);
    }

    @Override
    public MasterStore selectMasterStore(int msId) {
        MasterStore masterStore = iMasterStoreMapper.selectMasterStore(msId);
        return masterStore;
    }

    @Override
    public List<MasterStore> selectMSList(int masterId) {
        List<MasterStore> masterStores = iMasterStoreMapper.selectMSList(masterId);
        return masterStores;
    }
}
