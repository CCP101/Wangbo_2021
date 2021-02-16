package com.ccp101.pojo;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 15:28
 */
public class Item {
    private int id;
    private int product_id;
    private int num;
    private double price;
    private int order_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", product_id=" + product_id + ", num=" + num + ", price=" + price + ", order_id=" + order_id + '}';
    }
}
