package com.ccp101.background;

import com.ccp101.dao.DaoImpl;
import com.ccp101.gui.UserInterface;
import com.ccp101.pojo.User;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.util.Objects;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 20:27
 */
public class UserFunction {
    DaoImpl dao = new DaoImpl();
    final String secretKey = "YMY"; //加密密匙
    private static final Logger logger = Logger.getLogger(DaoImpl.class);

    /**用户登录
     * @param name 用户名
     * @param pwd  用户密码
     * @param panel 界面
     */
    public void userLogin(String name, String pwd,JFrame frame, JPanel panel){
        if(checkLegal(name, pwd, panel)) return;
        User test = new User();
        test.setUserName(name);
        String pwdEncrypt = AES.encrypt(name, secretKey);
        test.setPassword(pwdEncrypt);
        //传入临时User对象交给MyBaits
        Integer result = dao.UserLogin(test);
        int num = Objects.requireNonNullElse(result, 0);
        //清空输入框内容
        for (int i = 0; i < panel.getComponentCount(); i++) {
            Object obj = panel.getComponent(i);
            if (obj instanceof JTextField) {
                ((JTextField) obj).setText("");
            }
        }
        //结果为0说明不存在匹配用户即登陆失败
        if (num!=0){
            logger.info("登陆成功");
            JOptionPane.showMessageDialog(panel,"登陆成功");
            frame.dispose();
            UserInterface newGui = new UserInterface();
            newGui.UserGUI();
        }else {
            logger.error("登陆失败");
            JOptionPane.showMessageDialog(panel,"登陆失败！");
        }
    }

    /** 用户注册
     * @param name 输入用户名
     * @param pwd  输入密码
     * @param panel 界面
     */
    public void userRegister(String name, String pwd, JPanel panel){
        //检查是否为空
        if(checkLegal(name, pwd, panel)) return;
        //二次确认密码检查
        JPasswordField pf = new JPasswordField();
        //弹出密码输入框解决方案，https://stackoverflow.com/questions/8881213/
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "确认密码", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (okCxl == JOptionPane.OK_OPTION) {
            String password = new String(pf.getPassword());
            if (!pwd.equals(password)){
                logger.error("密码确认错误");
                JOptionPane.showMessageDialog(panel,"密码确认错误！");
                return;
            }
        }
        //判断是否重复
        if (dao.UserDuplicate(name).equals("true")){
            logger.error("用户名重复");
            JOptionPane.showMessageDialog(panel,"用户名重复！");
            return;
        }
        //添加用户
        User test = new User();
        test.setUserName(name);
        String pwdEncrypt = AES.encrypt(name, secretKey);
        test.setPassword(pwdEncrypt);
        test.setId(dao.UserIndex());
        test.setStatus(true);
        try{
            dao.UserInsert(test);
            logger.info("注册成功");
            JOptionPane.showMessageDialog(panel,"注册成功");
        }catch (PersistenceException e){
            //获取传上来的异常，逻辑错误通过MyBaits查看
            logger.error("存在SQL错误");
        }

        /*导入全部用户数据不通过MySQL判断写法
        List<User> tempList = dao.UserImport();
        for (User user : tempList) {
            if (user.getUserName().equals(name)){
                logger.error("系统已存在同名账户");
                JOptionPane.showMessageDialog(panel,"系统已存在同名账户！");
                return;
            }
        }
        User test = new User();
        test.setUserName(name);
        test.setPassword(pwd);
        test.setId(tempList.get(tempList.size() - 1).getId()+1);
        try{
            dao.UserInsert(test);
            logger.info("注册成功");
            JOptionPane.showMessageDialog(panel,"注册成功");
        }catch (PersistenceException e){
            logger.error("存在SQL错误");
        }*/

        //清空输入框内容
        for (int i = 0; i < panel.getComponentCount(); i++) {
            Object obj = panel.getComponent(i);
            if (obj instanceof JTextField) {
                ((JTextField) obj).setText("");
            }
        }
    }

    /**判断用户输入是否合法
     * @param name   输入用户名
     * @param pwd    输入密码
     * @param panel  界面
     * @return true为存在一个空文本框
     */
    public boolean checkLegal(String name, String pwd, JPanel panel){
        if (name.equals("")||pwd.equals("")){
            logger.error("账户或密码为空");
            JOptionPane.showMessageDialog(panel,"账户或密码为空");
            return true;
        }else{
            return false;
        }
    }
}
