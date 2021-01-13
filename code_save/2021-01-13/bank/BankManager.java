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
            System.out.println(rootAccount+"�˻���½�ɹ�");
            return true;
        }
        System.out.println("�������");
        return false;
    }

    public void showMenu() {
        System.out.println("====================================");
        System.out.println("0����ʾ�����˻� 1������˻� 2����Ǯ 3��ȡǮ 4��ת�� 5���޸����� 6������ 7���˳�ϵͳ");
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
                transMoney();
                break;
            case 5:
                updatePwd();
                break;
            case 6:
                deletePwd();
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

    private void transMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("������ת���û�ID");
        String TransferID1 = input.next();
        System.out.print("������ת���û�ID");
        String TransferID2 = input.next();
        boolean findFlag1 = false;
        boolean findFlag2 = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(TransferID1)) {
                for (Account y:userData) {
                    if (y.getAccountId().equals(TransferID2)) {
                        //�����ж�
                        System.out.print("������ת�����");
                        String tempString = input.next();
                        BigDecimal subMoney= new BigDecimal(tempString);
                        int judge = subMoney.compareTo(BigDecimal.ZERO);
                        if (judge <= 0){
                            System.out.println("ת�����Ƿ�");
                            break;
                        }else{
                            judge = subMoney.compareTo(x.getBalance());
                            if (judge <= 0){
                                System.out.print("������ת���˻�����");
                                String tempPwd = input.next();
                                if (x.getAccountPwd().equals(tempPwd)){
                                    System.out.println("����ɹ�");
                                    BigDecimal sum = x.getBalance().subtract(subMoney);
                                    x.setBalance(sum);
                                    BigDecimal sum2 = y.getBalance().add(subMoney);
                                    y.setBalance(sum2);
                                    System.out.printf("ת��%s�˻���%s�˻�%s���ɹ���", x.getAccountName(), y.getAccountId(), subMoney);
                                    System.out.printf("ת���˻��������Ϊ%s��ת���˻��������Ϊ%s%n", sum, sum2);
                                }else{
                                    System.out.println("ת���˻��������");
                                }
                            }else{
                                System.out.println("ȡ������,����ʣ����Ϊ"+x.getBalance());
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
            System.out.println("ת���˻�����ʧ��");
        }
        if (!findFlag2){
            System.out.println("ת���˻�����ʧ��");
        }
        backMenu();
    }

    private void updatePwd() {
        Scanner input = new Scanner(System.in);
        System.out.print("�������û�ID");
        String tempAccountID = input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountID)) {
                System.out.println("���ҳɹ�");
                System.out.print("����������ȷ��");
                String tempAccountPwd = input.next();
                if (x.getAccountPwd().equals(tempAccountPwd)){
                    System.out.println("��½�ɹ�");
                    String newPwd1;
                    String newPwd2;
                    boolean repeatFlag = false;
                    do{
                        if (repeatFlag)
                            System.out.println("У�������������������");
                        System.out.print("������������");
                        newPwd1 = input.next();
                        System.out.print("��ȷ��������");
                        newPwd2 = input.next();
                        repeatFlag = !newPwd1.equals(newPwd2);
                    }while (repeatFlag);
                    x.setAccountPwd(newPwd1);
                    System.out.println("�޸�"+tempAccountID+"�˻�����ɹ�");
                }else{
                    System.out.println("�������");
                }
                findFlag = true;
                break;
            }
        }
        if (!findFlag){
            System.out.println("����ʧ��");
        }
        backMenu();
    }

    private void deletePwd() {
        Scanner input = new Scanner(System.in);
        System.out.print("������ɾ���û�ID");
        String tempAccountID = input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountID)) {
                System.out.println("���ҳɹ�");
                System.out.print("����������ȷ��");
                String tempAccountPwd = input.next();
                if (x.getAccountPwd().equals(tempAccountPwd)){
                    userData.remove(x);
                    System.out.println("ɾ��"+tempAccountID+"�˻��ɹ�");
                }else{
                    System.out.println("�������");
                }
                findFlag = true;
                break;
            }
        }
        if (!findFlag){
            System.out.println("����ʧ��");
        }
        backMenu();
    }

    private void getMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("������ȡ���û�ID");
        String tempAccountID= input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountID)) {
                System.out.println("���ҳɹ�");
                System.out.print("������ȡ�����");
                String tempString = input.next();
                BigDecimal subMoney= new BigDecimal(tempString);
                int judge = subMoney.compareTo(BigDecimal.ZERO);
                if (judge <= 0){
                    System.out.println("ȡ�����Ƿ�");//<=0
                    break;
                }else{
                    System.out.print("�������˻����룺");
                    String inputPwd = input.next();
                    if (x.getAccountPwd().equals(inputPwd)){
                        judge = subMoney.compareTo(x.getBalance());
                        if (judge <= 0){
                            BigDecimal sum = x.getBalance().subtract(subMoney);
                            x.setBalance(sum);
                            System.out.println("ȡ��"+x.getAccountName()+"�˻�"+subMoney+"���ɹ����������Ϊ"+sum);
                        }else{
                            System.out.println("ȡ�����㣬����ʣ�����Ϊ"+x.getBalance());
                        }
                    }else{
                        System.out.println("�������");
                    }
                }
                findFlag = true;
                break;
            }
        }
        if (!findFlag){
            System.out.println("����ʧ��");
        }
        backMenu();
    }

    private void saveAccountMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("����������û�ID");
        String tempAccountID= input.next();
        boolean findFlag = false;
        for (Account x:userData) {
            if (x.getAccountId().equals(tempAccountID)) {
                System.out.println("���ҳɹ�");
                System.out.print("�����������");
                String tempString = input.next();
                BigDecimal saveMoney= new BigDecimal(tempString);
                int judge = saveMoney.compareTo(BigDecimal.ZERO);
                if (judge<=0){
                    System.out.println("������Ƿ�");
                    break;
                }else{
                    System.out.print("�������˻����룺");
                    String inputPwd = input.next();
                    if (x.getAccountPwd().equals(inputPwd)){
                        BigDecimal sum = x.getBalance().add(saveMoney);
                        x.setBalance(sum);
                        System.out.println("����"+x.getAccountName()+"�˻�"+saveMoney+"���ɹ����������Ϊ"+sum);
                    }else{
                        System.out.println("�������");
                    }
                }
                findFlag = true;
                break;
            }
        }
        if (!findFlag){
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
        System.out.println("�˻���\t�˻�ID\t�˻�����\t�˻����");
        for (Account x:userData) {
            System.out.print(x.getAccountName()+"\t\t"+x.getAccountId()+"\t\t"+x.getAccountPwd()+"\t\t"+x.getBalance());
            System.out.println();
        }
        backMenu();
    }
}
