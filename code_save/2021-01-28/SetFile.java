import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SetFile {
    public static void main(String[] args) throws IOException {
        String[] str= {"a","b","c","d","e"};
        String[] str1= {"d","e","f","g","h"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(str));
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(str1));
        for (String s : list1) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }
        String content = list.toString();
        BufferedWriter br = null;
        try {
            br = new BufferedWriter(new FileWriter("src/main/resources/target.txt",true));
            br.write(content);
            br.newLine();
            br.flush();
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
