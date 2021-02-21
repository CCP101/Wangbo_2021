package com.ccp101.dao;

import com.ccp101.pojo.Item;
import com.ccp101.pojo.Order;
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
public class DaoImpl implements ProductDao, UserDao, OrderDao, ItemDao {

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

    /**
     * 从数据库导入所有商品
     *
     * @return 商品列表
     */
    @Override
    public List<Product> productImport() {
        initSession();
        ProductDao dao = session.getMapper(ProductDao.class);
        List<Product> list = dao.productImport();
        closeAll();
        return list;
    }

    @Override
    public List<User> userImport() {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        List<User> list = dao.userImport();
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
    public Integer userLogin(User user) {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        Integer id = dao.userLogin(user);
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
    public void userInsert(User user) throws PersistenceException {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        dao.userInsert(user);
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
    public Integer userIndex() {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        Integer id = dao.userIndex();
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
    public String userDuplicate(String name) {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        String nameGet = dao.userDuplicate(name);
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
    public User userGet(Integer index) {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        User loginUser = dao.userGet(index);
        closeAll();
        return loginUser;
    }

    /**
     * 更改用户信息
     *
     * @param user 新的User类
     */
    @Override
    public void changePwd(User user) {
        initSession();
        UserDao dao = session.getMapper(UserDao.class);
        dao.changePwd(user);
        session.commit();
        closeAll();
    }

    /**
     * 向数据库写入订单信息
     *
     * @param order Order类
     */
    @Override
    public void orderWrite(Order order) {
        initSession();
        OrderDao dao = session.getMapper(OrderDao.class);
        dao.orderWrite(order);
        session.commit();
        closeAll();
    }

    /**
     * 从数据库获取下一个订单下表
     *
     * @return 获取订单下标
     */
    @Override
    public Integer orderIndex() {
        initSession();
        OrderDao dao = session.getMapper(OrderDao.class);
        Integer id = dao.orderIndex();
        if (id == null) {
            id = 0;
        }
        closeAll();
        return id + 1;
    }

    /** 获取用户订单
     * @param userId 用户ID
     * @return 返回当前用户下的所有订单
     */
    @Override
    public List<Order> getOrder(Integer userId) {
        initSession();
        OrderDao dao = session.getMapper(OrderDao.class);
        List<Order> userOrder = dao.getOrder(userId);
        closeAll();
        return userOrder;
    }

    /**
     * 从数据库获取下一个订单详情下表
     *
     * @return 获取订单详情下标
     */
    @Override
    public Integer itemIndex() {
        initSession();
        ItemDao dao = session.getMapper(ItemDao.class);
        Integer id = dao.itemIndex();
        if (id == null) {
            id = 0;
        }
        closeAll();
        return id + 1;
    }

    /**
     * 向数据库写入订单详情信息
     *
     * @param item Item类
     */
    @Override
    public void itemWrite(Item item) {
        initSession();
        ItemDao dao = session.getMapper(ItemDao.class);
        dao.itemWrite(item);
        session.commit();
        closeAll();
    }

    /** 根据订单编号在数据库内查询并返回包含了商品具体信息的List<Item>
     * @param orderId 订单编号
     * @return 该订单下的详细清单
     */
    @Override
    public List<Item> itemQuery(Integer orderId) {
        initSession();
        ItemDao dao = session.getMapper(ItemDao.class);
        List<Item> itemList = dao.itemQuery(orderId);
        closeAll();
        return itemList;
    }
}
