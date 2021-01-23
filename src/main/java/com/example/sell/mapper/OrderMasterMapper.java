package com.example.sell.mapper;

import com.example.sell.dataobject.OrderMaster;
import com.example.sell.dataobject.ProductCategory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

/**
 * @author ZRL
 * @date 2020/12/5 2:46
 */
@Mapper
public interface OrderMasterMapper {
    //创建订单
    @Insert("insert into order_master (order_id,buyer_name,buyer_phone,buyer_address,buyer_openid,order_amount) values(#{orderId},#{buyerName},#{buyerPhone},#{buyerAddress},#{buyerOpenid},#{orderAmount})")
    public Integer save(OrderMaster orderMaster);

    //修改订单状态
    @Update("update order_master set order_status=#{statu} where order_id=#{orderId};")
    public Integer updateOrderStatu(String orderId,int statu);
    //修改支付状态
    @Update("update order_master set pay_status=#{statu} where order_id=#{orderId};")
    public Integer updatePayStatu(String orderId,int statu);


    //某个人的订单
    @Select("select * from order_master where buyer_openid=#{openId};")
    public List<OrderMaster> findByBuyerOpenId(String openId);
    //查询所有订单
    @Select("select * from order_master;")
    public List<OrderMaster> findAll();
    //根据orderID查询
    @Select("select * from order_master where order_id=#{orderId};")
    public OrderMaster findByOrderId(String orderId);
}
