package com.ccp101.background;

import com.ccp101.dao.DaoImpl;
import com.ccp101.pojo.Product;
import com.ccp101.pojo.User;

import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 13:55
 */
public class ProjectData {
    private List<Product> productList = null;
    private User user = null;

    public void init(int num){
        DaoImpl dao = new DaoImpl();
        productList = dao.productImport();
        user = dao.UserGet(num);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
