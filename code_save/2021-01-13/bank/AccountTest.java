package bank;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankManager bankSystem = new BankManager();
        System.out.println("====================================");
        System.out.println("        ��ӭʹ�����й���ϵͳ    ");
        boolean loginFlag = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("������"+bankSystem.rootAccount+"���˻����룺");
            String rootPwd = input.next();
            loginFlag = bankSystem.rootLoginCheck(rootPwd);
            if (loginFlag)
                break;
        }
        if(!loginFlag){
            System.out.println("��½ʧ�ܣ��Զ��˳�ϵͳ");
            System.exit(1);
        }
        bankSystem.showMenu();
    }
}
