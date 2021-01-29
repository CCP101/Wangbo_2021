package FilmThread;

public class Sell {
    public static void main(String[] args) {
        FilmThread w1 = new FilmThread();
        FilmThread w2 = new FilmThread();
        FilmThread w3 = new FilmThread();
        w1.setName("售票窗口1");
        w2.setName("售票窗口2");
        w3.setName("售票窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
