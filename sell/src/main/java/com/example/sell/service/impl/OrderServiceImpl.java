package com.example.sell.service.impl;

import com.example.sell.converiter.OrderDTO2OrderMaster;
import com.example.sell.converiter.OrderMaster2OrderDTOConverter;
import com.example.sell.dataobject.OrderDetail;
import com.example.sell.dataobject.OrderMaster;
import com.example.sell.dataobject.ProductInfo;
import com.example.sell.dto.CartDTO;
import com.example.sell.dto.OrderDTO;
import com.example.sell.enums.OrderStatusEnum;
import com.example.sell.enums.PayStatusEnum;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.mapper.OrderDetailMapper;
import com.example.sell.mapper.OrderMasterMapper;
import com.example.sell.service.OrderService;
import com.example.sell.service.ProductService;
import com.example.sell.service.Websocket;
import com.example.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZRL
 * @date 2020/12/7 2:23
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Autowired
    private Websocket websocket;
    @Override
    @Transactional
    public OrderDTO creatOrderDto(OrderDTO orderDto) {
        //orderId
        String orderId = KeyUtil.genUniqueKey();
        //订单总金额
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //1.查询数量、价格
        for(OrderDetail orderDetail :orderDto.getOrderDetailList()){
            ProductInfo productInfo = productService.findone(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算订单总价
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);

            //3.订单详情入库，这两个属性是不会传过来的
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailMapper.save(orderDetail);
        }

        //4.写入orderMaster数据库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);//要写在前面，否则为null
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterMapper.save(orderMaster);

        //4.扣库存  orderDTO是购物车
        List<CartDTO> orderDTOList = orderDto.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(),e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.deceraseStock(orderDTOList);
        orderDto.setOrderId(orderId);
        websocket.sendMessage("有新的订单！orderMasterId="+orderMaster.getOrderId());
        return orderDto;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster = orderMasterMapper.findByOrderId(orderId);
        if (orderMaster==null){
            throw new SellException(ResultEnum.ORDER_NOT_ENOUGH);
        }
        List<OrderDetail> orderDetailList = orderDetailMapper.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> findList(String buyerOpenid) {
        List<OrderMaster> orderMasterList = orderMasterMapper.findByBuyerOpenId(buyerOpenid);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.orderDTOList(orderMasterList);
        return orderDTOList;
    }

    @Override
    @Transactional
    public OrderDTO cancle(OrderDTO orderDTO) {
        //判断订单状态
        if(!(orderDTO.getOrderStatus()==OrderStatusEnum.NEW.getCode())){
            log.error("【取消订单】 订单状态不正确，orderId={}，orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        Integer updateResult = orderMasterMapper.updateOrderStatu(orderDTO.getOrderId(),OrderStatusEnum.CANCEL.getCode());
        //返回库存
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【完结订单】 订单状态不正确，orderDTO={}",orderDTO);
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(
                e -> new CartDTO(e.getProductId(),e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.inceraseStock(cartDTOList);
        //如果已支付，需要退款
        if (orderDTO.getPayStatus()==PayStatusEnum.SUCCESS.getCode()){
            //TODO
        }

        return orderDTO;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDto) {
        //完结订单
        //判断订单状态
        if(!(orderDto.getOrderStatus()==OrderStatusEnum.NEW.getCode())){
            log.error("【完结订单】 订单状态不正确，orderId={}，orderStatus={}",orderDto.getOrderId(),orderDto.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDto.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
        Integer result = orderMasterMapper.updateOrderStatu(orderMaster.getOrderId(),OrderStatusEnum.FINISHED.getCode());
        if (result==null){
            log.error("【完结订单】更新失败，orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDto;
    }

    @Override
    public OrderMaster paid(OrderDTO orderDto) {
        //判断订单状态
        if (!(orderDto.getOrderStatus()==OrderStatusEnum.NEW.getCode())){
            log.error("【订单支付完成】订单状态不对，orderId={}，orderStatus={}",orderDto.getOrderId(),orderDto.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //判断支付状态
        if (!(orderDto.getPayStatus()==PayStatusEnum.WAIT.getCode())){
            log.error("【订单支付完成】订单支付状态不对，orderId={}，payStatus={}",orderDto.getOrderId(),orderDto.getPayStatus());
            throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }
        //修改支付状态
        Integer result = orderMasterMapper.updatePayStatu(orderDto.getOrderId(), PayStatusEnum.SUCCESS.getCode());
        OrderMaster orderMaster = OrderDTO2OrderMaster.convert(orderDto);
        if (result==null) {
            log.error("【订单支付完成】更新失败，orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderMaster;
    }

    @Override
    public List<OrderDTO> findList() {
        List<OrderMaster> orderMasterList = orderMasterMapper.findAll();
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.orderDTOList(orderMasterList);
        return orderDTOList;
    }
}
