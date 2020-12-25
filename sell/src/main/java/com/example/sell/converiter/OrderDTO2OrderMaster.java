package com.example.sell.converiter;

import com.example.sell.dataobject.OrderMaster;
import com.example.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 转换器
 * @author ZRL
 * @date 2020/12/8 2:43
 */
public class OrderDTO2OrderMaster {
    public static OrderMaster convert(OrderDTO orderDTO){
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        return orderMaster;
    }
}
