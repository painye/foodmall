package com.yp.foodmall.food.service.impl;

import com.yp.foodmall.food.entity.Category;
import com.yp.foodmall.food.entity.Commodity;
import com.yp.foodmall.food.mapper.IComMapper;
import com.yp.foodmall.food.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ICommodityServiceImpl implements ICommodityService {
    @Autowired
    private IComMapper comMapper;

    @Override
    public void insertCom(Commodity com) {
        Date date =new Date();
        com.setCreateTime(date);
        comMapper.insertCom(com);
    }

    @Override
    public void deleteCom(int id) {
        comMapper.deleteCom(id);
    }

    @Override
    public void updateCom(Commodity com) {
        comMapper.updateCom(com);
    }

    @Override
    public Commodity selectOneByNUmber(int id) {
       return comMapper.selectOneByNUmber(id);
    }

    @Override
    public List<Commodity> selectList(Commodity com) {
        List<Commodity> commodities = comMapper.selectList(com);
        return commodities;
    }

    @Override
    public void insertCate(Category category) {
        comMapper.insertCategory(category);
    }

    @Override
    public void deleteCate(int categoryId) {
        comMapper.deleteCategory(categoryId);
    }

    @Override
    public void updateCate(Category category) {
        comMapper.updateCategory(category);
    }
}
