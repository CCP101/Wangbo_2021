package com.ccp101.gui;

import com.ccp101.background.ProjectData;

import javax.swing.*;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/10 9:47
 */
public class UserOperating {
    public void operating(JFrame frame, JPanel panelButton, JPanel panel, ProjectData data){

        AccountSetting accountSetting = new AccountSetting();
        panelButton.setLayout(null);
        JButton showButton = new JButton("商品选择");
        showButton.setBounds(20, 70, 100, 40);
        panelButton.add(showButton);
        JButton shoppingButton = new JButton("查看购物车");
        shoppingButton.setBounds(20, 210, 100, 40);
        panelButton.add(shoppingButton);
        JButton orderButton = new JButton("查看订单");
        orderButton.setBounds(20, 350, 100, 40);
        panelButton.add(orderButton);
        JButton userButton = new JButton("用户管理");
        userButton.setBounds(20, 490, 100, 40);
        panelButton.add(userButton);

        userButton.addActionListener(e -> accountSetting.accountGui(frame,panel,data));
    }
}
