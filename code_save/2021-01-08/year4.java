import java.util.Scanner;

public class year4 {
    public static void main(String[] args) {
        System.out.println("���������");
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        if ((year % 4 != 0 || year % 100 == 0) && year % 400 != 0) {
            System.out.println(year+"�겻������");
        } else {
            System.out.println(year+"��������");
        }
    }
}
