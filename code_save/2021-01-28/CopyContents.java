import java.io.*;

public class CopyContents {
    public static void main(String[] args) throws IOException {
        String contentFrom = "src/main/resources/test1.txt";
        String contentTo = "src/main/resources/target.txt";
        copyFile(contentFrom,contentTo);
    }

    /** 实现文件之间的内容复制
     * @param contentFrom 拷贝内容文件
     * @param contentTo   拷贝目标文件
     * @throws IOException 抛出文件异常
     */
    private static void copyFile(String contentFrom, String contentTo) throws IOException {
        BufferedReader br = null;
        BufferedWriter brTo = null;
        try {
            br = new BufferedReader(new FileReader(contentFrom));
            brTo = new BufferedWriter(new FileWriter(contentTo));
            String line = "";
            while ((line = br.readLine()) != null) {
                brTo.write(line);
                brTo.newLine();
                brTo.flush();
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null && brTo != null) {
                br.close();
                brTo.close();
            }
        }
    }
}
