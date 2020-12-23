package com.example.sell.service;

import com.example.sell.dto.OrderDTO;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

/**
 * @author ZRL
 * @date 2020/12/10 0:07
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderone(String openid,String orderid);
    //取消一个订单
    OrderDTO cancelOrder(String openid,String orderid);
}
