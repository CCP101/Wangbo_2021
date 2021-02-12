package com.ccp101.gui;

import com.ccp101.background.UserFunction;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/10 12:00
 */
public class LoginFrame {
    /**
     * 初始化登陆后界面
     */
    public void login() {
        FlatAtomOneLightIJTheme.install();
        JFrame frame = new JFrame("超市管理系统");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(frame, panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * 主程序入口，实现用户的登录/注册操作
     *
     * @param frame 传递主界面用于登陆跳转
     * @param panel 主程序登录/注册界面
     */
    public void placeComponents(JFrame frame, JPanel panel) {
        UserFunction userFunction = new UserFunction();

        panel.setLayout(null);
        JLabel userLabel = new JLabel("账户:");
        userLabel.setBounds(250, 100, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(300, 100, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(250, 140, 80, 25);
        panel.add(passwordLabel);
        //密码输入文本框
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(300, 140, 165, 25);
        panel.add(passwordText);
        //登录按钮绑定登录事件
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(275, 200, 80, 25);
        panel.add(loginButton);
        loginButton.addActionListener(e -> userFunction.userLogin(userText.getText(),
                new String(passwordText.getPassword()), frame, panel));
        //注册按钮绑定注册事件
        JButton registerButton = new JButton("注册");
        registerButton.setBounds(375, 200, 80, 25);
        panel.add(registerButton);
        registerButton.addActionListener(e -> userFunction.userRegister(userText.getText(),
                new String(passwordText.getPassword()), panel));
        //密码输入框监听回车
        passwordText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }
        });
    }
}
