package com.ccp101.background;

import com.ccp101.database.dao.DaoImpl;
import com.ccp101.database.pojo.User;
import org.apache.log4j.Logger;

import java.util.Objects;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 20:27
 */
public class UserFunction {
    DaoImpl dao = new DaoImpl();
    private static Logger logger = Logger.getLogger(DaoImpl.class);

    public void userLogin(String name, String pwd){
        User test = new User();
        test.setUserName(name);
        test.setPassword(pwd);
        Integer result = dao.UserLogin(test);
        int num = Objects.requireNonNullElse(result, 0);
        if (num!=0){
            logger.info("登陆成功");
        }else{
            logger.error("登陆失败");
        }

    }
}
