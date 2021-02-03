import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num = input.nextInt();
            if (num<=10){
                numList.add(num);
            }
        }
        String text = Arrays.toString(numList.toArray());
        try (BufferedWriter br = new BufferedWriter(new FileWriter("src/main/resources/output.txt"))) {
                br.write(text);
                br.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
