package com.example.sell.service;

import com.example.sell.dataobject.OrderMaster;
import com.example.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author ZRL
 * @date 2020/12/7 2:13
 */
public interface OrderService {
    //创建订单，一个订单可能对应多个商品
    OrderDTO creatOrderDto(OrderDTO orderDto);
    //查询，单个订单
    OrderDTO findOne(String orderId);
    //查询某个人的订单列表
    List<OrderDTO> findList(String buyerOpenid);
    //查询所有的订单
    List<OrderDTO> findList();
    //取消订单
    OrderDTO cancle(OrderDTO orderDTO);
    //完结订单
    OrderDTO finish(OrderDTO orderDTO);
    //支付订单
    OrderMaster paid(OrderDTO orderDTO);
}
