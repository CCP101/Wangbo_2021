package com.ccp101.JavaLearning;

import java.util.Scanner;

public class MailJudge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入邮箱地址：");
        String mail = input.next();
        int symbol = mail.indexOf("@");
        if (symbol!=-1&&symbol!=0){
            mail = mail.substring(symbol+1);
            symbol = mail.indexOf(".");
            mail = mail.substring(symbol+1);
            if (symbol!=-1&&symbol!=0&&mail.equals("com")){
                System.out.println("邮箱格式合法");
            }else{
                System.out.println("邮箱格式不合法");
            }
        }else{
            System.out.println("邮箱格式不合法");
        }
    }
}
