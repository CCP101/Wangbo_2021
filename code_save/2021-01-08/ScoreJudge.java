import java.util.Scanner;

public class ScoreJudge {
    public static void main(String[] args) {
        System.out.println("������ɼ�");
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();
        String grade = "";
        if (score>90){
            grade= "code_save/2021-02-02/A";
        }else if (score>75){
            grade="B";
        }else if (score>60){
            grade="C";
        }else {
            grade="D";
        }
        System.out.println("�ɼ�Ϊ"+grade);
    }
}
