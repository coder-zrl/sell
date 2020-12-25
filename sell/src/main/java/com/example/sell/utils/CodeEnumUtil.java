package com.example.sell.utils;

import com.example.sell.enums.CodeEnum;

/**
 * @author zrl
 * @date 2020-12-18 16:43
 */
public class CodeEnumUtil {

    public static <T extends CodeEnum> String getByCode(Integer code, Class<T> enumClass) {
        for (T each:enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
//                System.out.println(each);
                return each.getMsg();
            }
        }
        return null;
    }
}
