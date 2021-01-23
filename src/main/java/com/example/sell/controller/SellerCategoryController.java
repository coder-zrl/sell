package com.example.sell.controller;

import com.example.sell.dataobject.ProductCategory;
import com.example.sell.form.CategoryForm;
import com.example.sell.service.impl.ProductCategoryServiceImpl;
import com.example.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author zrl
 * @date 2020-12-20 21:05
 */
@RestController
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    ProductCategoryServiceImpl productCategoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map) {
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        map.put("categoryList",productCategoryList);
        return new ModelAndView("category/list",map);
    }

    //修改和新增
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              Map<String,Object> map) {
        if (categoryId!=null) {
            ProductCategory category = productCategoryService.findOne(categoryId);
            map.put("category",category);
        }
        return new ModelAndView("category/index",map);
    }
    @PostMapping("/save")
    public ModelAndView save(@Validated CategoryForm categoryForm,
                             BindingResult bindResult,
                             Map<String,Object> map) {
        if (categoryForm.getCategoryId()!=null) {
            ProductCategory category = productCategoryService.findOne(categoryForm.getCategoryId());
            BeanUtils.copyProperties(categoryForm,category);
            productCategoryService.update(category);
        }
        map.put("url","/sell/seller/product/index");
        return new ModelAndView("common/success",map);
    }

}
