import java.util.Arrays;
import java.util.Scanner;

public class del {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String[] phones={"iphone4","iphone4s","iphone5"};
        System.out.println("ԭ����:"+ Arrays.toString(phones));
        System.out.println("��������Ҫɾ���ڼ�����");
        int index= input.nextInt();
        if(index>phones.length-1||index<0){
            System.out.println("�������");
        }else
            phones[index-1]=phones[phones.length-1];
        phones =Arrays.copyOf(phones,phones.length-1);
        System.out.println("ɾ��������飻"+Arrays.toString(phones));

    }
}