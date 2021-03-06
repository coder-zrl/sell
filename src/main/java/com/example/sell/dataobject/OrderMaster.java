package com.example.sell.dataobject;

import com.example.sell.enums.OrderStatusEnum;
import com.example.sell.enums.PayStatusEnum;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author ZRL
 * @date 2020/12/5 2:18
 */

@Data
public class OrderMaster {
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
    private int orderStatus = OrderStatusEnum.NEW.getCode();
    //支付状态，默认为0等待支付
    private int payStatus = PayStatusEnum.WAIT.getCode();
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
