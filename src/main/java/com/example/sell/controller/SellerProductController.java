package com.example.sell.controller;


import com.example.sell.dataobject.ProductCategory;
import com.example.sell.dataobject.ProductInfo;
import com.example.sell.dto.OrderDTO;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.form.ProductForm;
import com.example.sell.page.OrderDTOPage;
import com.example.sell.page.ProductInfoPage;
import com.example.sell.service.impl.ProductCategoryServiceImpl;
import com.example.sell.service.impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 卖家端商品
 * @author zrl
 * @date 2020-12-20 17:16
 */
@RestController
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {


    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductCategoryServiceImpl productCategoryService;
    //商品列表
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map) {
        List<ProductInfo> productInfoList = productService.findAll();
        ProductInfoPage productInfoPage = new ProductInfoPage(productInfoList,size,page);
        map.put("productInfoPage",productInfoPage);
        map.put("page",page);
        map.put("size",size);
//        System.out.println(productInfoPage);
        return new ModelAndView("product/list",map);
    }

    //商品上架
    @GetMapping("/onsale")
    public ModelAndView onsale(@RequestParam("productId") String productId,
                               Map<String,Object> map) {
        try {
            productService.onSale(productId);
        } catch (Exception e) {
            log.error("【卖家上架商品】发生问题{}",e.toString());
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/list");  //因为这个不是spring的，所以要加/sell
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.SUCCESS.getMessage());
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }
    //商品下架
    @GetMapping("/offsale")
    public ModelAndView offsale(@RequestParam("productId") String productId,
                               Map<String,Object> map) {
        try {
            productService.offSale(productId);
//            System.out.println("下架商品是第"+result+"行");
        } catch (Exception e) {
            log.error("【卖家下架商品】发生问题{}",e.toString());
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/list");  //因为这个不是spring的，所以要加/sell
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.SUCCESS.getMessage());
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }
    //新增和修改商品
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId,
                              Map<String,Object> map){
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findone(productId);
            map.put("productInfo",productInfo);
        }

        //查询所有的类目
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        map.put("categoryList",productCategoryList);

        return new ModelAndView("product/index",map);
    }

    //保存和更新
    @PostMapping("/save")
    public ModelAndView save(@Validated ProductForm productForm,
                             BindingResult bindResult,
                             Map<String,Object> map) {
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productForm,productInfo);
        try {
            productService.save(productInfo);
        }catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/index");  //因为这个不是spring的，所以要加/sell
            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/product/list");  //因为这个不是spring的，所以要加/sell
        return new ModelAndView("common/success",map);
    }
}
