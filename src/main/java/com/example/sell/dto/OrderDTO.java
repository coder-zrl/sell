package com.example.sell.dto;

import com.example.sell.dataobject.OrderDetail;
import com.example.sell.enums.OrderStatusEnum;
import com.example.sell.enums.PayStatusEnum;
import com.example.sell.utils.CodeEnumUtil;
import com.example.sell.utils.serialize.Data2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ZRL
 * @date 2020/12/7 2:17
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    //订单id
    private String orderId;
    //买家名字
    private String buyerName;
    //买家手机号
    private String buyerPhone;
    //买家地址
    private String buyerAddress;
    //买家微信
    private String buyerOpenid;
    //订单总金额
    private BigDecimal orderAmount;
    //订单状态，默认是新下单
    private int orderStatus;
    //支付状态，默认为0等待支付
    private int payStatus;
    //创建时间
    @JsonSerialize(using = Data2LongSerializer.class)
    private Date createTime;
    //更新时间
    @JsonSerialize(using = Data2LongSerializer.class)
    private Date updateTime;
    //用起来方便
    private List<OrderDetail> orderDetailList;
    @JsonIgnore
    public String getOrderStatusEnum() {
        return CodeEnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public String getPayStatusEnum() {
        return CodeEnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
