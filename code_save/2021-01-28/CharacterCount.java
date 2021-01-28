import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("请输入欲查找的字符");
            String check = input.next();
            br = new BufferedReader(new FileReader("src/main/resources/test.txt"));
            String line = "";
            int count = 0;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (i + check.length() <= line.length() && (check.equals(line.substring(i, i + check.length())))){
                        count++;
                    }
                }
            }
            System.out.println(check+"字符串出现了"+count+"次");
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
