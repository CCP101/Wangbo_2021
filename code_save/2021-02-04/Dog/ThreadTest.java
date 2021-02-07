package Dog;

public class ThreadTest {
    public static void main(String[] args) {
        new Thread("线程1"){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+"->"+i);
                }
            }
        }.start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+"->"+i);
            }
        },"线程2").start();
    }
}
