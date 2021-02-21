package com.ccp101.pojo;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 15:28
 */
public class Item {
    private int id;
    private int productId;
    private int num;
    private double price;
    private int orderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", productId=" + productId + ", num=" + num + ", price=" + price + ", orderId=" + orderId + '}';
    }
}
