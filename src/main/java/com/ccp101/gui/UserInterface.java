package com.ccp101.gui;

import com.ccp101.background.ProjectData;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;

import javax.swing.*;

/** 登陆后创建新的界面
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/9 09:16
 */
public class UserInterface {
    public void UserGUI(int num){
        FlatAtomOneLightIJTheme.install();
        ProjectData data = new ProjectData();
        data.init(num);
        System.out.println(data.getUser().toString());
        JFrame frame = new JFrame("超市管理系统");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        frame.add(panel1);
        JPanel panel2 = new JPanel();
        frame.add(panel2);
        JSplitPane jSplitPane =new JSplitPane();
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
        UserOperating operating = new UserOperating();
        operating.operating(frame,panel1,panel2,data);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
