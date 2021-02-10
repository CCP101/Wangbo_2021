package com.ccp101.gui;

import com.ccp101.background.ProjectData;
import com.ccp101.pojo.User;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/10 10:13
 */
public class AccountSetting {
    private static final Logger logger = Logger.getLogger(AccountSetting.class);

    public void accountGui(JFrame frame, JPanel panel, ProjectData data){
        panel.removeAll();
        panel.setLayout(null);
//        UserFunction userFunction = new UserFunction();
        JButton passwordButton = new JButton("更改密码");
        passwordButton.setBounds(200, 490, 100, 40);
        panel.add(passwordButton);

        JButton exitButton = new JButton("注销账户");
        exitButton.setBounds(450, 490, 100, 40);
        panel.add(exitButton);
        User temp = data.getUser();

        String message = "<html>\n" + "                " +
                "当前账户信息：<br><br>\n" +
                "用户名称："+temp.getUserName() +"<br>\n" +
                "加密密码："+temp.getPassword() +"<br>\n" +
                "用户手机："+temp.getPhone() +"<br>\n" +
                "用户地址："+temp.getAddress() +"<br>\n" +
                "用户状态："+temp.isStatus() +"<br>\n" + "</html>";
        JLabel messageLabel = new JLabel(message);
        messageLabel.setBounds(200,20,400,250);
        messageLabel.setFont(new Font("微软雅黑", Font.PLAIN,15));
        panel.add(messageLabel);

        exitButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(frame, "确认退出？未保存的内容将丢失！",
                    "提示", JOptionPane.YES_NO_CANCEL_OPTION);
            logger.info("退出确认"+result);
            if (result==0){
                frame.dispose();
                LoginFrame login = new LoginFrame();
                login.login();
            }
        });

        passwordButton.addActionListener(e->{
            ChangePwd changePwd = new ChangePwd();
            changePwd.confirmGui(frame,temp);
        });
        //动态重新绘制panel
        panel.validate();
        panel.repaint();
    }
}
