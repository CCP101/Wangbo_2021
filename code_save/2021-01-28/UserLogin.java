import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class UserLogin {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名与密码");
        String name = input.next();
        String pwd = input.next();
        HashMap<String,String> user = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/resources/user.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] tempUser = line.split(" ");
                user.put(tempUser[0],tempUser[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        if (user.containsKey(name)){
            if(user.get(name).equals(pwd)){
                System.out.println("登陆成功");
            }else{
                System.out.println("密码错误");
            }

        }else{
            System.out.println("用户名错误");
        }
    }
}
