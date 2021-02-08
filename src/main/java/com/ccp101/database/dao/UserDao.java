package com.ccp101.database.dao;

import com.ccp101.database.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 18:10
 */
public interface UserDao {
    @Select("SELECT t_user.id,t_user.username,t_user.`password`,t_user.address FROM t_user")
    List<User> UserImport();

    @Select("SELECT t_user.id FROM t_user WHERE t_user.username = #{userName} AND t_user.`password` = #{password}")
    Integer UserLogin(User user);

    @Insert("INSERT INTO `shopping`.`t_user`(`id`, `username`, `password`, `phone`, `address`, `status`) " +
            "VALUES (#{id}, #{userName}, #{password}, #{phone}, #{address}, #{status})")
    void UserInsert(User user);

    @Select("SELECT MAX(id) FROM t_user ")
    Integer UserIndex();

    @Select("SELECT t_user.username FROM t_user WHERE t_user.username = #{name} LIMIT 1")
    String UserDuplicate(String name);
}
