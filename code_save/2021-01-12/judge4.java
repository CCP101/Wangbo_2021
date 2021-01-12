import java.util.Arrays;
import java.util.Scanner;

public class judge4 {
    public static void main(String[] args) {
        int[] array = new int[4];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i]= input.nextInt();
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
