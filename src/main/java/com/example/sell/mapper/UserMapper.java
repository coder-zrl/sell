package com.example.sell.mapper;

import com.example.sell.dataobject.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.util.List;

/**
 * @author zrl
 * @date 2020-12-23 19:21
 */
@Mapper
public interface UserMapper {
    @Select("select * from seller_info")
    public List<User> findAll();
    @Select("select * from seller_info where id=#{id}")
    public User findone(String id);
}
