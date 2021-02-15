package com.ccp101.gui;

import com.ccp101.background.ProjectData;
import com.ccp101.background.UserFunction;
import com.ccp101.pojo.User;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/10 10:13
 */
public class AccountGUI {
    private static final Logger logger = Logger.getLogger(AccountGUI.class);

    /**
     * 主窗口设置用户管理模块
     *
     * @param frame 界面
     * @param panel 模块面板
     * @param data  用户数据
     */
    public void accountGui(JFrame frame, JPanel panel, ProjectData data) {
        panel.removeAll();
        panel.setLayout(null);
        JButton passwordButton = new JButton("更改密码");
        passwordButton.setBounds(200, 490, 100, 40);
        panel.add(passwordButton);

        JButton exitButton = new JButton("注销账户");
        exitButton.setBounds(450, 490, 100, 40);
        panel.add(exitButton);
        User temp = data.getUser();

        String message = "<html>\n" + "                " + "当前账户信息：<br><br>\n" + "用户名称：" + temp.getUserName()
                + "<br>\n" + "加密密码：" + temp.getPassword() + "<br>\n" + "用户手机：" + temp.getPhone()
                + "<br>\n" + "用户地址：" + temp.getAddress() + "<br>\n" + "用户状态：" + temp.isStatus()
                + "<br>\n" + "</html>";
        JLabel messageLabel = new JLabel(message);
        messageLabel.setBounds(200, 20, 400, 250);
        messageLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        panel.add(messageLabel);

        exitButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(frame, "确认退出？未保存的内容将丢失！",
                    "提示", JOptionPane.YES_NO_CANCEL_OPTION);
            logger.info("退出确认" + result);
            if (result == 0) {
                frame.dispose();
                LoginFrame login = new LoginFrame();
                login.login();
            }
        });

        passwordButton.addActionListener(e -> confirmGui(frame, temp));
        //动态重新绘制panel
        panel.validate();
        panel.repaint();
    }

    /**
     * 修改密码GUI
     *
     * @param frameMain 窗口
     * @param user      当前用户对象
     */
    public void confirmGui(JFrame frameMain, User user) {
        JFrame frame = new JFrame("密码修改");
        frame.setSize(700, 400);
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);
        JLabel passwordLabel = new JLabel("旧密码:");
        passwordLabel.setBounds(230, 100, 80, 25);
        panel.add(passwordLabel);
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(300, 100, 165, 25);
        panel.add(passwordText);

        JLabel passwordLabel1 = new JLabel("新密码:");
        passwordLabel1.setBounds(230, 140, 80, 25);
        panel.add(passwordLabel1);
        JPasswordField passwordText1 = new JPasswordField(20);
        passwordText1.setBounds(300, 140, 165, 25);
        panel.add(passwordText1);

        JLabel passwordLabel2 = new JLabel("新密码确认:");
        passwordLabel2.setBounds(230, 180, 80, 25);
        panel.add(passwordLabel2);
        JPasswordField passwordText2 = new JPasswordField(20);
        passwordText2.setBounds(300, 180, 165, 25);
        panel.add(passwordText2);

        JButton button = new JButton("确认提交");
        button.setBounds(320, 250, 120, 30);
        panel.add(button);

        button.addActionListener(e -> {
            UserFunction function = new UserFunction();
            int flag = function.modifyPwd(new String(passwordText.getPassword()), new String(passwordText1.getPassword()),
                    new String(passwordText2.getPassword()), user);
            switch (flag) {
                case 1:
                    JOptionPane.showMessageDialog(frame, "原密码错误！", "消息提示", JOptionPane.ERROR_MESSAGE);
                    frame.dispose();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(frame, "新密码不能为空！", "消息提示", JOptionPane.ERROR_MESSAGE);
                    frame.dispose();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(frame, "新密码不一致！", "消息提示", JOptionPane.ERROR_MESSAGE);
                    frame.dispose();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(frame, "修改成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    frameMain.dispose();
                    LoginFrame login = new LoginFrame();
                    login.login();
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "错误！", "消息提示", JOptionPane.ERROR_MESSAGE);
                    frame.dispose();
                    break;
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
