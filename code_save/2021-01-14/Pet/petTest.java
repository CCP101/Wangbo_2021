import java.util.Scanner;

public class petTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎您来到宠物店");
        System.out.print("请输入要领养宠物的名字：");
        String name = input.next();
        System.out.print("请选择企鹅的性别");
        int typeInput = input.nextInt();
        String description = "";
        if (typeInput!=1){
            description = "Q妹";
        }else{
            description = "Q仔";
        }
        NewPet pet = new NewPet(name,description);
        pet.show();
    }
}
