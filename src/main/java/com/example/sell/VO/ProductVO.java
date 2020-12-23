package com.example.sell.VO;

import com.example.sell.dataobject.ProductInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品(包含类目)
 * @author ZRL
 * @date 2020/12/3 19:51
 */
@Data
public class ProductVO {
    @JsonProperty("name")  //这样将数据传到前端，字段就变成了name
    private String categoryName;
    @JsonProperty("type")
    private int categorytype;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
