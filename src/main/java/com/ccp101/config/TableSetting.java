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
    public void setting(JTable table,JPanel panel,boolean FLAG){
        table.setSelectionBackground(new Color(99, 175, 229));
        // 设置表格中的数据居中显示
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        //表头与数据分别设置
        table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
        table.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        table.setGridColor(Color.GRAY);
        table.setRowHeight(35);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        if (FLAG){
            table.setPreferredScrollableViewportSize(new Dimension(600, 350));
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50,50,600,350);
            panel.add(scrollPane);
        }else{
            table.setPreferredScrollableViewportSize(new Dimension(500, 300));
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(90,80,500,300);
            panel.add(scrollPane);
        }
    }
}
