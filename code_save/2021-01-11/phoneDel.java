import java.util.Arrays;
import java.util.Scanner;

public class phoneDel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("������ɾ���ַ�");
        String text = input.next();
        String[] phones = {"iphone4","iphones4s","iphone5"};
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].equals(text)){
                System.out.println("���ҳɹ�");
                for (int j = i; j < phones.length-1; j++) {
                    int number = j+1;
                    phones[j]=phones[number];
                }
                break;
            }else if (i== phones.length-1){
                System.out.println("�Ҳ�����ɾ��������");
            }
        }
        phones = Arrays.copyOf(phones,phones.length-1);
        System.out.println(Arrays.toString(phones));
    }
}
