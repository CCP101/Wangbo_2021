import java.util.Scanner;

public class shopping {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String shoppingCheck = "";
        int clothes_sum = 0;
        int checkFlag = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("��"+(i+1)+"�����̣���ѡ������뿪(y/n)");
            shoppingCheck = input.next();
            if (shoppingCheck.equals("y")){
                System.out.print("�����빺������");
                int clothes = input.nextInt();
                if (clothes<=3){
                    clothes_sum+=clothes;
                }else{
                    System.out.println("���ֳ���");
                    checkFlag = 1;
                    break;
                }
            }
        }
        if (checkFlag != 1){
            System.out.println("�ܹ�����"+clothes_sum+"���·�");
        }else{
            System.out.println("����Υ���淶");
        }
    }
}
