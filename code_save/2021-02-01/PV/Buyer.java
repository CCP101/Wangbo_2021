package PV;

public class Buyer implements Runnable{
    private Object money;
    private Object goods;

    public Buyer(Object money, Object goods) {
        this.money = money;
        this.goods = goods;
    }

    @Override
    public void run() {
        synchronized (goods){
            System.out.println("先给货");
            synchronized (money){
                System.out.println("再给钱");
            }
        }
    }
}
