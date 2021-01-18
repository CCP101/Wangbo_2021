package Shape;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("请输入长方形的长与宽");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        Rect rect = new Rect();
        rect.setHeight(a);
        rect.setWidth(b);
        int result = rect.getArea();
        System.out.println("长方形面积为："+result);
    }
}
