package com.example.sell.service;

import com.example.sell.dataobject.ProductInfo;
import com.example.sell.dto.CartDTO;


import java.util.List;

/**
 * 商品
 * @author ZRL
 * @date 2020/12/3 16:56
 */
public interface ProductService {
    //查看一条商品信息
    ProductInfo findone(String productId);
    //查询所有上架商品
    List<ProductInfo> findUpAll();
    //查询所有商品
    List<ProductInfo> findAll();
    //保存商品
    void save(ProductInfo productInfo);
    //加库存
    void inceraseStock(List<CartDTO> cartDTOList);
    //减库存
    void deceraseStock(List<CartDTO> cartDTOList);
    //商品上架
    Integer onSale(String productId);
    //商品下架
    Integer offSale(String productId);
}
