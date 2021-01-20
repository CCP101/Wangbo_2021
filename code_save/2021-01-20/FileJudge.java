package com.ccp101.JavaLearning;

import java.util.Scanner;

public class FileJudge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入文件名称：");
        String file = input.next();
        int dot = file.indexOf('.');
        if (dot!=-1){
            file = file.substring(dot+1);
            if (file.toLowerCase().equals("java")) {
                System.out.println("文件名称合法");
            }else{
                System.out.println("文件名称不合法");
            }
        }else{
            System.out.println("文件名称不合法");
        }
    }
}
