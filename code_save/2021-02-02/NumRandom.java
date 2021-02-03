import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NumRandom {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>();
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            numList.add((int) (Math.random() * 100));
        }
        for (int i = 0; i < 10; i++) {
            numMap.put(i,(int) (Math.random() * 100));
        }
        String listPrint = Arrays.toString(numList.toArray());
        String mapPrint = Arrays.toString(numMap.values().toArray(new Integer[0]));
        try (BufferedWriter br = new BufferedWriter(new FileWriter("src/main/resources/output.txt"))) {
            br.write(listPrint);
            br.newLine();
            br.write(mapPrint);
            br.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
