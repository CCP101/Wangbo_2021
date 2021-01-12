package stu;

public class stuTest {
    public static void main(String[] args) {
        StudentManager stuMa =new StudentManager();
        stuMa.inputInfos();
        System.out.println(stuMa.stus[0].name);
    }
}
