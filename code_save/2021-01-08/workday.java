import java.util.Scanner;

public class workday {
    public static void main(String[] args) {
        System.out.println("请输入星期几");
        Scanner input = new Scanner(System.in);
        int day = input.nextInt();
        switch (day){
            case 1:
            case 3:
            case 5:
                System.out.println("去学校上课");
                break;
            case 2:
            case 4:
            case 6:
                System.out.println("机房上自习");
                break;
            default:
                System.out.println("休息");
                break;
        }
    }
}
