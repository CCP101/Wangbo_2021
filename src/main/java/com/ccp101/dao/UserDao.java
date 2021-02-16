package com.ccp101.dao;

import com.ccp101.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 18:10
 */
public interface UserDao {
    @Select("SELECT t_user.id,t_user.username,t_user.`password`,t_user.address FROM t_user")
    List<User> userImport();

    @Select("SELECT t_user.id FROM t_user WHERE t_user.username = #{userName} AND t_user.`password` = #{password} " +
            "AND t_user.`status` = 1")
    Integer userLogin(User user);

    @Insert("INSERT INTO `shopping`.`t_user`(`id`, `username`, `password`, `phone`, `address`, `status`) " +
            "VALUES (#{id}, #{userName}, #{password}, #{phone}, #{address}, #{status})")
    void userInsert(User user);

    @Select("SELECT MAX(id) FROM t_user ")
    Integer userIndex();

    @Select("SELECT t_user.username FROM t_user WHERE t_user.username = #{name} LIMIT 1")
    String userDuplicate(String name);

    @Select("SELECT t_user.id,t_user.username,t_user.`password`,t_user.phone,t_user.address,t_user.`status` " +
            "FROM t_user WHERE t_user.id = #{index}")
    User userGet(Integer index);

    @Update("UPDATE t_user SET `password` = #{password} WHERE `id` = #{id}")
    void changePwd(User user);
}
