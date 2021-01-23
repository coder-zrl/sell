package com.example.sell.service;

import com.example.sell.dataobject.ProductCategory;
import com.example.sell.dataobject.ProductInfo;

import java.util.List;

/**
 * 类目
 */

public interface ProductCategoryService {
    //查询所有类目
    List<ProductCategory> findAll();
    //查询一个
    ProductCategory findOne(Integer categoryId);
    //保存
    void save(ProductCategory productCategory);
    //删除
    void update(ProductCategory productCategory);
}
