package LotteryPool;

public class LotteryPool implements Runnable{
    int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
    @Override
    public void run() {
        while(true){
            try {
                double d = Math.random();
                int i = (int)(d*10);
                System.out.println(Thread.currentThread().getName()+"又产生了一个"+arr[i]+"元大奖");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
