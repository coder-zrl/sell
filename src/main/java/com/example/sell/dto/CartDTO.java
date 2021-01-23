package com.example.sell.dto;

import lombok.Data;

/**
 * 购物车
 * @author ZRL
 * @date 2020/12/7 2:58
 */
@Data
public class CartDTO {
    //商品id
    private String productId;
    //数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
