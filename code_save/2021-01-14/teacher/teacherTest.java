package teacher;

import java.util.Scanner;

public class teacherTest {
    public static void main(String[] args) {
        teacherInformation teacher = new teacherInformation();
        Scanner input = new Scanner(System.in);
        System.out.println("��1�ֹ��췽��");
        System.out.print("����������:");
        String name = input.next();
        System.out.print("���������䣺");
        int age = input.nextInt();
        teacherInformation stu1 = new teacherInformation(name,age);
        System.out.println("��2�ֹ��췽��");
        System.out.print("����������:");
        name = input.next();
        System.out.print("���������䣺");
        age = input.nextInt();
        System.out.print("�������Ա�:");
        String sex = input.next();
        System.out.print("������רҵ:");
        String pro = input.next();
        teacherInformation stu2 = new teacherInformation(name,age,sex,pro);
        stu1.showInfo();
        stu2.showInfo();
    }
}
