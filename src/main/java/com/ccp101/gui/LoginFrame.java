package com.ccp101.gui;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;

import javax.swing.*;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/10 12:00
 */
public class LoginFrame {
    public void login(){
        FlatAtomOneLightIJTheme.install();
        JFrame frame = new JFrame("超市管理系统");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        LoginInterface loginInterface = new LoginInterface();
        loginInterface.placeComponents(frame,panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
