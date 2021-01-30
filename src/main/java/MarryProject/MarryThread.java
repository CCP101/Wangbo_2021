package MarryProject;

import java.io.IOException;
import java.util.Scanner;

public class MarryThread implements Runnable {
    Scanner input = new Scanner(System.in);
    MarrySystem system = new MarrySystem();
    @Override
    public void run() {
        try {
            system.initInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("系统开始配对，请输入次数：");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            system.cp();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            system.end();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
