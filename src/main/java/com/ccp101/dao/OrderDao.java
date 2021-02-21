package com.ccp101.dao;

import com.ccp101.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 19:14
 */
public interface OrderDao {
    @Insert("INSERT INTO `shopping`.`t_order`(`id`, `user_id`, `no`, `price`, `createdate`) " +
            "VALUES (#{id}, #{userId}, #{no}, #{price}, #{createDate})")
    void orderWrite(Order order);

    @Select("SELECT MAX(id) FROM t_order ")
    Integer orderIndex();

    //使用映射解决匹配问题
    @Select("SELECT id,user_id,`no`,price,createdate FROM `t_order` WHERE user_id = #{userId}")
    @Results({
            @Result(column="id", property="id", id=true),
            @Result(column="user_id", property="userId"),
            @Result(column="no", property="no"),
            @Result(column="price", property="price"),
            @Result(column="createdate", property="createDate")
    })
    List<Order> getOrder(Integer userId);
}
