package com.example.sell.dto;

import lombok.Data;

/**
 * 用来接收微信授权后，code获取access_token的类
 * @author ZRL
 * @date 2020/12/10 2:00
 */
@Data
public class WeixinDTO {
    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
}
