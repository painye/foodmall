package com.yp.foodmall.user.service.impl;

import com.yp.foodmall.common.entity.ComStore;
import com.yp.foodmall.common.entity.Order;
import com.yp.foodmall.common.entity.User;
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
        System.out.println(order);
        Integer count = order.getCount();
        Integer comStoreId = order.getComStore().getComStoreId();
        //多模块调用，调用store模块中的com_store中的服务查询com_store表中的某id下的所有数据，拿到当前这个商铺所售物品的基本信息，以comStore来回收
        ComStore comStore = restTemplate.getForObject("http://localhost:8096/app/com_store/selectComStore.do?comStoreId="+comStoreId, ComStore.class);
        Integer stock = comStore.getStock();
        Integer sales = comStore.getSales();
        System.out.println(stock);
        System.out.println(sales);
        //比较在该商铺中该商品的库存是否够卖，不购卖订单状态为-1，够卖未付款订单状态为0， 够卖且成功付款订单状态为0
        if(stock-count<0){
            order.setStatus(-1);
        }
        else {
            order.setStatus(0);
            //当前即表示下单成功但还未购买
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
    public int purchase(int orderId, String userName, String moneyPassword) {
        Order order = iOrderMapper.selectOrderById(orderId);
        User user = order.getUser();
        //如果用户名和支付密码匹配成功
        int flag=0;
        if(userName.equals(user.getUserName())&&moneyPassword.equals(user.getMoneyPassword())){
            flag = 1;
            int stock = order.getComStore().getStock();
            int sales = order.getComStore().getSales();
            Integer count = order.getCount();
            System.out.println(stock+" "+sales+" "+ count);
            Integer comStoreId = order.getComStore().getComStoreId();
            System.out.println(order.getComStore());
            ComStore cs = new ComStore();
            cs.setComStoreId(comStoreId);
            System.out.println(stock-count);
            cs.setStock(stock - count);
            cs.setSales(sales+count);
            System.out.println(cs);
            //购买成功去修改商铺商品的库存和销量
            restTemplate.postForObject("http://localhost:8096/app/store/manage/updateComStore.do", cs, Object.class);
            iOrderMapper.updateOrder(orderId, 1);
        }else   flag=0;
        return flag;
    }
}
