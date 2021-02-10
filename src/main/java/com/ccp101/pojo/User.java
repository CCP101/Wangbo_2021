package com.ccp101.pojo;

/**
 * @author: CCP101
 * @version: v1.0
 * @create: 2021/2/7 15:24
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String phone;
    private String address;
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", password='" + password + '\'' + ", phone='" + phone + '\'' + ", address='" + address + '\'' + ", status=" + status + '}';
    }
}
