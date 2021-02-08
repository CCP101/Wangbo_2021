package com.ccp101;

import com.ccp101.gui.LoginInterface;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;

import javax.swing.*;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 15:02
 */
public class MainRun {
//    private static Logger logger = Logger.getLogger(DaoImpl.class);
    public static void main(String[] args) {
//        ProjectInit.init();
        FlatAtomOneLightIJTheme.install();
        JFrame frame = new JFrame("超市管理系统");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        LoginInterface loginInterface = new LoginInterface();
        loginInterface.placeComponents(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
