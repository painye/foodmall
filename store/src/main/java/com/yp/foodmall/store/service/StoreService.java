package com.yp.foodmall.store.service;

import com.yp.foodmall.common.entity.Store;

import java.util.List;

public interface StoreService {
    public void insertStore(Store store);
    public void deleteStore(int storeid);
    public void updateStore(Store store);
    public Store selectStoreById(int storeId);
    public List<Store> slectStoreList(String management);
}
