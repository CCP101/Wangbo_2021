import java.util.Scanner;

public class workday {
    public static void main(String[] args) {
        System.out.println("���������ڼ�");
        Scanner input = new Scanner(System.in);
        int day = input.nextInt();
        switch (day){
            case 1:
            case 3:
            case 5:
                System.out.println("ȥѧУ�Ͽ�");
                break;
            case 2:
            case 4:
            case 6:
                System.out.println("��������ϰ");
                break;
            default:
                System.out.println("��Ϣ");
                break;
        }
    }
}
