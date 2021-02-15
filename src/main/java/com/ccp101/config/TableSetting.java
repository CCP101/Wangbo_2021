package com.ccp101.config;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/15 14:52
 */
public class TableSetting {
    public void setting(JTable table,JPanel panel){
        table.getTableHeader().setBounds(50, 50, 500, 20);
        table.setBounds(50, 70, 500, 400);
        table.setSelectionBackground(new Color(99, 175, 229));
        // 设置表格中的数据居中显示
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
        table.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        table.setGridColor(Color.GRAY);
        table.setRowHeight(35);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        panel.add(table.getTableHeader());
        panel.add(table);
        panel.validate();
        panel.repaint();
    }
}
