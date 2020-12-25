package com.example.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zrl
 * @date 2020-12-20 19:34
 */
@Data
public class ProductForm {
    //id
    private String productId;
    //名字
    private String productName;
    //单价
    private BigDecimal productPrice;
    //库存
    private int productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;
    //类目编号
    private int categoryType;
}
