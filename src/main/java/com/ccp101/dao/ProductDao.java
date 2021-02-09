package com.ccp101.dao;

import com.ccp101.pojo.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 15:39
 */
public interface ProductDao {
    @Select("SELECT t_product.id,t_product.`name`,t_product.price FROM t_product")
    List<Product> productImport();
}
