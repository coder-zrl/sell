package com.example.sell.controller;

import com.example.sell.dataobject.ProductCategory;
import com.example.sell.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryMapper mapper;

    //添加
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String insertProductCategory(@RequestBody() ProductCategory productCategory){  //@PathVariable("id") 取出路径变量
        int res = mapper.save(productCategory);
        return "添加商品类目成功";
    }

    //删除
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteProductCategoryById(@RequestParam("id") int id){  //@PathVariable("id") 取出路径变量
        int res = mapper.deleteOnde(id);
        return "删除商品类目成功";
    }

    //修改
    @RequestMapping(value = "/updatename",method = RequestMethod.GET)
    public String updateProductCategoryNameById1(@RequestParam("id") int id,@RequestParam("name") String name){  //@PathVariable("id") 取出路径变量
        int res = mapper.updateProductCategoryNameById(id,name);
        return "修改商品类目名称成功";
    }
    @RequestMapping(value = "/updatetype",method = RequestMethod.GET)
    public String updateProductCategoryTypeById1(@RequestParam("id") int id,@RequestParam("type") String type){  //@PathVariable("id") 取出路径变量
        int res = mapper.updateProductCategoryTypeById(id,type);
        return "修改商品类目类型成功";
    }


    //查询
//    @RequestMapping(value = "/select",method= RequestMethod.GET)
//    public String getProductById(@RequestParam("id") int id){  //@PathVariable("id") 取出路径变量
//        String name = mapper.getProductCategoryNameById(id);
//        return String.valueOf(name);
//    }
}
