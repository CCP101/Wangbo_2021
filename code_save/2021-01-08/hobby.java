import java.util.Scanner;

public class hobby {
    public static void main(String[] args) {
        System.out.println("请输入总分与爱好");
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();
        String hobby = input.next();
        if (score>500){
            if (hobby.equals("java")){
                System.out.println("进入快班学习jsp与SSH");
            }else if (hobby.equals("C#")){
                System.out.println("进入快班学习ASP.NET");
            }else{
                System.out.println("输入爱好不匹配");
            }
        }else if(score>0){
            if (hobby.equals("java")){
                System.out.println("进入慢班学习jsp与SSH");
            }else if (hobby.equals("C#")){
                System.out.println("进入慢班学习ASP.NET");
            }else{
                System.out.println("输入爱好不匹配");
            }
        }else{
            System.out.println("输入成绩不匹配");
        }
    }
}
