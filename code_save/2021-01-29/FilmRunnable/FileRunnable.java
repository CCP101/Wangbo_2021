package FilmRunnable;

public class FileRunnable implements Runnable{
    static int ticket = 100;
    @Override
    public void run() {
        while (true) {
            if (ticket > 1) {
                System.out.println(Thread.currentThread().getName()+"正在卖"+ticket--+"张票");
            }else {
                break;
            }
        }
    }
}
