package com.yp.foodmall.store.service.impl;

import com.yp.foodmall.common.entity.ComStore;
import com.yp.foodmall.store.mapper.IComStoreMapper;
import com.yp.foodmall.store.service.ComStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IComStoreServiceImpl implements ComStoreService {
    @Autowired
    private IComStoreMapper iComStoreMapper;

    @Override
    public void insertComStore(ComStore comStore) {
        Date date=new Date();
        comStore.setCreateTime(date);
        comStore.setSales(0);
        comStore.setStock(0);
        comStore.setDeleteEnable(0);
        iComStoreMapper.insertComStore(comStore);
    }

    @Override
    public void deleteComStore(int comStoreId) {
        iComStoreMapper.deleteComStore(comStoreId);
    }

    @Override
    public void updateComStore(ComStore comStore) {
        Date date=new Date();
        comStore.setUpdateTime(date);
        iComStoreMapper.updateComStore(comStore);
    }

    @Override
    public ComStore selectComStore(int comStoreId) {
        ComStore comStore = iComStoreMapper.selectComStore(comStoreId);
        return comStore;
    }

    @Override
    public List<ComStore> selectComStoreList(ComStore comStore) {
        List<ComStore> comStores = iComStoreMapper.selectComStoreList(comStore);
        return comStores;
    }
}
