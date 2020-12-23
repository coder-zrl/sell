package com.example.sell.dataobject;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZRL
 * @date 2020/12/5 2:40
 */

@Data
public class OrderDetail {
//    @Column(detail_id)
    private String detailId;
    //订单id
    private String orderId;
    //商品id
    private String productId;
    //商品名称
    private String productName;
    //商品单价
    private BigDecimal productPrice;
    //商品数量
    private int productQuantity;
    //商品小图
    private String productIcon;


}
