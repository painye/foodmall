package com.yp.foodmall.user.mapper;

import com.yp.foodmall.common.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IOrderMapper {

    public int insertOrder(Order order);
    public int deleteOrder(int orederId);
    public Order selectOrderById(int orderId);
    public int updateOrder(int status);
    public List<Order> selectOrderByUser(int userId);
    public List<Order> selectOrderByCom(int comId);
    public List<Order> selectOrderByStore(int storeId);

}
