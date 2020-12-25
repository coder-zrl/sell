package com.example.sell.mapper;

import com.example.sell.dataobject.ProductCategory;
import com.example.sell.dataobject.ProductInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductCategoryMapper {
    //增加
    @Insert("insert into product_category (category_name,category_type) values(#{categoryName},#{categoryType})")
    public int save(ProductCategory productCategory);

    //删除
    @Delete("delete from product_category where category_id=#{categoryId}")
    public int deleteOnde(Integer categoryId);

    //修改
    @Update("update product_category set category_name=#{id} where category_id=#{id}")
    public int updateProductCategoryNameById(int id,String name);
    @Update("update product_category set category_type=#{type} where category_id=#{id}")
    public int updateProductCategoryTypeById(int id,String type);
    @Update("update product_category set category_type=#{categoryType},category_name=#{categoryName} where category_id=#{categoryId}")
    public int updateOne(ProductCategory productCategory);


    //查询
    @Select("select * from product_category where category_id=#{id};")
    public ProductCategory getProductCategoryNameById(int id);
    @Select("select category_type from product_category;")
    public List<Integer> getProductType();
    @Select("select * from product_category where category_id=#{categoryId};")
    public ProductCategory findone(Integer categoryId);
    @Select("select * from product_category;")
    public List<ProductCategory> findAll();

}
