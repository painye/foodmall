package com.yp.foodmall.store.service;

import com.yp.foodmall.common.entity.ComStore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComStoreService {
    public void insertComStore(ComStore comStore);
    public void deleteComStore(int comStoreId);
    public void updateComStore(ComStore comStore);
    public ComStore selectComStore(int comStoreId);
    public List<ComStore> selectComStoreList(ComStore comStore);

    public ComStore selectComStoreCS(int commodityId, int storeId);
    public void updateStock(int commodityId, int storeId, int count);
    public List<ComStore> selectComStoreByComId(int comId);
}
