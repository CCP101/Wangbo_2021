import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        System.out.println("请输入数字选择功能 1.登录 2.退出");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        switch (choose){
            case 1:
                System.out.println("请输入用户名和数字");
                String user = null;
                user = input.next();
                String password = null;
                password = input.next();
                if (user.equals("admin") && password.equals("admin")) {
                    System.out.println("登陆成功");
                }else if(!password.equals("admin")){
                    System.out.println("密码错误");
                }else{
                    System.out.println("登陆失败");
                }
            case 2:
                System.out.println("退出系统");
            default:break;
        }
    }
}
