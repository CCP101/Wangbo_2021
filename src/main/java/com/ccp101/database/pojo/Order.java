package com.ccp101.database.pojo;

import java.util.Date;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 15:26
 */
public class Order {
    private int id;
    private int userId;
    private String no;
    private double price;
    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", userId=" + userId + ", no='" + no + '\'' + ", price=" + price + ", createDate=" + createDate + '}';
    }
}
