package com.yp.foodmall.user.controller;

import com.yp.foodmall.common.entity.Order;
import com.yp.foodmall.user.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "订单管理")
@RequestMapping("/app/foodmall/user/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @ApiOperation("购买产生新的订单")
    @PutMapping("/insertOrder.do")
    public void insertOder(@RequestBody Order order){
        iOrderService.insertOrder(order);
    }

    @ApiOperation("删除订单")
    @PostMapping("/deleteOrder.do")
    public void deleteOrder(int orderId){
        iOrderService.deleteOrder(orderId);
    }

    @ApiOperation("查看某次订单")
    @GetMapping("selectOrderById.do")
    public Order selectOrderById(int orderId){
        Order order = iOrderService.selectOrderById(orderId);
        System.out.println(order);
        return order;
    }

    @ApiOperation("某用户的订单记录")
    @GetMapping("/selectOrderByUser.do")
    public List<Order> selectOrderByUser(int userId){
        List<Order> orders = iOrderService.selectOrderByUser(userId);
        return orders;
    }

    @ApiOperation("根据商品查看订单记录")
    @GetMapping("/selectOrderByCom.do")
    public List<Order> selectOrderByCom(int comId){
        List<Order> orders = iOrderService.selectOrderByCom(comId);
        return orders;
    }

    @ApiOperation("根据商铺查看订单记录")
    @GetMapping("/selectOrderByStore.do")
    public List<Order> selectOrderByStore(int storeId){
        List<Order> orders = iOrderService.selectOrderByStore(storeId);
        return orders;
    }


    @ApiOperation("购买")
    @PostMapping("/purchase.do")
    public int purchase(int orderId, String username, String moneyPassword){
        return iOrderService.purchase(orderId, username, moneyPassword);
    }

    @ApiOperation("某用户最近的一次订单进行付款")
    @PostMapping("/buyLast.do")
    public int buyLast(@Param("userId") Integer userId, @Param("userName") String userName,@Param("moneyPassword") String moneyPassword){
        System.out.println(userId+" "+userName+" "+moneyPassword);
        return iOrderService.buyLast(userId, userName, moneyPassword);
    }

}
