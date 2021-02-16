package com.ccp101.config;

import javax.swing.table.AbstractTableModel;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/15 13:58
 */
public class MyTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -1801547741542983971L;
    private Object[] columnNames;
    private Object[][] rowData;

    public void setColumnNames(Object[] columnNames) {
        this.columnNames = columnNames;
    }

    public void setRowData(Object[][] rowData) {
        this.rowData = rowData;
    }

    @Override
    public int getRowCount() {
        return rowData.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column].toString();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rowData[rowIndex][columnIndex];
    }
}
