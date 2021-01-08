import java.util.Scanner;

public class ScoreJudge {
    public static void main(String[] args) {
        System.out.println("请输入成绩");
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();
        String grade = "";
        if (score>90){
            grade="A";
        }else if (score>75){
            grade="B";
        }else if (score>60){
            grade="C";
        }else {
            grade="D";
        }
        System.out.println("成绩为"+grade);
    }
}
