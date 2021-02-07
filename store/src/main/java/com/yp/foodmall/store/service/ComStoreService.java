package com.yp.foodmall.store.service;

import com.yp.foodmall.common.entity.ComStore;

import java.util.List;

public interface ComStoreService {
    public void insertComStore(ComStore comStore);
    public void deleteComStore(int comStoreId);
    public void updateComStore(ComStore comStore);
    public ComStore selectComStore(int comStoreId);
    public List<ComStore> selectComStoreList(ComStore comStore);
}
