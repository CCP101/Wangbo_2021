package PV;

public class Seller implements Runnable{
    private final Object money;
    private final Object goods;

    public Seller(Object money, Object goods) {
        this.money = money;
        this.goods = goods;
    }

    @Override
    public void run() {
        synchronized (money){
            System.out.println("先给钱");
            synchronized (goods){
                System.out.println("再给货");
            }
        }
    }
}
