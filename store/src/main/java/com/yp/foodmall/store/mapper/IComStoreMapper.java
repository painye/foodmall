package com.yp.foodmall.store.mapper;

import com.yp.foodmall.common.entity.ComStore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IComStoreMapper {
    public int insertComStore(ComStore comStore);
    public int deleteComStore(int comStoreId);
    public int updateComStore(ComStore comStore);
    public ComStore selectComStore(int comStoreId);
    public List<ComStore> selectComStoreList(ComStore comStore);
}
