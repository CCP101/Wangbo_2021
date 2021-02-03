import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class NameSearch {
    static HashMap<String,Integer> stuMap = new HashMap<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/student.txt"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] parameter = line.split("=");
                stuMap.put(parameter[0], Integer.valueOf(parameter[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        show();
    }

    public static void show(){
        System.out.println("1.根据姓名查询年龄 2.根据年龄查询姓名 3.退出");
        System.out.print("请输入数字选择功能");
        int num = input.nextInt();
        switch (num){
            case 1:
                System.out.print("请输入姓名：");
                String name = input.next();
                if (stuMap.containsKey(name)){
                    System.out.println(name+"年龄为"+stuMap.get(name));
                }else{
                    System.out.println("不存在");
                }
                show();
                break;
            case 2:
                System.out.print("请输入年龄：");
                int age = input.nextInt();
                System.out.println("查询结果：年龄为"+age+"岁的人员信息如下：");
                for (String i : stuMap.keySet()) {
                    if (stuMap.get(i)==age){
                        System.out.println(i);
                    }
                }
                show();
                break;
            case 3:
                System.out.println("欢迎下次再来，拜拜");
                System.exit(0);
        }
    }
}
