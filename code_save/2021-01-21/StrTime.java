import java.util.Scanner;
public class StrTime {
    public static void main(String[] args){
        System.out.println("请输入字符串");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.println("请输入一个字符");
        char c = input.next().charAt(0);
        int count=0;
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)==c)
                count++;
        System.out.println(count);
    }
}