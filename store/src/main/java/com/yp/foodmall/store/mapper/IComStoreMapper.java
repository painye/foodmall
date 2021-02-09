package com.yp.foodmall.store.mapper;

import com.yp.foodmall.common.entity.ComStore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IComStoreMapper {
    public int insertComStore(ComStore comStore);
    public int deleteComStore(int comStoreId);
    public int updateComStore(ComStore comStore);
    public ComStore selectComStore(int comStoreId);
    public List<ComStore> selectComStoreList(ComStore comStore);

    public List<ComStore> selectComStoreByComId(int comId);


    public ComStore selectComStoreCS(@Param("commodityId") int commodityId, @Param("StoreId") int StoreId);
    public int updateStock(@Param("commodityId") int commodityId, @Param("StoreId") int StoreId, @Param("count") int count);
}
