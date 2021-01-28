import java.io.*;
import java.util.ArrayList;

public class StreamRead {
    public static void main(String[] args) throws IOException {
        String contentFrom = "src/main/resources/test.txt";
        ArrayList<String> fileContent = new ArrayList<>();
        readFile(contentFrom,fileContent);
        for (String s : fileContent) {
            System.out.println(s);
        }
    }

    private static void readFile(String fileName, ArrayList<String> fileContent) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = br.readLine()) != null) {
                fileContent.add(line);
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
