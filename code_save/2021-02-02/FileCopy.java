import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String pathName = input.nextLine();
        File source = new File(pathName);
        File dest = new File("D:\\java");
        try {
            FileUtils.copyDirectory(source, dest);
            System.out.println("文件夹复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
