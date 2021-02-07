package com.ccp101.database.dao;

import com.ccp101.database.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 15:57
 */
public class DaoImpl implements ProductDao{

    private InputStream in;
    private SqlSession session;

    private void initSession() {
        try {
            in = Resources.getResourceAsStream("dev/mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            session = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeAll() {
        try {
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> productImport() {
        List<Product> list = null;
        initSession();
        ProductDao dao = session.getMapper(ProductDao.class);
        list = dao.productImport();
        closeAll();
        return list;
    }
}
