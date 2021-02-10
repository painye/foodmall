package com.yp.foodmall.user.service;

import com.yp.foodmall.common.entity.Order;

import java.util.List;

public interface IOrderService {
    public void insertOrder(Order order);
    public void deleteOrder(int orederId);
    public Order selectOrderById(int orederId);
    public List<Order> selectOrderByUser(int userId);
    public List<Order> selectOrderByCom(int comId);
    public List<Order> selectOrderByStore(int storeId);

    public int purchase(int orderId, String userName, String moneyPassword);
}
