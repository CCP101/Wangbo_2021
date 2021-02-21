package com.ccp101.gui;

import com.ccp101.background.ProjectData;
import com.ccp101.config.MyTableModel;
import com.ccp101.config.TableSetting;
import com.ccp101.dao.DaoImpl;
import com.ccp101.pojo.Item;
import com.ccp101.pojo.Order;
import com.ccp101.pojo.Product;
import com.ccp101.pojo.User;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/16 13:33
 */
public class OrderGUI {

    private static final Logger logger = Logger.getLogger(AccountGUI.class);

    /**
     * 订单显示页面
     *
     * @param panel 显示页面
     * @param data  用户数据
     */
    public void orderSetting(JPanel panel, ProjectData data) {
        panel.removeAll();
        panel.setLayout(null);

        User user = data.getUser();
        DaoImpl dao = new DaoImpl();
        TableSetting setting = new TableSetting();
        //数据库查询该用户下的所有订单
        List<Order> order = dao.getOrder(user.getId());
        List<Product> productList = data.getProductList();
        Object[] columnNames = {"序号", "账单编号", "用户", "总额", "创建时间"};
        Object[][] tempObject = new Object[order.size()][5];
        //数据库原格式为date，保留具体时间修改为datetime
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int j = 1;
        for (int i = 0; i < order.size(); i++) {
            Order order1 = order.get(i);
            Date date = order1.getCreateDate();
            tempObject[i][0] = j;
            tempObject[i][1] = order1.getNo();
            tempObject[i][2] = user.getUserName();
            tempObject[i][3] = order1.getPrice();
            tempObject[i][4] = dateFormat.format(date);
            j++;
        }
        MyTableModel model = new MyTableModel();
        model.setRowData(tempObject);
        model.setColumnNames(columnNames);
        JTable table = new JTable(model);
        table.addMouseListener(new MouseAdapter() {
            /**鼠标双击弹出详细信息显示
             * @param e 鼠标双击操作
             */
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        logger.info("选中" + selectedRow);
                        //新建页面进行展示
                        JFrame frame = new JFrame("订单详情");
                        frame.setSize(700, 550);
                        JPanel panel = new JPanel();
                        frame.add(panel);
                        panel.setLayout(null);
                        Order selectOrder = order.get(selectedRow);
                        int orderId = selectOrder.getId();
                        String showId = selectOrder.getNo();
                        //获取选定行账单信息并在数据库进行查询返回所有相关结果
                        List<Item> itemList = dao.itemQuery(orderId);
                        String orderInformation = "用户：" + user.getUserName() + "    订单号：" + showId +
                                "    订单时间：" + dateFormat.format(selectOrder.getCreateDate());
                        Object[] column = {"序号", "商品", "单价", "数量", "总额"};
                        Object[][] Object = new Object[itemList.size()][5];
                        int i = 0;
                        int orderSumNum = 0;
                        double orderSumPrice = 0;
                        //填充表格数据
                        for (Item item : itemList) {
                            int j = i;
                            int product = item.getProductId();
                            Product product1 = productList.get(product - 1);
                            int num = item.getNum();
                            orderSumNum += num;
                            double priceSum = item.getPrice();
                            orderSumPrice += priceSum;
                            Object[i][0] = ++j;
                            Object[i][1] = product1.getName();
                            Object[i][2] = product1.getPrice();
                            Object[i][3] = num;
                            Object[i][4] = priceSum;
                            i++;
                        }
                        MyTableModel model = new MyTableModel();
                        model.setRowData(Object);
                        model.setColumnNames(column);
                        JTable table1 = new JTable(model);
                        setting.setting(table1, panel, false);
                        //票据上方文字
                        JLabel information = new JLabel(orderInformation);
                        information.setFont(new Font("微软雅黑", Font.BOLD, 15));
                        information.setBounds(125, 20, 500, 30);
                        panel.add(information);
                        String orderSum = "共" + orderSumNum + "件，总计:" + orderSumPrice + "元";
                        //票据下方文字
                        JLabel sum = new JLabel(orderSum);
                        sum.setFont(new Font("微软雅黑", Font.BOLD, 15));
                        sum.setBounds(125, 420, 500, 20);
                        panel.add(sum);
                        //按钮用于关闭此页面
                        JButton exit = new JButton("确认");
                        exit.setBounds(310, 450, 80, 30);
                        exit.addActionListener(g -> frame.dispose());
                        panel.add(exit);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                }
            }
        });
        //设置时间列宽度
        TableColumn tableColumn = table.getColumnModel().getColumn(4);
        tableColumn.setResizable(true);
        tableColumn.sizeWidthToFit();
        tableColumn.setPreferredWidth(200);
        tableColumn.setMaxWidth(250);
        tableColumn.setMinWidth(150);
        setting.setting(table, panel, true);
        panel.validate();
        panel.repaint();
    }
}
