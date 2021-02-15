package com.ccp101.gui;

import com.ccp101.background.ProjectData;
import com.ccp101.config.TableSetting;
import com.ccp101.config.MyTableModel;
import com.ccp101.pojo.Product;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/13 20:54
 */
public class ProductGUI {
    private static final Logger logger = Logger.getLogger(AccountGUI.class);

    /**
     * 用户选择商品加入购物车
     *
     * @param frame 弹窗用
     * @param panel 面板绘制表格
     * @param data  数据传递
     */
    public void selectProduct(JFrame frame, JPanel panel, ProjectData data) {
        panel.removeAll();
        panel.setLayout(null);

        List<Product> productList = data.getProductList();
        HashMap<Integer, Integer> tempCart = data.getShoppingCart();
        Object[][] tempObject = new Object[productList.size()][5];
        Object[] columnNames = {"序号", "名称", "价格", "库存", "状态"};
        for (int i = 0; i < productList.size(); i++) {
            Product temp = productList.get(i);
            tempObject[i][0] = temp.getId();
            tempObject[i][1] = temp.getName();
            tempObject[i][2] = temp.getPrice();
            if (tempCart.get(i + 1) != 0) {
                tempObject[i][4] = "已加入";
            }
        }
        MyTableModel model = new MyTableModel();
        model.setRowData(tempObject);
        model.setColumnNames(columnNames);
        JTable table = new JTable(model);
        table.addMouseListener(new MouseAdapter() {
            /** 双击弹窗确认是否加入购物车
             * @param e 鼠标操作
             */
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = table.getSelectedRow();
                    logger.info("选中" + selectedRow);
                    int result = JOptionPane.showConfirmDialog(frame, "是否加入购物车", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
                    logger.info("选择" + result);
                    if (result == 0) {
                        if (tempCart.get(selectedRow + 1) == 0) {
                            tempCart.remove(selectedRow + 1);
                            tempCart.put(selectedRow + 1, 1);
                            JOptionPane.showMessageDialog(frame, "加入成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                            tempObject[selectedRow][4] = "已加入";
                            model.setRowData(tempObject);
                        } else {
                            JOptionPane.showMessageDialog(frame, "已在购物车中！", "消息提示", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        TableSetting setting = new TableSetting();
        setting.setting(table,panel);
    }
}
