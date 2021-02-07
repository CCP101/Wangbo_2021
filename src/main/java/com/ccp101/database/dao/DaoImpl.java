package com.ccp101.database.dao;

import com.ccp101.database.pojo.Product;
import com.ccp101.database.pojo.User;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 15:57
 */
public class DaoImpl implements ProductDao,UserDao{

    private static Logger logger = Logger.getLogger(DaoImpl.class);
    private InputStream in;
    private SqlSession session;

    private void initSession() {
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            session = factory.openSession();
            logger.info("连接到MySQL数据库");
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

    @Override
    public List<User> UserImport() {
        List<User> list = null;
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        list = dao.UserImport();
        closeAll();
        return list;
    }

    @Override
    public Integer UserLogin(User user) {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        Integer id = dao.UserLogin(user);
        closeAll();
        return id;
    }

    @Override
    public void UserInsert(User user) throws PersistenceException {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        try{
            dao.UserInsert(user);
            logger.info("注册成功");
        }
        catch (PersistenceException e){
            logger.error("存在重复用户名，注册失败");
        }finally {
            session.commit();
            closeAll();
        }
    }
}
