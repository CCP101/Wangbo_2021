package PV;

public class test {
    public static void main(String[] args) {
        Object money = new Object();
        Object goods = new Object();
        Buyer buyer = new Buyer(money,goods);
        Seller seller = new Seller(money,goods);
        new Thread(seller).start();
        new Thread(buyer).start();
    }
}
