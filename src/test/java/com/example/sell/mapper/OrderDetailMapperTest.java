package com.example.sell.mapper;

import com.example.sell.dataobject.OrderDetail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ZRL
 * @date 2020/12/7 1:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailMapperTest {
    @Autowired
    OrderDetailMapper mapper;

    @Test
    void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("4");
        orderDetail.setOrderId("11");
        orderDetail.setProductId("122");
        orderDetail.setProductName("大米粥");
        orderDetail.setProductPrice(new BigDecimal(3.5));
        orderDetail.setProductQuantity(15);
        orderDetail.setProductIcon("https://www.baidu.com");
        mapper.save(orderDetail);
    }

    @Test
    void findByOrderId() {
        List<OrderDetail> orderDetailList = mapper.findByOrderId("1607351759686836693");
        System.out.println(orderDetailList.toString());
    }
}