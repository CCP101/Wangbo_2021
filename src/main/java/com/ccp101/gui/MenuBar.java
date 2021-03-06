package com.ccp101.gui;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;

import javax.swing.*;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/9 9:11
 */
public class MenuBar {
    /**
     * 实现工具栏各类子功能
     *
     * @param jf 界面添加工具栏
     */
    public void menu(JFrame jf) {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("文件");
        JMenu editMenu = new JMenu("编辑");
        JMenu viewMenu = new JMenu("视图");
        JMenu aboutMenu = new JMenu("帮助");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(aboutMenu);

        JMenuItem newMenuItem = new JMenuItem("新建");
        JMenuItem openMenuItem = new JMenuItem("打开");
        JMenuItem exitMenuItem = new JMenuItem("退出");
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        JMenuItem copyMenuItem = new JMenuItem("复制");
        JMenuItem pasteMenuItem = new JMenuItem("粘贴");
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        final JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("系统样式选择");
        final JRadioButtonMenuItem radioButtonMenuItem01 = new JRadioButtonMenuItem("Atom One Light");
        final JRadioButtonMenuItem radioButtonMenuItem02 = new JRadioButtonMenuItem("Atom One Dark");
        final JRadioButtonMenuItem radioButtonMenuItem03 = new JRadioButtonMenuItem("Github");
        viewMenu.add(checkBoxMenuItem);
        viewMenu.addSeparator();
        viewMenu.add(radioButtonMenuItem01);
        viewMenu.add(radioButtonMenuItem02);
        viewMenu.add(radioButtonMenuItem03);
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radioButtonMenuItem01);
        btnGroup.add(radioButtonMenuItem02);
        btnGroup.add(radioButtonMenuItem03);
        radioButtonMenuItem01.setSelected(true);

        JMenuItem aboutMenuItem = new JMenuItem("关于");
        aboutMenu.add(aboutMenuItem);

        //状态改变监听器 λ表达式
        radioButtonMenuItem01.addChangeListener(e -> {
            if (radioButtonMenuItem01.isSelected()) {
                FlatAtomOneLightIJTheme.install();
                FlatAtomOneLightIJTheme.updateUI();
            }
        });
        radioButtonMenuItem02.addChangeListener(e -> {
            if (radioButtonMenuItem02.isSelected()) {
                FlatAtomOneDarkIJTheme.install();
                FlatAtomOneDarkIJTheme.updateUI();
            }
        });
        radioButtonMenuItem03.addChangeListener(e -> {
            if (radioButtonMenuItem03.isSelected()) {
                FlatGitHubIJTheme.install();
                FlatGitHubIJTheme.updateUI();
            }
        });
        // 关于我 监听器
        aboutMenuItem.addActionListener(e -> aboutSystem());
        jf.setJMenuBar(menuBar);
        jf.setVisible(true);
    }

    /**
     * 创建一个新页面显示的打印许可证和相关信息
     */
    public void aboutSystem() {
        JFrame frame = new JFrame("关于系统");
        frame.setSize(500, 450);
        JPanel panel = new JPanel();
        frame.add(panel);
        //Apache 2.0 license
        JLabel license = new JLabel("<html>\n" + "                " + "Copyright [2021] [CCP101]<br><br>\n" + "        "
                + "Licensed under the Apache License, Version 2.0 (the \"License\");<br>\n" + "        "
                + "you may not use this file except in compliance with the License.<br>\n" + "        "
                + "You may obtain a copy of the License at<br><br>\n" + "        "
                + "http://www.apache.org/licenses/LICENSE-2.0<br><br>\n" + "                "
                + "Unless required by applicable law or agreed to in writing, software<br>\n" + "        "
                + "distributed under the License is distributed on an \"AS IS\" BASIS,<br>\n" + "        "
                + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>\n" + "        "
                + "See the License for the specific language governing permissions and<br>\n" + "        "
                + "limitations under the License.<br><br>\n" + "        " + "工具列表：<br>\n"
                + "    数据库连接：MyBatis<br>\n" + "    " + "界面设计库：FlatLaf<br>\n" + "    项目管理工具：Maven<br>\n"
                + "    日志管理：log4j<br>\n" + "    " + "代码版本控制工具：Git<br>\n" + "</html>");
        //JLabel支持HTML语言
        license.setBounds(20, 20, 400, 200);
        panel.add(license);
        JButton exit = new JButton("确认");
        exit.addActionListener(e -> frame.dispose());
        panel.add(exit);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
