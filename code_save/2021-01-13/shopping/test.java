package shopping;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Systemx system = new Systemx();
        Scanner input = new Scanner(System.in);
        System.out.print("请输入添加几位会员");
        int number = input.nextInt();
        system.creat(number);
        system.show();
        System.out.print("请输入查找编号");
        String tempID = input.next();
        system.find(tempID);
    }
}
