package Car;

public class Car implements Runnable{
    static int seat = 40;
    boolean up;

    public Car(boolean up) {
        this.up = up;
    }

    @Override
    public void run() {
        while(true){
            synchronized (this) {
                if (up){
                    if (seat <= 80 && seat >= 0){
                        seat--;
                        System.out.println(Thread.currentThread().getName() + "上车:" + seat);
                    }else{
                        break;
                    }
                }else{
                    if (seat >= 0 && seat <= 80) {
                        seat++;
                        System.out.println(Thread.currentThread().getName() + "下车:" + seat);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
