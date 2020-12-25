package com.example.sell.service.impl;

import com.example.sell.dto.OrderDTO;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.service.BuyerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.RecursiveTask;

/**
 * @author ZRL
 * @date 2020/12/10 0:12
 */
@Slf4j
@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderServiceImpl orderService;
    @Override
    public OrderDTO findOrderone(String openId, String orderId) {
        return checkOrderOwner(openId, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openId, orderId);
        if (orderDTO==null) {
            log.error("【取消订单】查不到订单，orderid={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancle(orderDTO);
    }
    private OrderDTO checkOrderOwner(String openId, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO==null) {
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openId)) {
            log.error("【查询订单】订单的openid不一致，openid={}，orderDTO={}",openId,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
