import java.util.Scanner;

public class hobby {
    public static void main(String[] args) {
        System.out.println("�������ܷ��밮��");
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();
        String hobby = input.next();
        if (score>500){
            if (hobby.equals("java")){
                System.out.println("������ѧϰjsp��SSH");
            }else if (hobby.equals("C#")){
                System.out.println("������ѧϰASP.NET");
            }else{
                System.out.println("���밮�ò�ƥ��");
            }
        }else if(score>0){
            if (hobby.equals("java")){
                System.out.println("��������ѧϰjsp��SSH");
            }else if (hobby.equals("C#")){
                System.out.println("��������ѧϰASP.NET");
            }else{
                System.out.println("���밮�ò�ƥ��");
            }
        }else{
            System.out.println("����ɼ���ƥ��");
        }
    }
}
