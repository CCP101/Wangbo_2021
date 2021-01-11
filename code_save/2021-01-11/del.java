import java.util.Arrays;
import java.util.Scanner;

public class del {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String[] phones={"iphone4","iphone4s","iphone5"};
        System.out.println("原数组:"+ Arrays.toString(phones));
        System.out.println("请输入你要删除第几个：");
        int index= input.nextInt();
        if(index>phones.length-1||index<0){
            System.out.println("输入错误");
        }else
            phones[index-1]=phones[phones.length-1];
        phones =Arrays.copyOf(phones,phones.length-1);
        System.out.println("删除后的数组；"+Arrays.toString(phones));

    }
}