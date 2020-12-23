package com.example.sell.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.Bean;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商品类目处理
 * 处理product_category这张表，springboot需要类名和表名一致，下划线变成驼峰
 * 如果想类名和表名不一致就加上@Table(name = "xxx表名xxx")
 */


//@Entity  //数据库映射成对象的注解
//@DynamicUpdate
@Data
public class ProductCategory {
    /** 类目ID */
//    @Id  //设置主键
//    @GeneratedValue  //自增类型的
    private Integer categoryId;
    /** 类目名称 */
    private String categoryName;
    /** 类目编号 */
    private Integer categoryType;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
