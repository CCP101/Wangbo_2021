package StuEnum;

import java.util.Scanner;

public class Student {
    String name ;
    SexEnum sex;

    public Student(String name, SexEnum sex) {
        this.name = name;
        this.sex = sex;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入姓名及性别");
        String name = input.next();
        String sex = input.next();
        if (sex.equals("boy")){
            Student student = new Student(name,SexEnum.boy);
        }else{
            Student student = new Student(name,SexEnum.girl);
        }
    }
}
