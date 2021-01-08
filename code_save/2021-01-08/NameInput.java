import java.util.Scanner;

public class NameInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strArray = new String[50];
        int count = 0;
        String name = "";
        String judge = "";
        do {
            System.out.println("请输入姓名：");
            name = input.next();
            System.out.println("您的姓名是："+name);
            strArray[count]=name;
            count++;
            System.out.print("是否继续<y/n>");
            judge = input.next();
        }while(judge.equals("y"));
        System.out.println("程序结束");
        for(String x : strArray){
            if (x == null) {
                break;
            }
            System.out.println(x);
        }
    }
}
