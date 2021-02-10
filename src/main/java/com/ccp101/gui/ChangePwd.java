package com.ccp101.gui;

import com.ccp101.background.UserFunction;
import com.ccp101.pojo.User;

import javax.swing.*;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/10 13:55
 */
public class ChangePwd {
    public void confirmGui(JFrame frameMain, User user){
        JFrame frame = new JFrame("密码修改");
        frame.setSize(700, 400);
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);
        JLabel passwordLabel = new JLabel("旧密码:");
        passwordLabel.setBounds(230,100,80,25);
        panel.add(passwordLabel);
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(300,100,165,25);
        panel.add(passwordText);

        JLabel passwordLabel1 = new JLabel("新密码:");
        passwordLabel1.setBounds(230,140,80,25);
        panel.add(passwordLabel1);
        JPasswordField passwordText1 = new JPasswordField(20);
        passwordText1.setBounds(300,140,165,25);
        panel.add(passwordText1);

        JLabel passwordLabel2 = new JLabel("新密码确认:");
        passwordLabel2.setBounds(230,180,80,25);
        panel.add(passwordLabel2);
        JPasswordField passwordText2 = new JPasswordField(20);
        passwordText2.setBounds(300,180,165,25);
        panel.add(passwordText2);

        JButton button = new JButton("确认提交");
        button.setBounds(320, 250, 120, 30);
        panel.add(button);

        button.addActionListener(e->{
            UserFunction function = new UserFunction();
            int flag = function.modifyPwd(new String(passwordText.getPassword()),
                    new String(passwordText1.getPassword()),
                    new String(passwordText2.getPassword()),user);
            switch (flag){
                case 1:
                    JOptionPane.showMessageDialog(frame, "原密码错误！", "消息提示",
                            JOptionPane.ERROR_MESSAGE);
                    frame.dispose();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(frame, "新密码不能为空！", "消息提示",
                            JOptionPane.ERROR_MESSAGE);
                    frame.dispose();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(frame, "新密码不一致！", "消息提示",
                            JOptionPane.ERROR_MESSAGE);
                    frame.dispose();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(frame, "修改成功！", "消息提示",
                            JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    frameMain.dispose();
                    LoginFrame login = new LoginFrame();
                    login.login();
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "错误！", "消息提示",
                            JOptionPane.ERROR_MESSAGE);
                    frame.dispose();
                    break;
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
