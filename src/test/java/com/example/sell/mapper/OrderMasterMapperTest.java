package com.example.sell.mapper;

import com.example.sell.dataobject.OrderMaster;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ZRL
 * @date 2020/12/5 3:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterMapperTest {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Test
    void insertProductCategory() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2");
        orderMaster.setBuyerName("阿龙");
        orderMaster.setBuyerPhone("123456789012");
        orderMaster.setOrderAmount(new BigDecimal(3.5));
        orderMasterMapper.save(orderMaster);
    }

    @Test
    void findByBuyerOpenId() {
//        OrderMaster orderMaster = new OrderMaster();
        List<OrderMaster> orderMasterList = orderMasterMapper.findByBuyerOpenId("123");
        System.out.println(orderMasterList.toString());
    }

    @Test
    void save() {
    }

    @Test
    void testFindByBuyerOpenId() {
    }

    @Test
    void findByOrderId() {
        System.out.println(orderMasterMapper.findByOrderId("1607351759686836693").toString());;
    }
}