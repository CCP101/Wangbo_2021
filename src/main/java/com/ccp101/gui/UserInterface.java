package com.ccp101.gui;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;

import javax.swing.*;

/** 登陆后创建新的界面
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/9 09:16
 */
public class UserInterface {
    public void UserGUI(){
        FlatAtomOneLightIJTheme.install();
        JFrame frame = new JFrame("超市管理系统");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        MenuBar menu = new MenuBar();
        menu.menu(frame);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
