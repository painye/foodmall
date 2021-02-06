package com.yp.foodmall.store.mapper;

import com.yp.foodmall.common.entity.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStoreMapper {
    public int insertStore(Store store);
    public int deleteStoreById(int storeId);
    public int updateStore(Store store);
    public Store selectStoreById(int storeId);
    public List<Store> selectStoreList(String management);
}
