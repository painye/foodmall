package com.yp.foodmall.store.mapper;

import com.yp.foodmall.common.entity.Master;
import com.yp.foodmall.common.entity.MasterStore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMasterStoreMapper {
    public int insertMasterStore(MasterStore ms);
    public int deleteMasterStore(int msId);
    public int updateMasterStore(MasterStore ms);
    public MasterStore selectMasterStore(int msId);
    public List<MasterStore> selectMSList(int masterId);
}
