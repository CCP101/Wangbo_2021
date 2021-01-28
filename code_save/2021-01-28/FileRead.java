import java.io.*;

public class FileRead {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("code_save/2021-01-28/test.txt",true);
        FileInputStream inputStream = new FileInputStream("code_save/2021-01-28/test.txt");
        try{
            String word="Hello World\r";
            outputStream.write(word.getBytes());
            outputStream.flush();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len=inputStream.read(buf))!=-1){
                System.out.print(new String(buf,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            inputStream.close();
            outputStream.close();
        }

    }
}
