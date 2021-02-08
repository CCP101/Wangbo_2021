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
public class ProjectData {
    private List<Product> productList = null;
    private List<User> userList = null;

    public void init(){
        DaoImpl dao = new DaoImpl();
        productList = dao.productImport();
        userList = dao.UserImport();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
