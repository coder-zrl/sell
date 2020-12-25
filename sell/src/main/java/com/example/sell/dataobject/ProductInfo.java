package com.example.sell.dataobject;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * @author ZRL
 * @date 2020/12/3 11:13
 */
@Data
public class ProductInfo {
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
    //状态  0正常，1下架
    private int productStatus;
    //类目编号
    private int categoryType;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
