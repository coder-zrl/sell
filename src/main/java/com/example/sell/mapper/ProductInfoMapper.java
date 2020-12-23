package com.example.sell.mapper;

import com.example.sell.dataobject.ProductCategory;
import com.example.sell.dataobject.ProductInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author ZRL
 * @date 2020/12/3 11:20
 */
@Mapper
public interface ProductInfoMapper {
    //添加商品
    @Insert("insert into product_info (product_id,product_name,product_price,product_stock,product_description,product_icon,product_status,category_type) values(#{productId},#{productName},#{productPrice},#{productStock},#{productDescription},#{productIcon},#{productStatus},#{categoryType})")
    public Integer save(ProductInfo ProductInfo);

    //查询上架的商品
    @Select("select * from product_info where product_status=#{productStatus};")
    public List<ProductInfo> getProductByStatus(int productStatus);
    @Select("select * from product_info where product_id=#{id};")
    public ProductInfo getProductById(String id);
    @Select("select * from product_info;")
    public List<ProductInfo> getAllProduct();

    //增减库存呢
    @Update("update product_info set product_stock=#{productStock} where product_id=#{productId}")
    public int setProductStock(String productId,int productStock);

    //删除商品
    @Delete("delete from product_info where product_id=#{productId}")
    public int deleteOne(String productId);

    //商品上架
    @Update("update product_info set product_status=0 where product_id=#{productId}")
    public Integer onSale(String productId);
    //商品下架
    @Update("update product_info set product_status=1 where product_id=#{productId}")
    public Integer offSale(String productId);
}
