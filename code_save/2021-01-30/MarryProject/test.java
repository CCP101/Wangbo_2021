package MarryProject;

import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MarrySystem system = new MarrySystem();
        //Lambda表达式，不推荐原写法
        Runnable r = ()->{
            try{
                system.initInput();
                System.out.print("系统开始配对，请输入次数：");
                int num = input.nextInt();
                for (int i = 0; i < num; i++) {
                    system.cp();
                    Thread.sleep(1000); //1s
                }
                system.end();
            }catch (InternalError | IOException | InterruptedException e){
                e.printStackTrace();
            }
        };
        var t = new Thread(r);
        t.start();
    }
}
