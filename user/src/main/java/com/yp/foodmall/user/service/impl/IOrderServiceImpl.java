package com.yp.foodmall.user.service.impl;

import com.yp.foodmall.common.entity.ComStore;
import com.yp.foodmall.common.entity.Order;
import com.yp.foodmall.user.mapper.IOrderMapper;
import com.yp.foodmall.user.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
@Service
public class IOrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderMapper iOrderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void insertOrder(Order order) {
//        List<Commodity> commodity = restTemplate.getForObject("http://localhost:8099/app/food/commodity/findCommodityList.do?comName=三只松鼠坚果大礼包", List.class);
        Integer count = order.getCount();
        Integer comStoreId = order.getComStore().getComStoreId();
        ComStore comStore = restTemplate.getForObject("http://localhost:8096/app/com_store/selectComStore.do?comStoreId="+comStoreId, ComStore.class);
        Integer stock = comStore.getStock();
        Integer sales = comStore.getSales();
        System.out.println(stock);
        System.out.println(sales);
        if(stock-count<0){
            order.setStatus(-1);
        }
        else {
            order.setStatus(0);
            ComStore cs = new ComStore();
            cs.setComStoreId(comStoreId);
            cs.setStock(stock - count);
            cs.setSales(sales+count);
            System.out.println(cs);
            restTemplate.postForObject("http://localhost:8096/app/store/manage/updateComStore.do", cs, Object.class);
        }
        order.setDelete_enable(0);
        Date date = new Date();
        order.setCreateTime(date);
        iOrderMapper.insertOrder(order);
    }

    @Override
    public void deleteOrder(int orederId) {
        iOrderMapper.deleteOrder(orederId);
    }

    @Override
    public Order selectOrderById(int orederId) {
        Order order = iOrderMapper.selectOrderById(orederId);
        return order;
    }

    @Override
    public List<Order> selectOrderByUser(int userId) {
        List<Order> orders = iOrderMapper.selectOrderByUser(userId);
        return orders;
    }

    @Override
    public List<Order> selectOrderByCom(int comId) {
        List<Order> orders = iOrderMapper.selectOrderByCom(comId);
        return orders;
    }

    @Override
    public List<Order> selectOrderByStore(int storeId) {
        List<Order> orders = iOrderMapper.selectOrderByStore(storeId);
        return orders;
    }

    @Override
    public void updateOrder(int status) {
        iOrderMapper.updateOrder(status);
    }
}
