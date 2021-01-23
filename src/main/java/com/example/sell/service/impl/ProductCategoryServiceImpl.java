package com.example.sell.service.impl;

import com.example.sell.dataobject.ProductCategory;
import com.example.sell.dataobject.ProductInfo;
import com.example.sell.mapper.ProductCategoryMapper;
import com.example.sell.mapper.ProductInfoMapper;
import com.example.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZRL
 * @date 2020/12/4 0:52
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper mapper;
    @Override
    public List<ProductCategory> findAll() {
        return mapper.findAll();
    }

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return mapper.findone(categoryId);
    }

    @Override
    public void save(ProductCategory productCategory) {
        mapper.save(productCategory);
    }

    @Override
    public void update(ProductCategory productCategory) {
        mapper.updateOne(productCategory);
    }
}
