package com.ccp101.gui;

import com.ccp101.background.ProjectData;
import com.ccp101.config.TableSetting;
import com.ccp101.pojo.Product;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/15 12:14
 */
public class CartGUI {
    private static final Logger logger = Logger.getLogger(AccountGUI.class);

    public void cartSetting(JFrame frame, JPanel panel, ProjectData data) {
        panel.removeAll();
        panel.setLayout(null);

        List<Product> productList = data.getProductList();
        HashMap<Integer, Integer> cart = data.getShoppingCart();
        HashMap<Integer, Integer> tempCart = new HashMap<>();
        for (Integer integer : cart.keySet()) {
            if (cart.get(integer) != 0) {
                tempCart.put(integer, cart.get(integer));
            }
        }
        Object[][] rowData = generateData(tempCart, productList);
        Object[] columnNames = {"序号", "名称", "商品编号", "单价", "数量", "总额"};
        JTable table = new JTable(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return rowData.length;
            }

            @Override
            public int getColumnCount() {
                return rowData[0].length;
            }

            @Override
            public String getColumnName(int column) {
                return columnNames[column].toString();
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 4;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rowData[rowIndex][columnIndex];
            }

            /** 设置新值，有double类型及int类型，无法使用异常判断，使用正则校验
             * @param newValue 新值
             * @param rowIndex 表格行坐标
             * @param columnIndex 表格列坐标
             */
            @Override
            public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
                {
                    //todo 197548E7超大数
                    if (newValue == null || !newValue.toString().matches("^([1-9][0-9]*)+(.[0-9]{1,2})?$")) {
                        JOptionPane.showMessageDialog(null, "只能输入数字!");
                        return;
                    }
                }
                rowData[rowIndex][columnIndex] = newValue;
                fireTableCellUpdated(rowIndex, columnIndex);
            }
        });
        final TableModel tableModel = table.getModel();
        tableModel.addTableModelListener(e -> {
            int firstRow = e.getFirstRow();
            int lastRow = e.getLastRow();
            int column = e.getColumn();
            // 事件的类型，可能的值有:
            //     TableModelEvent.INSERT   新行或新列的添加
            //     TableModelEvent.UPDATE   现有数据的更改
            //     TableModelEvent.DELETE   有行或列被移除
            if (e.getType() == TableModelEvent.UPDATE) {
                if (column != 4) {
                    return;
                }
                for (int row = firstRow; row <= lastRow; row++) {
                    if (row != rowData.length - 1) {
                        int id = Integer.parseInt(tableModel.getValueAt(row, 2).toString());
                        double price = Double.parseDouble(tableModel.getValueAt(row, 3).toString());
                        int num = Integer.parseInt(tableModel.getValueAt(row, 4).toString());
                        tempCart.remove(id);
                        tempCart.put(id, num);
                        cart.remove(id);
                        cart.put(id,num);
                        double total = price * num;
                        tableModel.setValueAt(total, row, 5);
                        int numSum = 0;
                        double totalSum = 0;
                        for (Integer integer : tempCart.keySet()) {
                            Product product = productList.get(integer - 1);
                            int numProduct = tempCart.get(integer);
                            numSum += numProduct;
                            totalSum += product.getPrice() * numProduct;
                        }
                        tableModel.setValueAt(numSum, rowData.length - 1, 4);
                        tableModel.setValueAt(totalSum, rowData.length - 1, 5);
                    }
                }
            }
        });
        TableSetting setting = new TableSetting();
        table.addMouseListener(new MouseAdapter() {
            /** 双击弹窗确认是否从购物车中删除
             * @param e 鼠标操作
             */
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
//                    int selectedRow = table.getSelectedRow();
//                    logger.info("选中" + selectedRow);
//                    int result = JOptionPane.showConfirmDialog(frame, "是否加入购物车", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
//                    logger.info("选择" + result);
//                    if (result == 0) {
//                        if (tempCart.get(selectedRow + 1) == 0) {
//                            JOptionPane.showMessageDialog(frame, "加入成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
//                        } else {
//                            JOptionPane.showMessageDialog(frame, "已在购物车中！", "消息提示", JOptionPane.ERROR_MESSAGE);
//                        }
//                    }
                }
            }
        });
        setting.setting(table, panel);
    }

    public Object[][] generateData(HashMap<Integer, Integer> tempCart, List<Product> productList) {
        Object[][] tempObject = new Object[tempCart.size() + 1][6];
        int i = 0;
        int numSum = 0;
        double priceSum = 0;
        for (Integer integer : tempCart.keySet()) {
            int j = i;
            Product product = productList.get(integer - 1);
            double perPrice = product.getPrice();
            int num = tempCart.get(integer);
            numSum += num;
            double price = perPrice * num;
            priceSum += price;
            tempObject[i][0] = ++j;
            tempObject[i][1] = product.getName();
            tempObject[i][2] = product.getId();
            tempObject[i][3] = perPrice;
            tempObject[i][4] = num;
            tempObject[i][5] = price;
            i++;
        }
        tempObject[tempCart.size()][0] = "合计";
        tempObject[tempCart.size()][4] = numSum;
        tempObject[tempCart.size()][5] = priceSum;
        return tempObject;
    }
}
