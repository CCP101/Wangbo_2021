import java.util.Scanner;

public class NameInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strArray = new String[50];
        int count = 0;
        String name = "";
        String judge = "";
        do {
            System.out.println("������������");
            name = input.next();
            System.out.println("���������ǣ�"+name);
            strArray[count]=name;
            count++;
            System.out.print("�Ƿ����<y/n>");
            judge = input.next();
        }while(judge.equals("y"));
        System.out.println("�������");
        for(String x : strArray){
            if (x == null) {
                break;
            }
            System.out.println(x);
        }
    }
}
