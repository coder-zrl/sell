package com.example.sell.controller;

import com.example.sell.dataobject.User;
import com.example.sell.dto.OrderDTO;
import com.example.sell.dto.UserDto;
import com.example.sell.mapper.UserMapper;
import com.example.sell.page.OrderDTOPage;
import com.example.sell.service.Websocket;
import com.example.sell.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zrl
 * @date 2020-12-23 19:08
 */
@RestController
public class LoginController {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    Websocket websocket;

    //登录
    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("common/index");
    }
    //登出
    @GetMapping("/seller/logout")
    public ModelAndView logout(Map<String,Object> map){
        map.put("msg","登出！");
        map.put("url","/sell");
        return new ModelAndView("common/success",map);
    }

    //登陆验证与跳转
    //跳转应该使用js代码完成，但是我不想费劲了，直接copy了
    @PostMapping("/login")
    public void login(@Validated UserDto userDto,
                              Map<String,Object> map) {
        User trueUser = userMapper.findone(userDto.getId());
        if (trueUser == null) {
            websocket.sendMessage("用户不存在");
        }

        if (userDto.getPassword().equals(trueUser.getPassword())) {
            if(trueUser.getType().equals(0)) {
                websocket.sendMessage("用户登陆成功");
            } else {
                websocket.sendMessage("管理员登陆成功");
            }
        } else {
            websocket.sendMessage("密码错误");
        }
    }
}
