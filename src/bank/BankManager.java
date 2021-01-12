package bank;

import java.util.Scanner;
import java.util.Vector;

public class BankManager {
    private static final Vector<Account> userData = new Vector<>();
    String rootAccount = "root";
    String rootPwd = "ROOT";

    public boolean rootLoginCheck(String Pwd) {
        if (rootPwd.equals(Pwd)){
            System.out.println(rootAccount+"�˻���½�ɹ�");
            return true;
        }
        System.out.println("�������");
        return false;
    }

    public void showMenu() {
        System.out.println("====================================");
        System.out.println("0����ʾ�����˻�");
        System.out.println("1������˻�");
        System.out.println("2����Ǯ");
        System.out.println("3��ȡǮ");
        System.out.println("4��ת��");
        System.out.println("5���޸�����");
        System.out.println("6������");
        System.out.println("7���˳�ϵͳ");
        System.out.println("====================================");
        System.out.print("��ѡ��");
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
                System.out.println("�˳��ɹ�");
                System.exit(1);
            default:
                System.out.println("������������������");
                showMenu();
                break;
        }
    }

    private void getMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("������ȡ���û��˻���");
        String tempAccountName= input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountName)) {
                System.out.println("���ҳɹ�");
                System.out.print("������ȡ�����");
                double subMoney = input.nextDouble();
                if (subMoney<=0){
                    System.out.println("ȡ�����Ƿ�");
                    break;
                }else{
                    System.out.print("�������˻����룺");
                    String inputPwd = input.next();
                    if (x.getAccountPwd().equals(inputPwd)){
                        if (subMoney<=x.getBalance()){
                            double sum = x.getBalance() - subMoney;
                            // TODO: 2021/1/12 ���ȴ��� 
                            x.setBalance(sum);
                            System.out.println("ȡ��"+x.getAccountName()+"�˻�"+subMoney+"���ɹ����������Ϊ"+sum);
                        }else{
                            System.out.println("ȡ�����Ƿ�");
                        }
                    }else{
                        System.out.println("�������");
                    }
                }
                findFlag = true;
                break;
            }
        }if (!findFlag){
            System.out.println("����ʧ��");
        }
        backMenu();
    }

    private void saveAccountMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("����������û��˻���");
        String tempAccountName= input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountName)) {
                System.out.println("���ҳɹ�");
                System.out.print("�����������");
                double saveMoney = input.nextDouble();
                if (saveMoney<=0){
                    System.out.println("������Ƿ�");
                    break;
                }else{
                    System.out.print("�������˻����룺");
                    String inputPwd = input.next();
                    if (x.getAccountPwd().equals(inputPwd)){
                        double sum = x.getBalance() + saveMoney;
                        x.setBalance(sum);
                        System.out.println("����"+x.getAccountName()+"�˻�"+saveMoney+"���ɹ����������Ϊ"+sum);
                    }else{
                        System.out.println("�������");
                    }
                }
                findFlag = true;
                break;
            }
        }if (!findFlag){
            System.out.println("����ʧ��");
        }
        backMenu();
    }

    private void backMenu() {
        Scanner input = new Scanner(System.in);
        System.out.print("�Ƿ񷵻����˵�(0)");
        if (input.nextInt()==0){
            showMenu();
        }else{
            backMenu();
        }
    }

    private void addAccountInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("���������û��˻���");
        String tempAccountName= input.next();
        System.out.print("���������û��˻�ID");
        String tempAccountId = input.next();
        System.out.print("���������û��˻�����");
        String tempAccountPwd= input.next();
        System.out.print("���������û��˻����");
        double tempBalance= input.nextDouble();
        boolean duplicateFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountId)) {
                duplicateFlag = true;
                break;
            }
        }
        if (duplicateFlag){
            System.out.println("�û�ID�ظ�����������");
        }else{
            Account tempAccount = new Account();
            tempAccount.setAccountId(tempAccountId);
            tempAccount.setAccountName(tempAccountName);
            tempAccount.setAccountPwd(tempAccountPwd);
            tempAccount.setBalance(tempBalance);
            userData.add(tempAccount);
            System.out.println("��ӳɹ�");
        }
        backMenu();
    }

    private void showAllAccountInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("�˻���\t�˻�ID\t�˻�����\t�˻����");
        for (Account x:userData) {
            System.out.print(x.getAccountName()+"\t\t"+x.getAccountId()+"\t\t"+x.getAccountPwd()+"\t\t"+x.getBalance());
            System.out.println();
        }
        backMenu();
    }
}
