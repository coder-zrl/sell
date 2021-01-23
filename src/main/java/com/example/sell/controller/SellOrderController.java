package com.example.sell.controller;

import com.example.sell.dto.OrderDTO;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.page.OrderDTOPage;
import com.example.sell.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 卖家端订单
 * @author zrl
 * @date 2020-12-17 0:17
 */
@RestController
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellOrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map) {  //因为要使用模板渲染，所以返回类型是ModelAndView

        List<OrderDTO> orderDTOList = orderService.findList();
        OrderDTOPage orderDTOPage = new OrderDTOPage(orderDTOList,size,page);
        map.put("orderDTOPage",orderDTOPage);
        map.put("page",page);
        map.put("size",size);

        return new ModelAndView("order/list",map);
    }
    //完成
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String,Object> map) {
        OrderDTO orderDTO =new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (Exception e) {
            log.error("【卖家完结订单】查询不到订单");
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");  //因为这个不是spring的，所以要加/sell
            return new ModelAndView("common/error",map);
        }
        try {
            orderService.finish(orderDTO);
        } catch (SellException e) {
            log.error("【卖家完结订单】订单状态改变失败");
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");  //因为这个不是spring的，所以要加/sell
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
    //取消
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String,Object> map) {

        OrderDTO orderDTO =new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("【卖家取消订单】查询不到订单");
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");  //因为这个不是spring的，所以要加/sell
            return new ModelAndView("common/error",map);
        }
        try {
            orderService.cancle(orderDTO);
        } catch (SellException e) {
            log.error("【卖家取消订单】订单取消失败");
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");  //因为这个不是spring的，所以要加/sell
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
    //订单详情
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String,Object> map) {
        OrderDTO orderDTO =new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("【卖家取消订单】发生异常{}",e.toString());
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");  //因为这个不是spring的，所以要加/sell
            return new ModelAndView("common/error",map);
        }

        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);
    }
}
