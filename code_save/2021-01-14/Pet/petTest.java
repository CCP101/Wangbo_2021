import java.util.Scanner;

public class petTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("��ӭ�����������");
        System.out.print("������Ҫ������������֣�");
        String name = input.next();
        System.out.print("��ѡ�������Ա�");
        int typeInput = input.nextInt();
        String description = "";
        if (typeInput!=1){
            description = "Q��";
        }else{
            description = "Q��";
        }
        NewPet pet = new NewPet(name,description);
        pet.show();
    }
}
