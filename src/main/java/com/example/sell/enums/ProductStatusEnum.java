package com.example.sell.enums;

import lombok.Getter;

/**
 * @author ZRL
 * @date 2020/12/3 17:21
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"上架"),
    DOWN(1,"下架");

    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
