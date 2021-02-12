package com.ccp101.dao;

import com.ccp101.pojo.Product;
import com.ccp101.pojo.User;
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
public class DaoImpl implements ProductDao, UserDao {

    private static final Logger logger = Logger.getLogger(DaoImpl.class);
    private InputStream in;
    private SqlSession session;

    /**
     * MySQL连接
     */
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

    /**
     * 关闭MySQL连接
     */
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
        initSession();
        ProductDao dao = session.getMapper(ProductDao.class);
        List<Product> list = dao.productImport();
        closeAll();
        return list;
    }

    @Override
    public List<User> UserImport() {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        List<User> list = dao.UserImport();
        closeAll();
        return list;
    }

    /**
     * 用户登录
     *
     * @param user User对象
     * @return 返回下标号
     */
    @Override
    public Integer UserLogin(User user) {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        Integer id = dao.UserLogin(user);
        closeAll();
        return id;
    }

    /**
     * 向t_user表中插入一个新用户
     *
     * @param user 传入User对象加入数据库
     * @throws PersistenceException 向上抛出SQL异常
     */
    @Override
    public void UserInsert(User user) throws PersistenceException {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        dao.UserInsert(user);
        logger.info("注册成功");
        session.commit();
        closeAll();
    }

    /**
     * 获得新插入对象的下标
     *
     * @return 返回新的下标
     */
    @Override
    public Integer UserIndex() {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        Integer id = dao.UserIndex();
        if (id == null) {
            id = 0;
        }
        closeAll();
        return id + 1;
    }

    /**
     * 检查是否存在重复的用户名
     *
     * @param name 待插入的用户名
     * @return true为已经存在该用户名
     */
    @Override
    public String UserDuplicate(String name) {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        String nameGet = dao.UserDuplicate(name);
        if (nameGet != null) {
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * 获取登录用户信息
     *
     * @param index 用户ID
     * @return 返回User类对象
     */
    @Override
    public User UserGet(Integer index) {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        User loginUser = dao.UserGet(index);
        closeAll();
        return loginUser;
    }

    @Override
    public void changePwd(User user) {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        dao.changePwd(user);
        session.commit();
        closeAll();
    }
}
