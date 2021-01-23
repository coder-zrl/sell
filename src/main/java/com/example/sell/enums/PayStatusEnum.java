package com.example.sell.enums;

import lombok.Getter;

/**
 * @author ZRL
 * @date 2020/12/5 2:35
 */
@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }



}
