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

    @Override
    public ComStore selectComStoreCS(int commodityId, int storeId) {
        ComStore comStore = iComStoreMapper.selectComStoreCS(commodityId, storeId);
        return  comStore;
    }

    @Override
    public void updateStock(int commodityId, int storeId, int count) {
        iComStoreMapper.updateStock(commodityId, storeId, count);
    }

    @Override
    public List<ComStore> selectComStoreByComId(int comId) {
        List<ComStore> comStores = iComStoreMapper.selectComStoreByComId(comId);
        System.out.println(comId);
        System.out.println(comStores);
        return comStores;
    }


}
