import java.util.Scanner;

public class UserRegister {
    String usrName;
    String usrPwd;

    public UserRegister(String usrName, String usrPwd) {
        this.usrName = usrName;
        this.usrPwd = usrPwd;
    }

    public static void main(String[] args) {
        System.out.println("请输入用户名");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        if (name.length()>=3){
            System.out.println("请输入密码");
            String pwd1 = input.next();
            System.out.println("请确认密码");
            String pwd2 = input.next();
            if (pwd1.toLowerCase().equals(pwd2.toLowerCase())){
                UserRegister user = new UserRegister(name,pwd1);
            }else{
                System.out.println("密码验证失败");
            }
        }else{
            System.out.println("用户名不合法");
        }
    }
}
