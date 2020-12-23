package com.example.sell.service.impl;

import com.example.sell.dataobject.ProductCategory;
import com.example.sell.mapper.ProductCategoryMapper;
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
 * @date 2020/12/4 1:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryServiceImplTest {
    @Autowired
    ProductCategoryMapper mapper;

    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = mapper.findAll();
        System.out.println(productCategoryList.size());
        for (ProductCategory productCategory: productCategoryList) {
            System.out.println(productCategory);  //因为无参构造？
            System.out.println(productCategory.toString());
        }

    }
}