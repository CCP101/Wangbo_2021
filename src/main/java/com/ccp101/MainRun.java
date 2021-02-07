package com.ccp101;

import com.ccp101.background.UserFunction;
import com.ccp101.database.dao.DaoImpl;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 15:02
 */
public class MainRun {
    private static Logger logger = Logger.getLogger(DaoImpl.class);
    public static void main(String[] args) {
//        ProjectInit.init();
        MainRun run = new MainRun();
    }
    public MainRun(){
        FlatAtomOneLightIJTheme.install();
        JFrame frame = new JFrame("超市管理系统");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) {
        UserFunction userFunction = new UserFunction();
        panel.setLayout(null);
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
        loginButton.addActionListener(e -> userFunction.userLogin(userText.getText(), new String(passwordText.getPassword())));
        JOptionPane.showMessageDialog(panel,"Printing complete");
    }
}
