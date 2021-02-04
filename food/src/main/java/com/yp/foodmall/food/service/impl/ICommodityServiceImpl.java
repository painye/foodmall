package com.yp.foodmall.food.service.impl;

import com.yp.foodmall.food.entity.Commodity;
import com.yp.foodmall.food.mapper.IComMapper;
import com.yp.foodmall.food.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
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
    public void deleteCom(String commodityNumber) {
        comMapper.deleteCom(commodityNumber);
    }

    @Override
    public void updateCom(Commodity com) {
        comMapper.updateCom(com);
    }

    @Override
    public void selectOneByNUmber(String commodityNumber) {
        comMapper.selectOneByNUmber(commodityNumber);
    }

    @Override
    public void selectOne(Commodity com) {
        comMapper.selectList(com);
    }
}
