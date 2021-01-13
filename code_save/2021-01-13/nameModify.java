import java.util.Arrays;
import java.util.Scanner;

public class nameModify {
    public static void main(String[] args) {
        String[] studentArray = new String[5];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("请输入学生姓名：");
            studentArray[i] = input.next();
        }
        System.out.println("本班学生列表：");
        for (String x:studentArray) {
            System.out.print(x+"\t");
        }
//        System.out.print("输入修改的学生姓名：");
//        String oldName = input.next();
//        System.out.print("输入新的学生姓名：");
//        String newName = input.next();
//        modifyStudent(oldName, newName, studentArray);
//        System.out.print("输入启示位置：");
//        int begin = input.nextInt();
//        System.out.print("输入结束位置：");
//        int end = input.nextInt();
//        System.out.print("输入学生姓名：");
//        String searchName = input.next();
//        searchStudent(begin,end,searchName,studentArray);
        Arrays.sort(studentArray);
        System.out.println(Arrays.toString(studentArray));
    }

    private static void searchStudent(int begin, int end, String searchName, String[] studentArray) {
        boolean FLAG = false;
        for (int i = begin-1; i < (end-1); i++) {
            if (studentArray[i].equals(searchName)){
                System.out.println("查找成功");
                FLAG = true;
            }
        }
        if (!FLAG){
            System.out.println("没查找到该学生");
        }
    }

    private static void modifyStudent(String oldName, String newName, String[] studentArray) {
        for (int i = 0; i < 5; i++) {
            if (studentArray[i].equals(oldName)){
                studentArray[i] = newName;
                System.out.println("替换成功");
            }
        }
        System.out.println("本班学生列表：");
        for (String x:studentArray) {
            System.out.print(x+"\t");
        }
    }
}
