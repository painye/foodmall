package com.yp.foodmall.food.service;

import com.yp.foodmall.food.entity.Category;
import com.yp.foodmall.food.entity.Commodity;

import java.util.List;

public interface ICommodityService {
    //对商品表的直接操作
    public void insertCom(Commodity com);
    public void deleteCom(int commodityNumber);
    public void updateCom(Commodity com);
    public Commodity selectOneByNUmber(int id);
    public List<Commodity> selectList(Commodity com);

    //对category表的直接操作
    public void insertCate(Category category);
    public void deleteCate(int categoryId);
    public void updateCate(Category category);
}
