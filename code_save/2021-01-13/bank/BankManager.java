package bank;

import java.math.BigDecimal;
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
        System.out.println("0、显示所有账户 1、添加账户 2、存钱 3、取钱 4、转账 5、修改密码 6、销户 7、退出系统");
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
                transMoney();
                break;
            case 5:
                updatePwd();
                break;
            case 6:
                deletePwd();
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

    private void transMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入转出用户ID");
        String TransferID1 = input.next();
        System.out.print("请输入转入用户ID");
        String TransferID2 = input.next();
        boolean findFlag1 = false;
        boolean findFlag2 = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(TransferID1)) {
                for (Account y:userData) {
                    if (y.getAccountId().equals(TransferID2)) {
                        //两层判断
                        System.out.print("请输入转出金额");
                        String tempString = input.next();
                        BigDecimal subMoney= new BigDecimal(tempString);
                        int judge = subMoney.compareTo(BigDecimal.ZERO);
                        if (judge <= 0){
                            System.out.println("转出金额非法");
                            break;
                        }else{
                            judge = subMoney.compareTo(x.getBalance());
                            if (judge <= 0){
                                System.out.print("请输入转出账户密码");
                                String tempPwd = input.next();
                                if (x.getAccountPwd().equals(tempPwd)){
                                    System.out.println("登入成功");
                                    BigDecimal sum = x.getBalance().subtract(subMoney);
                                    x.setBalance(sum);
                                    BigDecimal sum2 = y.getBalance().add(subMoney);
                                    y.setBalance(sum2);
                                    System.out.printf("转出%s账户到%s账户%s金额成功，", x.getAccountName(), y.getAccountId(), subMoney);
                                    System.out.printf("转出账户卡内余额为%s，转入账户卡内余额为%s%n", sum, sum2);
                                }else{
                                    System.out.println("转出账户密码错误");
                                }
                            }else{
                                System.out.println("取出金额不足,卡内剩余金额为"+x.getBalance());
                            }
                        }
                        findFlag2 = true;
                        break;
                    }
                }
                findFlag1 = true;
                break;
            }
        }
        if (!findFlag1){
            System.out.println("转出账户查找失败");
        }
        if (!findFlag2){
            System.out.println("转入账户查找失败");
        }
        backMenu();
    }

    private void updatePwd() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户ID");
        String tempAccountID = input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountID)) {
                System.out.println("查找成功");
                System.out.print("请输入密码确认");
                String tempAccountPwd = input.next();
                if (x.getAccountPwd().equals(tempAccountPwd)){
                    System.out.println("登陆成功");
                    String newPwd1;
                    String newPwd2;
                    boolean repeatFlag = false;
                    do{
                        if (repeatFlag)
                            System.out.println("校验密码出错！请重新输入");
                        System.out.print("请输入新密码");
                        newPwd1 = input.next();
                        System.out.print("请确认新密码");
                        newPwd2 = input.next();
                        repeatFlag = !newPwd1.equals(newPwd2);
                    }while (repeatFlag);
                    x.setAccountPwd(newPwd1);
                    System.out.println("修改"+tempAccountID+"账户密码成功");
                }else{
                    System.out.println("密码错误！");
                }
                findFlag = true;
                break;
            }
        }
        if (!findFlag){
            System.out.println("查找失败");
        }
        backMenu();
    }

    private void deletePwd() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入删除用户ID");
        String tempAccountID = input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountID)) {
                System.out.println("查找成功");
                System.out.print("请输入密码确认");
                String tempAccountPwd = input.next();
                if (x.getAccountPwd().equals(tempAccountPwd)){
                    userData.remove(x);
                    System.out.println("删除"+tempAccountID+"账户成功");
                }else{
                    System.out.println("密码错误！");
                }
                findFlag = true;
                break;
            }
        }
        if (!findFlag){
            System.out.println("查找失败");
        }
        backMenu();
    }

    private void getMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入取出用户ID");
        String tempAccountID= input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountID)) {
                System.out.println("查找成功");
                System.out.print("请输入取出金额");
                String tempString = input.next();
                BigDecimal subMoney= new BigDecimal(tempString);
                int judge = subMoney.compareTo(BigDecimal.ZERO);
                if (judge <= 0){
                    System.out.println("取出金额非法");//<=0
                    break;
                }else{
                    System.out.print("请输入账户密码：");
                    String inputPwd = input.next();
                    if (x.getAccountPwd().equals(inputPwd)){
                        judge = subMoney.compareTo(x.getBalance());
                        if (judge <= 0){
                            BigDecimal sum = x.getBalance().subtract(subMoney);
                            x.setBalance(sum);
                            System.out.println("取出"+x.getAccountName()+"账户"+subMoney+"金额成功，卡内余额为"+sum);
                        }else{
                            System.out.println("取出金额不足，卡内剩余余额为"+x.getBalance());
                        }
                    }else{
                        System.out.println("密码错误");
                    }
                }
                findFlag = true;
                break;
            }
        }
        if (!findFlag){
            System.out.println("查找失败");
        }
        backMenu();
    }

    private void saveAccountMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入存入用户ID");
        String tempAccountID= input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountID)) {
                System.out.println("查找成功");
                System.out.print("请输入存入金额");
                String tempString = input.next();
                BigDecimal saveMoney= new BigDecimal(tempString);
                int judge = saveMoney.compareTo(BigDecimal.ZERO);
                if (judge<=0){
                    System.out.println("存入金额非法");
                    break;
                }else{
                    System.out.print("请输入账户密码：");
                    String inputPwd = input.next();
                    if (x.getAccountPwd().equals(inputPwd)){
                        BigDecimal sum = x.getBalance().add(saveMoney);
                        x.setBalance(sum);
                        System.out.println("存入"+x.getAccountName()+"账户"+saveMoney+"金额成功，卡内余额为"+sum);
                    }else{
                        System.out.println("密码错误");
                    }
                }
                findFlag = true;
                break;
            }
        }
        if (!findFlag){
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
        String tempString = input.next();
        BigDecimal tempBalance= new BigDecimal(tempString);
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
        System.out.println("账户名\t账户ID\t账户密码\t账户余额");
        for (Account x:userData) {
            System.out.print(x.getAccountName()+"\t\t"+x.getAccountId()+"\t\t"+x.getAccountPwd()+"\t\t"+x.getBalance());
            System.out.println();
        }
        backMenu();
    }
}
