package NumPrint;

public class EvenPrint implements Runnable{
    @Override
    public void run() {
        while(true){
            for (int i = 1; i < 1000; i++) {
                if (i%2==0){
                    System.out.println(Thread.currentThread().getName()+" : "+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
