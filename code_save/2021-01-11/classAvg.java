import java.util.Scanner;

public class classAvg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] grade = new int[3][4];
        for (int i = 0; i < grade.length; i++) {
            int sum = 0;
            int goodScore = 0;
            for (int j = 0; j < grade[i].length; j++) {
                System.out.print("请输入"+(i+1)+"班"+(j+1)+"学生成绩：");
                grade[i][j] = input.nextInt();
                sum+=grade[i][j];
                if (grade[i][j]>85){
                    goodScore++;
                }
            }
            double avg = (float)sum/4;
            System.out.println((i+1)+"班平均分为:"+avg+"\t优秀成绩人数为:"+goodScore);
        }
    }
}
