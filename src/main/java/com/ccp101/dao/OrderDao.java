package com.ccp101.dao;

import com.ccp101.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 19:14
 */
public interface OrderDao {
    @Insert("INSERT INTO `shopping`.`t_order`(`id`, `user_id`, `no`, `price`, `createdate`) " +
            "VALUES (#{id}, #{user_id}, #{no}, #{price}, #{createDate})")
    void orderWrite(Order order);

    @Select("SELECT MAX(id) FROM t_order ")
    Integer orderIndex();

    @Select("SELECT id,user_id,`no`,price,createdate FROM `t_order` WHERE user_id = #{userId}")
    List<Order> getOrder(Integer userId);
}
