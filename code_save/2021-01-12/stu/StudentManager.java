package stu;

import java.util.Scanner;

public class StudentManager {
    Student[] stus = new Student[10];
    //Student stu=new Student();
    Scanner input = new Scanner(System.in);
    //����һ��������Ϊ����ֵ�Ͳ����ķ���
    public Student showInfos(Student stu2) {
        stu2.name="����";
        stu2.age=18;
        return  stu2;
    }
    public void inputInfos () {
        for (int i = 0; i < stus.length; i++) {
            System.out.println("�������" + (i + 1) + "������");
            String name = input.next();
            System.out.println("�������" + (i + 1) + "������");
            int age = input.nextInt();
            //stu[i];����һ�������λ�ã���ҪNEWһ�²��ܸ���λ������һ������
            //Student stu=null;
            stus[i] = new Student();
            //��������
            stus[i].name = name;
            stus[i].age = age;
        }
    }
}
