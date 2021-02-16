package com.ccp101.dao;

import com.ccp101.pojo.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 19:14
 */
public interface ItemDao {
    @Select("SELECT MAX(id) FROM t_item ")
    Integer itemIndex();

    @Insert("INSERT INTO `shopping`.`t_item`(`id`, `product_id`, `num`, `price`, `order_id`) " +
            "VALUES (#{id}, #{productId}, #{num}, #{price}, #{orderId})")
    void itemWrite(Item item);
}
