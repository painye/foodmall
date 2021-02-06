package com.yp.foodmall.store.mapper;

import com.yp.foodmall.common.entity.Master;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMasterMapper {
    public int insertMaster(Master master);
    public int deleteMaster(int masterId);
    public int updateMaster(Master master);
    public Master selectMasterNamePassword(@Param("masterName") String masterName, @Param("masterPassword") String masterPassword);
    public Master selectMasterById(int masterId);
}
