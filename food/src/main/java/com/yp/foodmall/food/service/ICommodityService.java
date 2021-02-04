package com.yp.foodmall.food.service;

import com.yp.foodmall.food.entity.Commodity;

import java.util.List;

public interface ICommodityService {
    public void insertCom(Commodity com);
    public void deleteCom(String commodityNumber);
    public void updateCom(Commodity com);
    public void selectOneByNUmber(String commodityNumber);
    public void selectOne(Commodity com);
}