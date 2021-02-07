package com.ccp101;

import com.ccp101.database.dao.DaoImpl;
import com.ccp101.database.pojo.Product;

import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 15:02
 */
public class MainRun {
    public static void main(String[] args) {
        DaoImpl dao  = new DaoImpl();
        List<Product> list =  dao.productImport();
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }
}
