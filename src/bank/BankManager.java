package bank;

import java.util.Scanner;
import java.util.Vector;

public class BankManager {
    private static final Vector<Account> userData = new Vector<>();
    String rootAccount = "root";
    String rootPwd = "ROOT";

    public boolean rootLoginCheck(String Pwd) {
        if (rootPwd.equals(Pwd)){
            System.out.println(rootAccount+"账户登陆成功");
            return true;
        }
        System.out.println("密码错误");
        return false;
    }

    public void showMenu() {
        System.out.println("====================================");
        System.out.println("0、显示所有账户");
        System.out.println("1、添加账户");
        System.out.println("2、存钱");
        System.out.println("3、取钱");
        System.out.println("4、转账");
        System.out.println("5、修改密码");
        System.out.println("6、销户");
        System.out.println("7、退出系统");
        System.out.println("====================================");
        System.out.print("请选择：");
        Scanner input = new Scanner(System.in);
        int menuChoice = input.nextInt();
        switch (menuChoice){
            case 0:
                showAllAccountInfo();
                break;
            case 1:
                addAccountInfo();
                break;
            case 2:
                saveAccountMoney();
                break;
            case 3:
                getMoney();
                break;
            case 4:
                //        transMoney();
                break;
            case 5:
                //        updatePwd();
                break;
            case 6:
                //        deletePwd();
                break;
            case 7:
                System.out.println("退出成功");
                System.exit(1);
            default:
                System.out.println("输入有误，请重新输入");
                showMenu();
                break;
        }
    }

    private void getMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入取出用户账户名");
        String tempAccountName= input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountName)) {
                System.out.println("查找成功");
                System.out.print("请输入取出金额");
                double subMoney = input.nextDouble();
                if (subMoney<=0){
                    System.out.println("取出金额非法");
                    break;
                }else{
                    System.out.print("请输入账户密码：");
                    String inputPwd = input.next();
                    if (x.getAccountPwd().equals(inputPwd)){
                        if (subMoney<=x.getBalance()){
                            double sum = x.getBalance() - subMoney;
                            // TODO: 2021/1/12 精度处理 
                            x.setBalance(sum);
                            System.out.println("取出"+x.getAccountName()+"账户"+subMoney+"金额成功，卡内余额为"+sum);
                        }else{
                            System.out.println("取出金额非法");
                        }
                    }else{
                        System.out.println("密码错误");
                    }
                }
                findFlag = true;
                break;
            }
        }if (!findFlag){
            System.out.println("查找失败");
        }
        backMenu();
    }

    private void saveAccountMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入存入用户账户名");
        String tempAccountName= input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountName)) {
                System.out.println("查找成功");
                System.out.print("请输入存入金额");
                double saveMoney = input.nextDouble();
                if (saveMoney<=0){
                    System.out.println("存入金额非法");
                    break;
                }else{
                    System.out.print("请输入账户密码：");
                    String inputPwd = input.next();
                    if (x.getAccountPwd().equals(inputPwd)){
                        double sum = x.getBalance() + saveMoney;
                        x.setBalance(sum);
                        System.out.println("存入"+x.getAccountName()+"账户"+saveMoney+"金额成功，卡内余额为"+sum);
                    }else{
                        System.out.println("密码错误");
                    }
                }
                findFlag = true;
                break;
            }
        }if (!findFlag){
            System.out.println("查找失败");
        }
        backMenu();
    }

    private void backMenu() {
        Scanner input = new Scanner(System.in);
        System.out.print("是否返回主菜单(0)");
        if (input.nextInt()==0){
            showMenu();
        }else{
            backMenu();
        }
    }

    private void addAccountInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入新用户账户名");
        String tempAccountName= input.next();
        System.out.print("请输入新用户账户ID");
        String tempAccountId = input.next();
        System.out.print("请输入新用户账户密码");
        String tempAccountPwd= input.next();
        System.out.print("请输入新用户账户余额");
        double tempBalance= input.nextDouble();
        boolean duplicateFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountId)) {
                duplicateFlag = true;
                break;
            }
        }
        if (duplicateFlag){
            System.out.println("用户ID重复！发生错误");
        }else{
            Account tempAccount = new Account();
            tempAccount.setAccountId(tempAccountId);
            tempAccount.setAccountName(tempAccountName);
            tempAccount.setAccountPwd(tempAccountPwd);
            tempAccount.setBalance(tempBalance);
            userData.add(tempAccount);
            System.out.println("添加成功");
        }
        backMenu();
    }

    private void showAllAccountInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("账户名\t账户ID\t账户密码\t账户余额");
        for (Account x:userData) {
            System.out.print(x.getAccountName()+"\t\t"+x.getAccountId()+"\t\t"+x.getAccountPwd()+"\t\t"+x.getBalance());
            System.out.println();
        }
        backMenu();
    }
}
