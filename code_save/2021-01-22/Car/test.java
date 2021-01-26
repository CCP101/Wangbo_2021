package Car;

import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {
        ManageSystem system = new ManageSystem();
        system.init();
        System.out.println("欢迎使用租车系统！");
        System.out.println("您是否需要租车");
        System.out.println("1.是      0.否");
        Scanner input = new Scanner(System.in);
        int login = input.nextInt();
        if (login == 1){
            system.print();
            system.reservation();
        }else if (login == 0){
            System.out.println("感谢您的使用");
            System.exit(0);
        }else{
            throw new Exception("输入非法");
        }

    }
}
