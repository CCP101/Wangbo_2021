package com.ccp101.gui;

import javax.swing.*;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/9 9:27
 */
public class AboutSystem {
    /** 创建一个新页面显示的打印许可证和相关信息
     * @param frame 点击按钮关闭该页面
     * @param panel GUI面板
     */
    public void aboutMe(JFrame frame,JPanel panel){
        //Apache 2.0 license
        JLabel license = new JLabel("<html>\n" + "                " +
                "Copyright [2021] [CCP101]<br><br>\n" + "        " +
                "Licensed under the Apache License, Version 2.0 (the \"License\");<br>\n" + "        " +
                "you may not use this file except in compliance with the License.<br>\n" + "        " +
                "You may obtain a copy of the License at<br><br>\n" + "        " +
                "http://www.apache.org/licenses/LICENSE-2.0<br><br>\n" + "                " +
                "Unless required by applicable law or agreed to in writing, software<br>\n" + "        " +
                "distributed under the License is distributed on an \"AS IS\" BASIS,<br>\n" + "        " +
                "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>\n" + "        " +
                "See the License for the specific language governing permissions and<br>\n" + "        " +
                "limitations under the License.<br><br>\n" + "        "+
                "工具列表：<br>\n" + "    SQL：MyBatis<br>\n" + "    " +
                "GUI：FlatLaf<br>\n" + "    POM：Maven<br>\n" + "    LOG：log4j<br>\n" + "</html>");
        //JLabel支持HTML语言
        license.setBounds(20,20,400,200);
        panel.add(license);
        JButton exit = new JButton("确认");
        exit.addActionListener(e-> frame.dispose());
        panel.add(exit);
    }
}

