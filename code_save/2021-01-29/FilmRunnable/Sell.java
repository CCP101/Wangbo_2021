package FilmRunnable;

public class Sell {
    public static void main(String[] args) {
        Thread w1 = new Thread(new FileRunnable());
        Thread w2 = new Thread(new FileRunnable());
        Thread w3 = new Thread(new FileRunnable());
        w1.setName("售票窗口1");
        w2.setName("售票窗口2");
        w3.setName("售票窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}

