package com.example.sell.exception;

import com.example.sell.enums.ResultEnum;

/**
 * @author ZRL
 * @date 2020/12/7 2:30
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
