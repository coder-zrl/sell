package com.example.sell.mapper;

import com.example.sell.dataobject.ProductInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ZRL
 * @date 2020/12/3 11:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoMapperTest {
    @Autowired
    ProductInfoMapper mapper;

    @Test
    void insertProduct(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1111");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductPrice(new BigDecimal(3.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝");
        productInfo.setProductIcon("https://www.paidu.com");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        mapper.save(productInfo);
    }

    @Test
    void getProductByStatus() {
        List<ProductInfo> res = mapper.getProductByStatus(1);
//        System.out.println(res);
        for (ProductInfo data: res) {
            System.out.println(data.toString());
        }
    }

    @Test
    void testInsertProduct() {
    }

    @Test
    void testGetProductByStatus() {
    }

    @Test
    void getProductById() {
        ProductInfo productInfo = mapper.getProductById("1");
        System.out.println(productInfo.toString());
    }

    @Test
    void getAllProduct() {
    }

    @Test
    void setProductStock() {
    }
}