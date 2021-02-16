package com.ccp101.dao;

import com.ccp101.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
}
