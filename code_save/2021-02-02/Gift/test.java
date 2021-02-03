package Gift;

public class test {
    public static void main(String[] args) {
        Thread th1 = new Thread(new Gift());
        Thread th2 = new Thread(new Gift());
        th1.setName("通道1");
        th2.setName("通道2");
        th1.start();
        th2.start();
    }
}
