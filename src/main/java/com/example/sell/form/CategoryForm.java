package com.example.sell.form;

import lombok.Data;

/**
 * @author zrl
 * @date 2020-12-20 21:37
 */
@Data
public class CategoryForm {
    /** 类目ID */
    private Integer categoryId;
    /** 类目名称 */
    private String categoryName;
    /** 类目编号 */
    private Integer categoryType;
}
