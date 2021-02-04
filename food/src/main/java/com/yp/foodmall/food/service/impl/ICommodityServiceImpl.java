package com.yp.foodmall.food.service.impl;

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
        com.setDeleteEnable(0);
        com.setSales(0);
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
    public Commodity selectOneByNUmber(String commodityNumber) {
       return comMapper.selectOneByNUmber(commodityNumber);
    }

    @Override
    public List<Commodity> selectList(Commodity com) {
        List<Commodity> commodities = comMapper.selectList(com);
        return commodities;
    }
}
