import java.math.BigDecimal;

public class studentAvg {
    static class student{
        double math;
        double english;
        double computer;

        public void show() {
            double avg = math+english+computer/3.0;
            System.out.println("平均分为"+avg);
        }
    }
    public static void main(String[] args) {
        student stu = new student();
        stu.math = 75.0;
        stu.computer = 80.0;
        stu.english = 97.0;
        stu.show();
    }
}
