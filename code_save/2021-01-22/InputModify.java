import java.util.Scanner;

public class InputModify {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入字符串");
        String text = input.next();
        if (text.length()>=8){
            text = text.replaceAll("[A-Z]","M");
        }else{
            throw new Exception("长度非法");
        }
        System.out.println("结果："+text);
    }
}
