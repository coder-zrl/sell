package com.example.sell.controller;

import com.example.sell.dto.WeixinDTO;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 微信端的调试
 * @author ZRL
 * @date 2020/12/10 1:25
 */
@Slf4j
@RestController
@RequestMapping("/weixin")
public class WeixinController {
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入了auth方法");
        log.info("【获取code】code={}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx6640a7f5b82ebd37&secret=85cf924b23a717e12caf329150b988c9&code=" + code + "&grant_type=authorization_code";
        //Spring提供了一个简单便捷的模板类实现java代码访问restful服务
        //get是指调用get方法，object是我们要转化成的类型
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}",response);
        Gson gson = new Gson();
        WeixinDTO data = gson.fromJson(response,WeixinDTO.class);
        log.info("openid={}",data.getOpenid());
    }
}
