package stu;

import java.util.Scanner;

public class StudentManager {
    Student[] stus = new Student[10];
    //Student stu=new Student();
    Scanner input = new Scanner(System.in);
    //定义一个对象作为返回值和参数的方法
    public Student showInfos(Student stu2) {
        stu2.name="张三";
        stu2.age=18;
        return  stu2;
    }
    public void inputInfos () {
        for (int i = 0; i < stus.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个姓名");
            String name = input.next();
            System.out.println("请输入第" + (i + 1) + "个年龄");
            int age = input.nextInt();
            //stu[i];代表一个对象的位置，需要NEW一下才能给该位置生成一个对象
            //Student stu=null;
            stus[i] = new Student();
            //存入数组
            stus[i].name = name;
            stus[i].age = age;
        }
    }
}
