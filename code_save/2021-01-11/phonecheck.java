import java.util.Arrays;
import java.util.Scanner;

public class phonecheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] phones = {"iphone4","iphones4s","iphone5"};
        System.out.println(Arrays.toString(phones));
        System.out.print("����������ַ�");
        String text = input.next();
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].equals(text)){
                System.out.println("���ҳɹ�");
                break;
            }else if (i== phones.length-1){
                System.out.println("�Ҳ�������");
            }
        }
    }
}
