package com.example.sell.controller;


import com.example.sell.VO.ResultVO;
import com.example.sell.converiter.OrderForm2OrderDTO;
import com.example.sell.dto.OrderDTO;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.form.OrderForm;
import com.example.sell.service.impl.BuyerServiceImpl;
import com.example.sell.service.impl.OrderServiceImpl;
import com.example.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZRL
 * @date 2020/12/8 23:38
 */

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    BuyerServiceImpl buyerService;

    //创建订单
    @PostMapping("/creat")
    public ResultVO<Map<String,String>> creat(@Validated OrderForm orderForm,
                                              BindingResult bindingResult){
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if (orderDTO==null) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO creatOrderDto = orderService.creatOrderDto(orderDTO);
        orderDTO.setOrderId(creatOrderDto.getOrderId());
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderDTO.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid){
        if (StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        List<OrderDTO> orderDTOList = orderService.findList(openid);
        return ResultVOUtil.success(orderDTOList);
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderid") String orderid){
        //TODO  不安全的做法
        OrderDTO orderDTO = buyerService.findOrderone(openid, orderid);
        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderid") String orderid){
        buyerService.cancelOrder(openid, orderid);
        return ResultVOUtil.success();
    }
}
