package Car;

public class test {
    public static void main(String[] args) {
        Thread th1 = new Thread(new Car(true));
        Thread th2 = new Thread(new Car(false));
        Thread th3 = new Thread(new Car(false));
        th1.setName("前门");
        th2.setName("中门");
        th3.setName("后门");
        th1.start();
        th2.start();
        th3.start();
    }
}
