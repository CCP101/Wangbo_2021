package Pet;

import java.util.Scanner;

public class dogTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] type = {"��������������Ȯ","����ѩ����"};
        System.out.println("��ӭ�����������");
        System.out.print("������Ҫ������������֣�");
        String name = input.next();
        System.out.print("��ѡ�񹷹���Ʒ��");
        int typeInput = input.nextInt();
        System.out.print("��ѡ�񹷹��Ľ���ֵ(1-100֮��)");
        int health = input.nextInt();
        dog dog = new dog(name,type[typeInput-1],health);
        dog.show();
    }
}
