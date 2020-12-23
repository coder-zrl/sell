package com.example.sell.service.impl;

import com.example.sell.dataobject.OrderDetail;
import com.example.sell.dataobject.OrderMaster;
import com.example.sell.dto.CartDTO;
import com.example.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ZRL
 * @date 2020/12/7 18:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class OrderServiceImplTest {
    @Autowired
    OrderServiceImpl orderService;

    @Test
    void creatOrderDto() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小黑龙");
        orderDTO.setBuyerPhone("12345678912");
        orderDTO.setBuyerAddress("湖北武汉");
        orderDTO.setBuyerOpenid("123");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1");//产品id
        o1.setProductQuantity(4);//产品购买数量
        orderDetailList.add(o1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("2");//产品id
        o2.setProductQuantity(3);//产品购买数量
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.creatOrderDto(orderDTO);
        log.info("[创建订单 result={}]",result);
    }


    @Test
    void findOne() {
        OrderDTO one = orderService.findOne("1607351759686836693");
        System.out.println(one.toString());
    }

    @Test
    void findList() {
        System.out.println(orderService.findList("123").toString());;
    }

    @Test
    void cancle() {
        OrderDTO orderDTO = orderService.findOne("1607351759686836693");
        OrderDTO result = orderService.cancle(orderDTO);
    }

    @Test
    void finish() {
        OrderDTO orderDTO = orderService.findOne("1607351759686836693");
        OrderDTO result = orderService.finish(orderDTO);
    }

    @Test
    void paid() {
        OrderDTO orderDTO = orderService.findOne("1607351759686836693");
        OrderMaster result = orderService.paid(orderDTO);
    }
}