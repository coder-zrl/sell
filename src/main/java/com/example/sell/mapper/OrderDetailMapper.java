package com.example.sell.mapper;

import com.example.sell.dataobject.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZRL
 * @date 2020/12/5 2:49
 */
@Mapper
public interface OrderDetailMapper {
    @Insert("insert into order_detail (detail_id,order_id,product_id,product_name,product_price,product_quantity,product_icon) values(#{detailId},#{orderId},#{productId},#{productName},#{productPrice},#{productQuantity},#{productIcon})")
    public Integer save(OrderDetail orderDetail);


    @Select("select * from order_detail where order_id=#{orderId};")
    public List<OrderDetail> findByOrderId(String orderId);
}
