package com.example.sell.mapper;

import com.example.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {
    @Autowired
    ProductCategoryMapper mapper;
    @Test
    public void selectProgect(){
        ProductCategory productCategory = mapper.getProductCategoryNameById(1);
        System.out.println(productCategory.toString());
    }
}