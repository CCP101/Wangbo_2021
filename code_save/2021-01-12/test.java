import java.util.Scanner;

public class test {
    static class admin{
        String name = "admin";
        String pwd = "125";
    }

    public static void main(String[] args) {
        admin p1 = new admin();
        Scanner input = new Scanner(System.in);
        String inputName = input.next();
        String inputPwd = input.next();
        if (p1.name.equals(inputName)&&p1.pwd.equals(inputPwd)){
            System.out.println("������������");
            p1.pwd = inputPwd;
        }else{
            System.out.println("�û��������벻ƥ��");
        }
    }
}
