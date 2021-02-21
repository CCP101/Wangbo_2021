package com.ccp101.gui;

import com.ccp101.background.ProjectData;
import com.ccp101.config.TableSetting;
import com.ccp101.dao.DaoImpl;
import com.ccp101.pojo.Item;
import com.ccp101.pojo.Order;
import com.ccp101.pojo.Product;
import com.ccp101.pojo.User;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        DaoImpl dao = new DaoImpl();
        TableSetting setting = new TableSetting();
        List<Product> productList = data.getProductList();
        HashMap<Integer, Integer> cart = data.getShoppingCart();
        User user = data.getUser();
        //临时HashMap，只包含加入购物车的商品进行深拷贝
        HashMap<Integer, Integer> tempCart = new HashMap<>();
        for (Integer integer : cart.keySet()) {
            if (cart.get(integer) != 0) {
                tempCart.put(integer, cart.get(integer));
            }
        }
        Object[][] rowData = generateData(tempCart, productList);
        Object[] columnNames = {"序号", "名称", "商品编号", "单价", "数量", "总额"};
        JTable table = new JTable(new AbstractTableModel() {

            private static final long serialVersionUID = 659637128155921285L;

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
                    //TODO 197548E7超大数校验
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
            if (e.getType() == TableModelEvent.UPDATE) {
                //设置可编辑区域
                if (column != 4 || firstRow == rowData.length - 1) {
                    return;
                }
                //自动更新数据
                for (int row = firstRow; row <= lastRow; row++) {
                    if (row != rowData.length - 1) {
                        //Object -> String -> double/int
                        int id = Integer.parseInt(tableModel.getValueAt(row, 2).toString());
                        double price = Double.parseDouble(tableModel.getValueAt(row, 3).toString());
                        int num = Integer.parseInt(tableModel.getValueAt(row, 4).toString());
                        tempCart.put(id, num);
                        cart.put(id, num);
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

        table.addMouseListener(new MouseAdapter() {
            /** 双击弹窗确认是否从购物车中删除
             * @param e 鼠标操作
             */
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = table.getSelectedRow();
                    //合计行禁止编辑
                    if (selectedRow == rowData.length - 1) {
                        return;
                    }
                    int result = JOptionPane.showConfirmDialog(frame, "是否从购物车中移除", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (result == 0) {
                        int j = 0;
                        Integer remove = 0;
                        for (Integer integer : tempCart.keySet()) {
                            if (j == selectedRow) {
                                remove = integer;
                            }
                            j++;
                        }
                        tempCart.remove(remove);
                        cart.put(remove, 0);
                        logger.info("删除" + remove);
                        JOptionPane.showMessageDialog(frame, "删除成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                        cartSetting(frame, panel, data);
                    }
                }
            }
        });

        JButton clearButton = new JButton("清空购物车");
        clearButton.setBounds(200, 490, 100, 40);
        panel.add(clearButton);

        JButton submitButton = new JButton("购物车结算");
        submitButton.setBounds(450, 490, 100, 40);
        panel.add(submitButton);

        clearButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(frame, "是否清空购物车", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == 0) {
                //购物车清空
                for (Integer integer : cart.keySet()) {
                    if (cart.get(integer) != 0) {
                        cart.put(integer, 0);
                    }
                }
                JOptionPane.showMessageDialog(frame, "清空成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                cartSetting(frame, panel, data);
            }
        });

        submitButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(frame, "是否结算购物车", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == 0) {
                Order order = new Order();
                //订单数据预处理格式化
                int id = dao.orderIndex();
                String orderId = String.valueOf(id + 10000);
                double price = Double.parseDouble(tableModel.getValueAt(rowData.length - 1, 5).toString());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                String dateString = dateFormat.format(date);
                //订单类数据设置并写入数据库
                order.setId(id);
                order.setUserId(user.getId());
                order.setNo(orderId);
                order.setPrice(price);
                try {
                    order.setCreateDate(dateFormat.parse(dateString));
                    logger.info(dateFormat.parse(dateString));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                dao.orderWrite(order);
                //订单详细获取并分条写入数据库
                for (Integer integer : tempCart.keySet()) {
                    Product product = productList.get(integer - 1);
                    Integer num = tempCart.get(integer);
                    int idItem = dao.itemIndex();
                    double priceSum = product.getPrice() * num;
                    Item item = new Item();
                    item.setId(idItem);
                    item.setProductId(integer);
                    item.setNum(num);
                    item.setPrice(priceSum);
                    item.setOrderId(id);
                    dao.itemWrite(item);
                }
                //购物车清空
                for (Integer integer : cart.keySet()) {
                    if (cart.get(integer) != 0) {
                        cart.put(integer, 0);
                    }
                }
                JOptionPane.showMessageDialog(frame, "结算成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                cartSetting(frame, panel, data);
            }
        });
        setting.setting(table, panel, true);
        panel.validate();
        panel.repaint();
    }

    /**
     * 根据输入值填充表格数据
     *
     * @param tempCart    购物车
     * @param productList 产品清单
     * @return 表格数据
     */
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
