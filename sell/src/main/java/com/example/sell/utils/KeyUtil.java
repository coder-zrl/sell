package com.example.sell.utils;

import java.util.Random;

/**
 * @author ZRL
 * @date 2020/12/7 2:44
 */
public class KeyUtil {
    //生成唯一的主键，毫秒数加随机数
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;//生成六位随机数
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
