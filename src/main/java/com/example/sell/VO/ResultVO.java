package com.example.sell.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @author ZRL
 * @date 2020/12/3 19:42
 */
@Data
public class ResultVO<T> {
    //错误码
    private int code;
    //提示信息
    private String msg;
    private T data;
}
