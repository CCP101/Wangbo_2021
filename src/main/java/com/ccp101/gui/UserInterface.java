package com.ccp101.gui;

import com.ccp101.background.ProjectData;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;

import javax.swing.*;

/**
 * 登陆后创建新的界面
 *
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/9 09:16
 */
public class UserInterface {
    /**
     * 登陆后界面设置分栏
     *
     * @param num 用户数据
     */
    public void UserGUI(int num) {
        FlatAtomOneLightIJTheme.install();
        ProjectData data = new ProjectData();
        data.init(num);
        JFrame frame = new JFrame("超市管理系统");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        frame.add(panel1);
        JPanel panel2 = new JPanel();
        frame.add(panel2);
        JSplitPane jSplitPane = new JSplitPane();
        jSplitPane.setEnabled(false);
        jSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        panel1.setSize(150, 700);
        panel2.setSize(850, 700);
        jSplitPane.setLeftComponent(panel1);
        jSplitPane.setRightComponent(panel2);
        jSplitPane.setDividerSize(0);
        jSplitPane.setDividerLocation(150);
        frame.setContentPane(jSplitPane);
        //顶部菜单栏
        MenuBar menu = new MenuBar();
        menu.menu(frame);
        //操作区域
        operating(frame, panel1, panel2, data);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * 设置左侧工具按钮面板
     *
     * @param frame       界面
     * @param panelButton 左侧面板绑定按钮
     * @param panel       右侧面板传参
     * @param data        用户数据
     */
    public void operating(JFrame frame, JPanel panelButton, JPanel panel, ProjectData data) {

        ProductGUI productGUI = new ProductGUI();
        CartGUI cartGUI = new CartGUI();
        OrderGUI orderGUI = new OrderGUI();
        AccountGUI accountGUI = new AccountGUI();

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

        showButton.addActionListener(e -> productGUI.selectProduct(frame, panel, data));
        shoppingButton.addActionListener(e -> cartGUI.cartSetting(frame, panel, data));
        orderButton.addActionListener(e -> orderGUI.orderSetting(panel, data));
        userButton.addActionListener(e -> accountGUI.accountGui(frame, panel, data));
    }
}
