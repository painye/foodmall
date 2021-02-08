package com.yp.foodmall.store.service;


/**
 * 管理各商铺的商品
 */
public interface ManageComStore {
    public void stockUp(int comId, Integer storeId);
    public void stockOut(String comName, String storeName);
}
