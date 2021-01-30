package NumPrint;

public class Print {
    public static void main(String[] args) {
        Thread w1 = new Thread(new EvenPrint());
        Thread w2 = new Thread(new OddPrint());
        w1.setName("偶数");
        w2.setName("奇数");
        w1.start();
        w2.start();
    }
}
