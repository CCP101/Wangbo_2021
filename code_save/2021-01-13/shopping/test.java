package shopping;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Systemx system = new Systemx();
        Scanner input = new Scanner(System.in);
        System.out.print("��������Ӽ�λ��Ա");
        int number = input.nextInt();
        system.creat(number);
        system.show();
        System.out.print("��������ұ��");
        String tempID = input.next();
        system.find(tempID);
    }
}
