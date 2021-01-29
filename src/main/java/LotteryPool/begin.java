package LotteryPool;

public class begin {
    public static void main(String[] args) {
        Thread w1 = new Thread(new LotteryPool());
        Thread w2 = new Thread(new LotteryPool());
        w1.setName("抽奖箱1");
        w2.setName("抽奖箱2");
        w1.start();
        w2.start();
    }
}
