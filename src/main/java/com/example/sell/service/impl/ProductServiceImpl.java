package com.example.sell.service.impl;

import com.example.sell.dataobject.ProductInfo;
import com.example.sell.dto.CartDTO;
import com.example.sell.enums.ProductStatusEnum;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.mapper.ProductInfoMapper;
import com.example.sell.service.ProductCategoryService;
import com.example.sell.service.ProductService;
import com.example.sell.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZRL
 * @date 2020/12/3 17:03
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public ProductInfo findone(String productId) {
        return productInfoMapper.getProductById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoMapper.getProductByStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoMapper.getAllProduct();
    }

    @Override
    public void save(ProductInfo productInfo) {
        if (productInfo.getProductId().equals("")) {
            productInfo.setProductId(KeyUtil.genUniqueKey());
        } else {
            productInfoMapper.deleteOne(productInfo.getProductId());
        }
        productInfoMapper.save(productInfo);
    }

    @Override
    @Transactional
    public void inceraseStock(List<CartDTO> cartDTOList) {
        return;
    }

    @Override
    @Transactional
    public void deceraseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList) {
            System.out.println(cartDTO.getProductId());
            String id = cartDTO.getProductId();
            ProductInfo productInfo = productInfoMapper.getProductById(id);
            System.out.println(1111);
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result<0) {
                throw new SellException(ResultEnum.PRODUCT_NOT_ENOUGH);
            } else {
                productInfoMapper.setProductStock(productInfo.getProductId(), result);
            }
        }
    }

    //商品上架
    @Override
    public Integer onSale(String productId) {
        Integer res = productInfoMapper.onSale(productId);
        if (res==null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        return 1;
    }
    //商品下架
    @Override
    public Integer offSale(String productId) {
        Integer res = productInfoMapper.offSale(productId);
        if (res==null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        return 0;
    }
}
