package com.example.sell.enums;

import io.swagger.models.auth.In;
import lombok.Getter;

/**
 * @author ZRL
 * @date 2020/12/5 2:30
 */

@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),
    FINISHED(1,"已完成"),
    CANCEL(2,"已取消");
    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
