import java.util.Arrays;
import java.util.Scanner;

public class randomCreat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入范围与个数");
        int range = input.nextInt();
        int number = input.nextInt();
        if (range>=number){
            int[] array = randomNumber(range,number);
            System.out.println(Arrays.toString(array));
        }else{
            System.out.println("范围出错");
        }
    }

    private static int[] randomNumber(int range,int number) {
        int[] arrayNum = new int[number];
        for (int i = 0; i < number; i++) {
            int insertFlag = 0;
            int temp = (int) (Math.random() * range + 1);
            for (int j = 0; j <= i; j++) {
                if (arrayNum[j]==temp){
                    insertFlag = 1;
                    i--;
                    break;
                }
            }
            if(insertFlag!=1){
                arrayNum[i] = temp;
            }
        }
        return arrayNum;
    }
}
