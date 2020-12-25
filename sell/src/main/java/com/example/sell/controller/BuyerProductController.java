package com.example.sell.controller;

import com.example.sell.VO.ProductInfoVO;
import com.example.sell.VO.ProductVO;
import com.example.sell.VO.ResultVO;
import com.example.sell.dataobject.ProductCategory;
import com.example.sell.dataobject.ProductInfo;
import com.example.sell.service.ProductCategoryService;
import com.example.sell.service.ProductService;
import com.example.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ZRL
 * @date 2020/12/3 19:35
 */
@RestController  //可以接收json
@RequestMapping("/buyer/product")  //url前缀
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")  //访问http://localhost:8080/sell/buyer/product/list
    public ResultVO list(){
        //1.查询所有商品
        List<ProductInfo> productInfoList = productService.findAll();
        //2.查询类目
//         // 传统方法
//         List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo:productInfoList) {
//            categoryTypeList.add(productInfo.getCategory_type())
//        }
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        
        //3.数据拼装
        List<ProductVO> productVOList= new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategorytype(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList) {
//                System.out.println(productInfo.toString()+productInfo.getCategoryType()+productCategory.getCategoryType());
                //选取某个类型的
                if(productInfo.getCategoryType()==(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
