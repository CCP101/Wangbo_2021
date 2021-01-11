import java.util.Scanner;

public class number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] score = new int[100];
        System.out.print("请输入人数");
        int count = input.nextInt();
        int sum = 0;
        for (int i = 0; i < count; i++){
            System.out.print("请输入成绩");
            score[i] = input.nextInt();
            sum += score[i];
        }
        double avg = (float)sum/count;
        System.out.println("人数为"+count+"\t总和为"+sum+"\t平均分为"+avg);
    }
}
