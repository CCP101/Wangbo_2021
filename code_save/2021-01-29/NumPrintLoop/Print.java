package NumPrintLoop;

public class Print {
    private static volatile int i=0;
    private static volatile int flag=0;

    public static void main(String[] args) {
        Thread w1 = new Thread(new Num1());
        Thread w2 = new Thread(new Num2());
        Thread w3 = new Thread(new Num3());
        w1.setName("线程1");
        w2.setName("线程2");
        w3.setName("线程3");
        w1.start();
        w2.start();
        w3.start();
    }

    private static class Num1 implements Runnable {
        @Override
        public void run() {
            while(i<=70){
                if(flag==0) {
                    for (int j = 0; j < 5; j++) {
                        i++;
                        System.out.println(Thread.currentThread().getName()+" : "+i);
                    }
                    flag=1;
                    System.out.println();
                }
            }
        }
    }

    private static class Num2 implements Runnable {
        @Override
        public void run() {
            while(i<=70){
                if(flag==1) {
                    for (int j = 0; j < 5; j++) {
                        i++;
                        System.out.println(Thread.currentThread().getName()+" : "+i);
                    }
                    flag=2;
                    System.out.println();
                }
            }

        }
    }

    private static class Num3 implements Runnable {
        @Override
        public void run() {
            while(i<=70){
                if(flag==2) {
                    for (int j = 0; j < 5; j++) {
                        i++;
                        System.out.println(Thread.currentThread().getName()+" : "+i);
                    }
                    flag=0;
                    System.out.println();
                }
            }
        }
    }
}
