package com.ccp101.background;

import com.ccp101.dao.DaoImpl;
import com.ccp101.pojo.Product;
import com.ccp101.pojo.User;

import java.util.HashMap;
import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 13:55
 */
public class ProjectData {
    private List<Product> productList = null;
    private HashMap<Integer,Integer> shoppingCart = null;
    private User user = null;

    public void init(int num) {
        DaoImpl dao = new DaoImpl();
        productList = dao.productImport();
        user = dao.UserGet(num);
        HashMap<Integer,Integer> cart = new HashMap<>();
        for (Product product : productList) {
            cart.put(product.getId(),0);
        }
        setShoppingCart(cart);
    }

    public HashMap<Integer, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<Integer, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
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
