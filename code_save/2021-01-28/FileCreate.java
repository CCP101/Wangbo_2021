import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/resources/test.txt"));
            char check1 = 'A';
            char check2 = 'a';
            String line = "";
            int count1 = 0;
            int count2 = 0;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char temp = line.charAt(i);
                    if (check1==temp){
                        count1++;
                    }else if (check2==temp){
                        count2++;
                    }
                }
            }
            System.out.println(check1+"字符串出现了"+count1+"次");
            System.out.println(check2+"字符串出现了"+count2+"次");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
