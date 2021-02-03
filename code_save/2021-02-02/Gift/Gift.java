package Gift;

public class Gift implements Runnable{
    static int gifts = 100;
    @Override
    public void run() {
        while(true) {
            synchronized (this) {
                if (gifts >= 10) {
                    System.out.println(Thread.currentThread().getName() + ":" + gifts--);
                } else {
                    break;
                }
            }
        }
    }
}
