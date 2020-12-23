package com.example.sell.form;


import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.scheduling.support.SimpleTriggerContext;

/**
 * 做表单验证的
 * @author ZRL
 * @date 2020/12/8 23:42
 */
@Data
public class OrderForm {
    //买家姓名
    private String name;
    //买家手机号
    private String phone;
    //买家地址
    private String address;
    //买家id
    private String openid;
    //订单内容id+数量
    private String items;
}
