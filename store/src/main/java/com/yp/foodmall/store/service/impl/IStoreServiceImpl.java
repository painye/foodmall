package com.yp.foodmall.store.service.impl;

import com.yp.foodmall.common.entity.Store;
import com.yp.foodmall.store.mapper.IStoreMapper;
import com.yp.foodmall.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class IStoreServiceImpl implements StoreService {
    @Autowired
    private IStoreMapper iStoreMapper;

    @Override
    public void insertStore(Store store) {
        Date date=new Date();
        store.setUpdateTime(date);
        store.setDeleteEnable(0);
        iStoreMapper.insertStore(store);
    }

    @Override
    public void deleteStore(int storeId) {
        iStoreMapper.deleteStoreById(storeId);

    }

    @Override
    public void updateStore(Store store) {
        Date date=new Date();
        store.setUpdateTime(date);
        iStoreMapper.updateStore(store);
    }

    @Override
    public Store selectStoreById(int storeId) {
        Store store = iStoreMapper.selectStoreById(storeId);
        return store;
    }

    @Override
    public List<Store> slectStoreList(String management) {
        List<Store> stores = iStoreMapper.selectStoreList(management);
        return stores;
    }
}
