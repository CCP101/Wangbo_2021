package teacher;

import java.util.Scanner;

public class teacherTest {
    public static void main(String[] args) {
        teacherInformation teacher = new teacherInformation();
        Scanner input = new Scanner(System.in);
        System.out.println("第1种构造方法");
        System.out.print("请输入姓名:");
        String name = input.next();
        System.out.print("请输入年龄：");
        int age = input.nextInt();
        teacherInformation stu1 = new teacherInformation(name,age);
        System.out.println("第2种构造方法");
        System.out.print("请输入姓名:");
        name = input.next();
        System.out.print("请输入年龄：");
        age = input.nextInt();
        System.out.print("请输入性别:");
        String sex = input.next();
        System.out.print("请输入专业:");
        String pro = input.next();
        teacherInformation stu2 = new teacherInformation(name,age,sex,pro);
        stu1.showInfo();
        stu2.showInfo();
    }
}
