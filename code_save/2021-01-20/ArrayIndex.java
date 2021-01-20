import java.util.Scanner;

public class ArrayIndex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 4; i++) {
            System.out.print("请输入"+(i+1)+"个数字:");
            try {
                arr[i]= in.nextInt();
            } catch (Exception e) {
                System.out.println("数组越界");
                e.printStackTrace();
            }
        }
    }
}

