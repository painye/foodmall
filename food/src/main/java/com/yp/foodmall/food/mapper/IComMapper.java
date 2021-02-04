package com.yp.foodmall.food.mapper;

import com.yp.foodmall.food.entity.Commodity;

import java.util.List;

public interface IComMapper {
    public int insertCom(Commodity com);
    public int deleteCom(String commodityNumber);
    public int updateCom(Commodity com);
    public Commodity selectOneByNUmber(String commodityNumber);
    public List<Commodity> selectOne(Commodity com);
}
