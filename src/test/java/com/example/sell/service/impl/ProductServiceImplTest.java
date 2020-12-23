package com.example.sell.service.impl;

import com.example.sell.dto.CartDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ZRL
 * @date 2020/12/7 3:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    ProductServiceImpl productServer;

    @Test
    void inceraseStock() {
    }

    @Test
    void deceraseStock() {
        List<CartDTO> cartDTOList = new ArrayList<>();
        cartDTOList.add(new CartDTO("1",10));
        productServer.deceraseStock(cartDTOList);
    }
}