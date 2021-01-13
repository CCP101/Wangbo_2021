package bank;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankManager bankSystem = new BankManager();
        System.out.println("====================================");
        System.out.println("        欢迎使用银行管理系统    ");
        boolean loginFlag = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("请输入"+bankSystem.rootAccount+"的账户密码：");
            String rootPwd = input.next();
            loginFlag = bankSystem.rootLoginCheck(rootPwd);
            if (loginFlag)
                break;
        }
        if(!loginFlag){
            System.out.println("登陆失败！自动退出系统");
            System.exit(1);
        }
        bankSystem.showMenu();
    }
}
