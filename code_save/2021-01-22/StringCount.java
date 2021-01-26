import java.util.Scanner;

public class StringCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入字符串");
        String text = input.next();
        int numCount = 0;
        int bcCount = 0;
        int scCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char temp = text.charAt(i);
            if (temp>='A'&&temp<='Z'){
                bcCount++;
            }else if(temp>='a'&&temp<='z'){
                scCount++;
            }else if (temp>='0'&&temp<='9'){
                numCount++;
            }
        }
        System.out.println("数字个数："+numCount);
        System.out.println("大写字符个数："+bcCount);
        System.out.println("小写字符个数："+scCount);
    }
}
