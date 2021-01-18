package pet;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] type = {"聪明的拉布拉多犬","酷酷的雪纳瑞"};
        System.out.println("欢迎您来到宠物店！");
        System.out.print("请输入要领养宠物的名字：");
        String name = input.next();
        System.out.print("请选择要领养的宠物类型(1、小狗 2、企鹅 3、小猫)");
        int pet = input.nextInt();
        if (pet == 1) {
            System.out.print("请选择狗狗的品种");
            int typeInput = input.nextInt();
            System.out.print("请选择狗狗的健康值(1-100之间)");
            int health = input.nextInt();
            if (health<1||health>100) health = 60;
            System.out.println("健康值应该在0至100之间，默认值为60。");
            Dog dog = new Dog(name,health,0,type[typeInput-1]);
            dog.eat();
            dog.play(dog);
            dog.print();
        }else if (pet == 2){
            System.out.print("请选择企鹅的性别（1、Q仔 2、Q妹）");
            int sex = input.nextInt();
            Penguin penguin = new Penguin(name,100,20,sex);
            penguin.eat();
            penguin.play(penguin);
            penguin.print();
        }else if (pet == 3){
            Pet cat = new Cat(name,80,20);
            cat.eat();
            cat.print();
        }
    }
}
