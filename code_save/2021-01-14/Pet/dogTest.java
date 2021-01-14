package Pet;

import java.util.Scanner;

public class dogTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] type = {"聪明的拉布拉多犬","酷酷的雪纳瑞"};
        System.out.println("欢迎您来到宠物店");
        System.out.print("请输入要领养宠物的名字：");
        String name = input.next();
        System.out.print("请选择狗狗的品种");
        int typeInput = input.nextInt();
        System.out.print("请选择狗狗的健康值(1-100之间)");
        int health = input.nextInt();
        dog dog = new dog(name,type[typeInput-1],health);
        dog.show();
    }
}
