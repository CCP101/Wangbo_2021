import java.util.Scanner;

public class number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] score = new int[100];
        System.out.print("����������");
        int count = input.nextInt();
        int sum = 0;
        for (int i = 0; i < count; i++){
            System.out.print("������ɼ�");
            score[i] = input.nextInt();
            sum += score[i];
        }
        double avg = (float)sum/count;
        System.out.println("����Ϊ"+count+"\t�ܺ�Ϊ"+sum+"\tƽ����Ϊ"+avg);
    }
}
