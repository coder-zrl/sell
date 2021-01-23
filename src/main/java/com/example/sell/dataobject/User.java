package com.example.sell.dataobject;

import lombok.Data;

/**
 * @author zrl
 * @date 2020-12-23 19:22
 */
@Data
public class User {
    //id
    private String id;
    //name
    private String username;
    //密码
    private String password;
    //用户类型，0表示用户，1表示管理员
    private Integer type;
}
