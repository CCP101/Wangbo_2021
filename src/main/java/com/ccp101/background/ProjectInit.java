package com.ccp101.background;

import com.ccp101.database.dao.DaoImpl;
import com.ccp101.database.pojo.Product;
import com.ccp101.database.pojo.User;

import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 13:55
 */
public class ProjectInit {
    public static void init(){
        DaoImpl dao = new DaoImpl();
        List<Product> productList = dao.productImport();
        List<User> userList = dao.UserImport();
        UserFunction userFunction =new UserFunction();
        userFunction.userLogin("xxx","tttt");
    }
}
